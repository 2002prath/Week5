package org.example.Hands_ON_Practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ConvertJSONtoXML {



        public static void main(String[] args) {
            try {

                String json = """
            {
                "name": "Pratham",
                "age": 22,
                "address": {
                    "city": "Delhi",
                    "zipcode": "110001"
                },
                "hobbies": ["reading", "coding", "traveling"]
            }
            """;


                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(json);


                XmlMapper xmlMapper = new XmlMapper();
                String xml = xmlMapper.writeValueAsString(jsonNode);

                // Print the XML output
                System.out.println("XML Output:");
                System.out.println(xml);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


