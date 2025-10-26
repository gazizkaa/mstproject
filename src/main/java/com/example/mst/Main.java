package com.example.mst;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GraphData> graphs = JsonReader.readGraphs("input.json");
        if (graphs != null) {
            for (GraphData g : graphs) {
                System.out.println("Graph ID: " + g.getId());
                System.out.println("Nodes: " + g.getNodes());
                System.out.println("Edges: " + g.getEdges());
                System.out.println("---------");

                // prim MST test
                Prim.Result result = Prim.computeMST(g);
                System.out.println("Prim MST cost: " + result.totalCost);
                System.out.println("Edges in MST:");
                for (EdgeData e : result.mstEdges) {
                    System.out.println(e.getFrom() + " - " + e.getTo() + " : " + e.getWeight());
                }
                System.out.println("Operations: " + result.operations);
                System.out.println("Execution time (ms): " + result.executionTime);
                System.out.println("---------");
            }
        } else {
            System.out.println("Failed to read graphs from JSON.");
        }
    }
}
