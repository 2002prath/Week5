package org.example.PracticeProblems;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;

public class CreateJSONObject {
    public static void main(String[] args) {

    JSONArray subjects= new JSONArray();

    subjects.put("Maths");
    subjects.put("Physics");
    subjects.put("Chemistry");

    JSONObject object = new JSONObject(new LinkedHashMap<>());

    object.put("Name","Pratham Mishra");
    object.put("Age",22);
     object.put("Subjects",subjects);

        System.out.println(object.toString());

    }
}
