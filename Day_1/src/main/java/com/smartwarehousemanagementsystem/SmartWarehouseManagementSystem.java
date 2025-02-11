package com.smartwarehousemanagementsystem;


// Generic class for Storage
import java.util.ArrayList;
import java.util.List;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Subclasses for different warehouse item types
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}


class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class for displaying warehouse items
class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test the implementation
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 50000));
        electronicsStorage.addItem(new Electronics("Smartphone", 8000));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("mango", 90));
        groceriesStorage.addItem(new Groceries("Lassi", 50));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 250));
        furnitureStorage.addItem(new Furniture("Table", 1500));

        // Display items using wildcard method
        System.out.println("Electronics:");
        WarehouseUtility.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtility.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}
