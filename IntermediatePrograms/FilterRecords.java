package org.ioprogramming.IntermediatePrograms;

import java.io.*;



public class FilterRecords {
    public static void main(String[] args)
    {
       String filePath = "student.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while((line=br.readLine())!=null)
            {
                String[] field = line.split(",");

                String id = field[0].trim();
                String name = field[1].trim();
                String age = field[2].trim();
                int marks = Integer.parseInt(field[3].trim());

                if(marks>80)
                {
                    System.out.println(name+","+ marks);
                }
            }
        }
        catch (FileNotFoundException e)
       {
           throw new RuntimeException(e);

       } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
