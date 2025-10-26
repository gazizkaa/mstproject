package com.example.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Kruskal {

    public static class Result {
        public List<EdgeData> mstEdges;
        public int totalCost;
        public int operations;
        public long executionTime;

        public Result() {
            mstEdges = new ArrayList<>();
            totalCost = 0;
            operations = 0;
            executionTime = 0;
        }
    }


    private static String find(HashMap<String, String> parent, String node) {
        while (!parent.get(node).equals(node)) {
            node = parent.get(node);
        }
        return node;
    }

    private static void union(HashMap<String, String> parent, String node1, String node2) {
        String root1 = find(parent, node1);
        String root2 = find(parent, node2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    public static Result computeMST(GraphData graph) {
        Result result = new Result();
        long startTime = System.currentTimeMillis();

        List<EdgeData> edges = new ArrayList<>(graph.getEdges());

        Collections.sort(edges, Comparator.comparingInt(EdgeData::getWeight));


        HashMap<String, String> parent = new HashMap<>();
        for (String node : graph.getNodes()) {
            parent.put(node, node);
        }


        for (EdgeData edge : edges) {
            result.operations++;
            String root1 = find(parent, edge.getFrom());
            String root2 = find(parent, edge.getTo());

            if (!root1.equals(root2)) {
                result.mstEdges.add(edge);
                result.totalCost += edge.getWeight();
                union(parent, edge.getFrom(), edge.getTo());
                result.operations++;
            }
        }

        long endTime = System.currentTimeMillis();
        result.executionTime = endTime - startTime;

        return result;
    }
}
