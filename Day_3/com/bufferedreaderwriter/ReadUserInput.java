package com.bufferedreaderwriter;

import java.io.*;

public class ReadUserInput {
    public static void main(String[] args) {
        try {
            // Creating an InputStreamReader to read user input from the console
            InputStreamReader isr = new InputStreamReader(System.in);
            // Wrapping InputStreamReader with BufferedReader
            BufferedReader br = new BufferedReader(isr);

            // Creating a FileWriter to write data to the output file
            FileWriter fw = new FileWriter("C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bufferedreaderwriter\\output.txt");
            // Wrapping FileWriter with BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);

            String line; // Variable to store user input

            // Asking for user input and writing it to the file
            System.out.println("Enter your Name: ");
            line = br.readLine();  // Reading user input
            bw.write("Name: " + line);
            bw.newLine();

            System.out.println("Enter your Age: ");
            line = br.readLine();  // Reading user input
            bw.write("Age: " + line);
            bw.newLine();

            System.out.println("Enter your Favorite programming language: ");
            line = br.readLine();  // Reading user input
            bw.write("Programming language: " + line);
            bw.newLine();


            bw.close();
            br.close();

            System.out.println("Data successfully written to the file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
