package com.bytearraystream;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImage = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bytearraystream\\image.jpeg";
        String outputImage = "C:\\Users\\sarve\\Desktop\\week 4 pr\\Day_3\\src\\main\\java\\com\\bytearraystream\\output.jpeg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputImage);
            System.out.println("Image successfully converted to byte array. Size: " + imageBytes.length + " bytes");

            // Write byte array back to an image file
            writeByteArrayToImage(imageBytes, outputImage);
            System.out.println("Image successfully written back to file: " + outputImage);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Convert an image file to a byte array
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Write byte array back to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(imageBytes);
        }
    }
}
