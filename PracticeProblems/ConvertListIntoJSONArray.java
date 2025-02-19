package org.example.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ConvertListIntoJSONArray {


        public static void main(String[] args) {
            try {
                // Create a list of Java objects
                List<Person1> people = new ArrayList<>();
                people.add(new Person1("Pratham", 22));
                people.add(new Person1("Aarav", 25));
                people.add(new Person1("Meera", 30));

                // Convert the list into a JSON array
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonArray = objectMapper.writeValueAsString(people);

                // Print the resulting JSON array
                System.out.println(jsonArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    class Person1 {
        private String name;
        private int age;

        // Constructor
        public Person1(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters and setters
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
    }


