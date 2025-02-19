package org.example.Hands_ON_Practice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertCSVtoJSON {



        public static void main(String[] args) {
            try {
                // Path to your CSV file
                String csvFile = "data.csv";

                // Step 1: Read CSV data into a List of Maps
                List<Map<String, String>> rows = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    String line;
                    String[] headers = null;

                    // Read the CSV line by line
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(","); // Split CSV by commas

                        // The first line contains the headers
                        if (headers == null) {
                            headers = values;
                        } else {
                            // Map the row data to the headers
                            Map<String, String> row = new HashMap<>();
                            for (int i = 0; i < headers.length; i++) {
                                row.put(headers[i], values[i]);
                            }
                            rows.add(row);
                        }
                    }
                }

                // Step 2: Convert List of Maps to JSON
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rows);

                // Print JSON output
                System.out.println("JSON Output:");
                System.out.println(json);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


