package com.trywithresorces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        try {
            // Open the file for reading
            FileReader fr = new FileReader("C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_4\\src\\main\\java\\com\\trywithresorces\\info.txt");
            BufferedReader br = new BufferedReader(fr);

            // Read the first line from the file
            String line;
            line = br.readLine();

            // Print the line
            System.out.println(line);
        } catch (IOException e) {
            // Handle file read errors
            System.out.println("Error reading file"+ e.getMessage());
        }
    }
}
