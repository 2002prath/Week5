package org.ioprogramming.AdvancedProblems;
import java.io.*;
import java.util.*;

public class DetectDuplicatesInCSV {

        public static void main(String[] args) {
            String filePath = "students.csv"; // Path to your CSV file
            Set<String> seenIDs = new HashSet<>(); // Set to store unique IDs
            List<String> duplicateRecords = new ArrayList<>(); // List to store duplicate records

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                br.readLine(); // Read and ignore the header row

                // Read each line from the CSV
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String id = fields[0].trim(); // Extract the ID column

                    // Check if the ID has been seen before (duplicate)
                    if (seenIDs.contains(id)) {
                        // If duplicate, add the whole line to the duplicate records list
                        duplicateRecords.add(line);
                    } else {
                        // Otherwise, add the ID to the set
                        seenIDs.add(id);
                    }
                }

                // Print all duplicate records
                if (duplicateRecords.isEmpty()) {
                    System.out.println("No duplicates found.");
                } else {
                    System.out.println("Duplicate Records:");
                    for (String record : duplicateRecords) {
                        System.out.println(record);
                    }
                }

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
    }


