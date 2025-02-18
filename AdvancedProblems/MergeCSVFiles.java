package org.ioprogramming.AdvancedProblems;

import java.io.*;
import java.util.*;
public class MergeCSVFiles {



        public static void main(String[] args) {
            String file1Path = "students1.csv"; // Path to the first CSV file
            String file2Path = "students2.csv"; // Path to the second CSV file
            String outputFilePath = "merged_students.csv"; // Output CSV file

            // Map to store records from the first file (keyed by ID)
            Map<String, String[]> file1Data = new HashMap<>();

            // Read the first CSV file and store its data in the map
            try (BufferedReader br = new BufferedReader(new FileReader(file1Path))) {
                String line = br.readLine(); // Read and ignore the header row

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String id = fields[0].trim(); // Extract the ID
                    file1Data.put(id, fields); // Store the fields in the map with ID as the key
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + file1Path);
                e.printStackTrace();
            }

            // Read the second CSV file, merge data, and write to the output file
            try (
                    BufferedReader br = new BufferedReader(new FileReader(file2Path));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))
            ) {
                String line = br.readLine(); // Read and ignore the header row
                bw.write("ID,Name,Age,Marks,Grade\n"); // Write the header to the output file

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String id = fields[0].trim(); // Extract the ID

                    // Check if the ID exists in the first file
                    if (file1Data.containsKey(id)) {
                        String[] file1Fields = file1Data.get(id);

                        // Combine the fields from both files
                        String mergedLine = String.join(",", file1Fields) + "," + fields[1] + "," + fields[2];
                        bw.write(mergedLine + "\n"); // Write the merged line to the output file
                    }
                }
            } catch (IOException e) {
                System.err.println("Error processing files or writing output.");
                e.printStackTrace();
            }

            System.out.println("Merged file created: " + outputFilePath);
        }
    }


