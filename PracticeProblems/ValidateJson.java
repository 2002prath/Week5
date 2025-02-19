package org.example.PracticeProblems;
    import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {


        public static void main(String[] args) {
            String validJson = "{ \"name\": \"Pratham\", \"age\": 22 }";
            String invalidJson = "{ \"name\": \"Pratham\", \"invalidField\": \"xyz\" }";

            try {

                ObjectMapper objectMapper = new ObjectMapper();


                Person person = objectMapper.readValue(validJson, Person.class);
                System.out.println("Valid JSON: " + person);


                person = objectMapper.readValue(invalidJson, Person.class);
                System.out.println("Invalid JSON passed!");
            } catch (Exception e) {
                System.out.println("JSON validation failed: " + e.getMessage());
            }
        }
    }


    class Person {
        private String name;
        private int age;


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

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + '}';
        }
    }


