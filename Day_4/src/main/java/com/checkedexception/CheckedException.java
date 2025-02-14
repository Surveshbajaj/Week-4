package com.checkedexception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) {
        try {
            // Open the file
            FileReader fr = new FileReader("");
            BufferedReader br = new BufferedReader(fr);

            // Read and print file content
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


            br.close();
            fr.close();
        }
        catch (IOException e) { // handle IOException
            System.out.println("File not found");
        }
    }
}
