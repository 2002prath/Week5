package org.ioprogramming.BasicPrograms;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSVFile
{
    public static void main(String[] args)
    {
        String filepath = "students.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath)))
        {
          String line;

          while((line = reader.readLine())!= null)
          {
              String[] fields = line.split(",");


              String id = fields[0].trim();
              String name = fields[1].trim();
              String age = fields[2].trim();
              String marks = fields[3].trim();


              System.out.printf("%-3s | %-14s | %-3s | %-5s%n", id, name, age, marks);
          }
        }
        catch(Exception e)
        {
            System.out.println("Error in a code ");
        }
    }
}
