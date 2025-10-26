package com.example.mst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.*;

public class MSTRunner {

    public static void main(String[] args) {
        List<GraphData> graphs = JsonReader.readGraphs("input_large.json");
        if (graphs == null) return;

        List<Map<String, Object>> results = new ArrayList<>();

        for (GraphData g : graphs) {
            Map<String, Object> graphResult = new HashMap<>();
            graphResult.put("graph_id", g.getId());

            Map<String, Object> inputStats = new HashMap<>();
            inputStats.put("vertices", g.getNodes().size());
            inputStats.put("edges", g.getEdges().size());
            graphResult.put("input_stats", inputStats);

            // Prim
            long startPrim = System.nanoTime();
            Prim.Result primResult = Prim.computeMST(g);
            long endPrim = System.nanoTime();
            Map<String, Object> primMap = new HashMap<>();
            primMap.put("mst_edges", primResult.mstEdges);
            primMap.put("total_cost", primResult.totalCost);
            primMap.put("operations_count", primResult.operations);
            primMap.put("execution_time_ms", (endPrim - startPrim)/1_000_000.0);
            graphResult.put("prim", primMap);

            // Kruskal
            long startKru = System.nanoTime();
            Kruskal.Result kruResult = Kruskal.computeMST(g);
            long endKru = System.nanoTime();
            Map<String, Object> kruMap = new HashMap<>();
            kruMap.put("mst_edges", kruResult.mstEdges);
            kruMap.put("total_cost", kruResult.totalCost);
            kruMap.put("operations_count", kruResult.operations);
            kruMap.put("execution_time_ms", (endKru - startKru)/1_000_000.0);
            graphResult.put("kruskal", kruMap);

            results.add(graphResult);
        }

        //  JSON output
        try (FileWriter fw = new FileWriter("output_large.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(Map.of("results", results), fw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("MST results written to output.json");
    }
}
