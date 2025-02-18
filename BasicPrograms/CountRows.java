package org.ioprogramming.BasicPrograms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to your CSV file
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            // Count the rows
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

