package org.ioprogramming.AdvancedProblems;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class EncryptCSV {

        public static void main(String[] args) {
            String outputCsvFile = "encrypted_students.csv";

            // Example student data
            String[][] students = {
                    {"1", "Alice", "20", "alice@example.com", "85.5"},
                    {"2", "Bob", "22", "bob@example.com", "90.0"}
            };

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {
                // Write CSV header
                writer.write("ID,Name,Age,Email,Salary\n");

                // Write data to CSV with encryption for Email and Salary
                for (String[] student : students) {
                    String id = student[0];
                    String name = student[1];
                    String age = student[2];

                    String email = EncryptionUtils.encrypt(student[3]);  // Encrypt Email
                    String salary = EncryptionUtils.encrypt(student[4]); // Encrypt Salary

                    // Write encrypted values to the CSV
                    writer.write(String.join(",", id, name, age, email, salary) + "\n");
                }

                System.out.println("CSV file with encrypted data has been written successfully: " + outputCsvFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


 class EncryptionUtils {

    // Secret key for AES encryption/decryption
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key (128-bit)

    // Encrypt a text using AES
    public static String encrypt(String plainText) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Decrypt a text using AES
    public static String decrypt(String encryptedText) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


