package org.ioprogramming.AdvancedProblems;
import java.io.*;
import java.sql.*;

public class GenerateCSVReport {

        public static void main(String[] args) {
            // JDBC connection details
            String url = "jdbc:mysql://localhost:3306/your_database"; // Database URL
            String username = "your_username"; // Database username
            String password = "your_password"; // Database password

            // SQL query to fetch employee data
            String sql = "SELECT employee_id, name, department, salary FROM employees";

            // Path to the output CSV file
            String outputFilePath = "employee_report.csv";

            try (
                    // Establishing the database connection
                    Connection conn = DriverManager.getConnection(url, username, password);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    // Creating a BufferedWriter to write to the CSV file
                    BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))
            ) {
                // Write the header row to the CSV file
                bw.write("Employee ID,Name,Department,Salary\n");

                // Process each row from the ResultSet and write to the CSV file
                while (rs.next()) {
                    int employeeId = rs.getInt("employee_id");
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    double salary = rs.getDouble("salary");

                    // Writing the record to the CSV file
                    String record = employeeId + "," + name + "," + department + "," + salary;
                    bw.write(record + "\n");
                }

                System.out.println("CSV report generated successfully: " + outputFilePath);

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }


