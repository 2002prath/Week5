package org.ioprogramming.BasicPrograms;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCSVFile {
    public static void main(String[] args) {
        String filepath = "output.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath)))
        {
            writer.write("ID,Name,Department,Salary");
            writer.write("113,Pratham,Technical,75000");
            writer.write("116,Kushagra,Developer,68000");
            writer.write("28,Ankit Raj,Mechanic,28000");
            writer.write("120,Tonio Dsilva,Sports,54000");

            System.out.print("Data is written successfully");
        }
        catch(Exception e)
        {
            System.out.println("Error in a code ");
        }
    }
}
