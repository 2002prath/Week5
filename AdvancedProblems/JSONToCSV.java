package org.ioprogramming.AdvancedProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
public class JSONToCSV {

        public static void main(String[] args) {
            String inputJsonFile = "students.json"; // Path to the JSON file
            String outputCsvFile = "students.csv";  // Output CSV file

            try {
                // Read JSON file into a JsonNode object
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(new File(inputJsonFile));

                // Create a BufferedWriter to write the CSV file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile));

                // Write header row (keys of the first JSON object)
                JsonNode firstStudent = jsonNode.get(0);
                Iterator<Map.Entry<String, JsonNode>> fields = firstStudent.fields();
                StringBuilder header = new StringBuilder();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    header.append(field.getKey()).append(",");
                }
                // Remove the last comma
                header.deleteCharAt(header.length() - 1);
                writer.write(header.toString() + "\n");

                // Write data rows
                for (JsonNode student : jsonNode) {
                    StringBuilder row = new StringBuilder();
                    fields = student.fields();
                    while (fields.hasNext()) {
                        Map.Entry<String, JsonNode> field = fields.next();
                        row.append(field.getValue().asText()).append(",");
                    }
                    // Remove the last comma
                    row.deleteCharAt(row.length() - 1);
                    writer.write(row.toString() + "\n");
                }

                writer.close();
                System.out.println("CSV file has been written successfully: " + outputCsvFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


