package org.ioprogramming.IntermediatePrograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class SearchRecord
{
    public static void main(String[] args) {
        String filepath = "Employee.csv";
        Scanner input = new Scanner(System.in);
        String searchName = input.nextLine();

        boolean recordFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                String name = fields[0].trim();
                String department = fields[1].trim();
                String salary = fields[2].trim();

                // Check if the name matches the search term
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);
                    recordFound = true;
                    break;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println(" Error Found in the code  ");
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
