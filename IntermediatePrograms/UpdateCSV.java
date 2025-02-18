package org.ioprogramming.IntermediatePrograms;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";  // Input CSV file
        String outputFilePath = "updated_employees.csv";  // Output CSV file

        List<String[]> records = new ArrayList<>();

        // Read the input CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            // Read the header row
            String header = br.readLine();
            records.add(header.split(",")); // Add header to the records list

            // Read and process the remaining lines
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Check if the department is "IT" and update the salary
                if (fields[1].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(fields[2].trim());
                    salary += salary * 0.10; // Increase salary by 10%
                    fields[2] = String.format("%.2f", salary); // Format salary to two decimal places
                }

                // Add the updated record to the list
                records.add(fields);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Write the updated records to the output CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : records) {
                bw.write(String.join(",", record)); // Join the fields with commas
                bw.newLine(); // Add a newline after each record
            }
            System.out.println("Updated records have been written to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

