package org.ioprogramming.AdvancedProblems;
import java.io.*;

public class ReadLargeFiles {




        public static void main(String[] args) {
            String filePath = "large_students.csv"; // Path to your large CSV file
            int chunkSize = 100; // Number of lines to read at a time
            int processedRecords = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int currentChunkSize = 0;

                // Read the file line by line
                while ((line = br.readLine()) != null) {
                    currentChunkSize++;

                    // Process the line (for example, print or store in a list)
                    // Here we are just printing the current chunk size
                    System.out.println("Processing line: " + line);

                    // After processing 100 lines, print count and reset
                    if (currentChunkSize == chunkSize) {
                        processedRecords += chunkSize;
                        System.out.println("Processed " + processedRecords + " records so far.");
                        currentChunkSize = 0; // Reset for the next chunk
                    }
                }

                // If there are any remaining lines after the last full chunk
                if (currentChunkSize > 0) {
                    processedRecords += currentChunkSize;
                    System.out.println("Processed " + processedRecords + " records in total.");
                }

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
    }


