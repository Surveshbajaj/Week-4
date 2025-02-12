package com.implementshoppingcart;

import java.util.*;

public class ImplementShoppingCart {
    HashMap<String, Double> productPrices; // Stores product prices
    LinkedHashMap<String, Integer> cart; // Maintains order of items added

    public ImplementShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();

        // Adding product prices to HashMap
        productPrices.put("Laptop", 75000.0);
        productPrices.put("Mouse", 1500.0);
        productPrices.put("Keyboard", 3000.0);
        productPrices.put("Headphones", 2500.0);
        productPrices.put("Monitor", 12000.0);
    }

    // Method to add a product to the cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
            System.out.println(quantity + " x " + product + " added to the cart.");
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Method to remove a product from the cart
    public void removeFromCart(String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            System.out.println(product + " removed from the cart.");
        } else {
            System.out.println("Product not found in cart: " + product);
        }
    }

    // Method to display items in the order they were added
    public void displayCart() {
        System.out.println("\nShopping Cart (Order of Addition):");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + ", Price: " + productPrices.get(entry.getKey()));
        }
    }

    // Method to display items sorted by price
    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("\n Products Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - Price:" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ImplementShoppingCart shoppingCart = new ImplementShoppingCart();

        // Adding products to the cart
        shoppingCart.addToCart("Laptop", 2);
        shoppingCart.addToCart("Mouse", 1);
        shoppingCart.addToCart("Keyboard", 1);
        shoppingCart.addToCart("Monitor", 1);

        // Display cart contents
        shoppingCart.displayCart();

        // Display items sorted by price
        shoppingCart.displaySortedByPrice();

        // Remove an item and show updated cart
        shoppingCart.removeFromCart("Mouse");
        shoppingCart.displayCart();
    }
}
