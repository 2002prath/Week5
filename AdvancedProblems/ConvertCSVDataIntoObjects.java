package org.ioprogramming.AdvancedProblems;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVDataIntoObjects {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to your CSV file
        List<Student> students = new ArrayList<>(); // List to store Student objects

        // Read the CSV file and populate the list
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the header row (optional, skip it)
            br.readLine();

            // Process each line and create Student objects
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Extract fields and create a Student object
                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                int age = Integer.parseInt(fields[2].trim());
                double marks = Double.parseDouble(fields[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student); // Add the student to the list
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Print the Student objects
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters and setters (optional, depending on your use case)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Override toString for printing
    @Override
    public String toString() {
        return "Student { " +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                " }";
    }
}

