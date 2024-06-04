package com.example.apppojektas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Utils {
    private static Gson gson = new Gson();

    public static String listToJson(List<String> list) {
        return gson.toJson(list);
    }

    public static List<String> jsonToList(String json) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}