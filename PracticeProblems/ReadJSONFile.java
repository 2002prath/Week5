package org.example.PracticeProblems;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;


import java.io.FileReader;

public class ReadJSONFile {
    public static void main(String[] args) {

        try
        {
            FileReader reader = new FileReader("C:\\Users\\HP\\Desktop\\Capg-train\\Week5(SpringBoot)\\Day2\\Data\\User.json");

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();


            String name = jsonObject.get("name").getAsString();
            System.out.println("name : " + name);

        }
        catch(Exception e)
        {
            System.out.println("--------Error Caught---------------");
            System.out.println("**************Please Try After Sometime***************" + e.getMessage());
        }
    }
}

