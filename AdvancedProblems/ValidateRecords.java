package org.ioprogramming.AdvancedProblems;



import java.io.*;
import java.util.regex.Pattern;

public class ValidateRecords {
    public static void main(String[] args) {
        String filePath = "data.csv"; // Path to your CSV file
        int emailColumnIndex = 2; // Assuming Email is the 3rd column
        int phoneColumnIndex = 3; // Assuming Phone Number is the 4th column

        // Define regex patterns
        Pattern emailPattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"); // Valid email regex
        Pattern phonePattern = Pattern.compile("^\\d{10}$"); // Valid phone number regex (10 digits)

        System.out.println("Processing file: " + filePath);
        System.out.println("Invalid rows:");

        // Read the CSV file and validate rows
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read and ignore the header
            int rowNumber = 1; // To track row numbers in the file

            // Process each record
            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] fields = line.split(",");

                // Extract Email and Phone Number fields
                String email = fields[emailColumnIndex].trim();
                String phone = fields[phoneColumnIndex].trim();

                // Validate Email and Phone Number
                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                // Print errors if the row is invalid
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Row " + rowNumber + ": " + line);
                    if (!isEmailValid) {
                        System.out.println("  -> Invalid Email: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  -> Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

