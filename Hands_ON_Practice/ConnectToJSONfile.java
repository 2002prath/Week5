package org.example.Hands_ON_Practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
    import com.fasterxml.jackson.databind.ObjectMapper;
public class ConnectToJSONfile {



        public static void main(String[] args) {
            // Database connection URL, username, password
            String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";

            // Query to fetch data from the database
            String query = "SELECT name, age, city FROM users";

            // List to store database records
            List<Map<String, Object>> records = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                // Get column names from the ResultSet meta data
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Iterate over the result set
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();

                    // Map column names to their corresponding values
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = rs.getObject(i);
                        row.put(columnName, columnValue);
                    }
                    records.add(row);
                }

                // Convert the List of records to JSON
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

                // Print or save the JSON report
                System.out.println(jsonReport);

            } catch (SQLException | com.fasterxml.jackson.core.JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


