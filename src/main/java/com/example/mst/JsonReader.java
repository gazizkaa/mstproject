package com.example.mst;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static List<GraphData> readGraphs(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, List<GraphData>>>() {}.getType();
            Map<String, List<GraphData>> data = gson.fromJson(reader, type);
            return data.get("graphs");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
