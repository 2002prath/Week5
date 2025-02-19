package org.example.PracticeProblems;

import org.json.JSONArray;
import org.json.JSONObject;



public class MergeTwoJSONFile {
    public static void main(String[] args) {

        JSONObject object1 = new JSONObject();
        object1.put("name","Pratham");
        object1.put("age",22);

        JSONObject object2 = new JSONObject();
        object2.put("College","TIT");
        object2.put("Semester","VIII");

        JSONArray merged = new JSONArray();

        merged.put(object1);
        merged.put(object2);

        System.out.println(merged.toString(8));
    }
}
