package org.ioprogramming.IntermediatePrograms;



import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortRecord {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Path to your CSV file
        List<String[]> records = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the header line
            String header = br.readLine();
            System.out.println(header); // Print the header (optional)

            // Read the remaining records
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                records.add(fields); // Add each record to the list
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort records by Salary in descending order
        records.sort((a, b) -> {
            double salaryA = Double.parseDouble(a[2].trim()); // Parse Salary from record A
            double salaryB = Double.parseDouble(b[2].trim()); // Parse Salary from record B
            return Double.compare(salaryB, salaryA); // Sort in descending order
        });

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("Name | Department | Salary");
        System.out.println("--------------------------");

        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] record = records.get(i);
            System.out.printf("%-5s | %-12s | %s%n", record[0].trim(), record[1].trim(), record[2].trim());
        }
    }
}

