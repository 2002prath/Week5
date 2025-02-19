package org.example.Hands_ON_Practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;

public class ReadJSONFile {
    public static void main(String[] args) {

        try{

         File file = new File("data.json");

        ObjectMapper mapper = new ObjectMapper();

            JSONObject object = mapper.readValue(file);
        }
        catch(Exception e)
        {
            System.out.println("Error Caught : =====>  "+ e.getMessage());
        }
    }
}
