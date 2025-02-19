package org.example.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
public class FilterJSONFIle {



        public static void main(String[] args) {
            try {

                String jsonArray = """
            [
                { "name": "Pratham", "age": 22 },
                { "name": "Aarav", "age": 25 },
                { "name": "Meera", "age": 30 },
                { "name": "Riya", "age": 28 }
            ]
            """;


                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootArray = objectMapper.readTree(jsonArray);


                List<JsonNode> filteredList = new ArrayList<>();


                for (JsonNode node : rootArray) {
                    if (node.has("age") && node.get("age").asInt() > 25) {
                        filteredList.add(node);
                    }
                }


                String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList);


                System.out.println("Filtered JSON where age > 25:");
                System.out.println(filteredJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


