package com.example.mst;

import java.util.List;

public class Main {
    public static void main(String[] args) { // <-- must be exactly this
        List<GraphData> graphs = JsonReader.readGraphs("input.json");
        if (graphs != null) {
            for (GraphData g : graphs) {
                System.out.println("Graph ID: " + g.getId());
                System.out.println("Nodes: " + g.getNodes());
                System.out.println("Edges: " + g.getEdges());
                System.out.println("---------");
            }
        } else {
            System.out.println("Failed to read graphs from JSON.");
        }
    }
}
