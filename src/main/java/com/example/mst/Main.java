package com.example.mst;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GraphData> graphs = JsonReader.readGraphs("input.json");

        if (graphs == null) {
            System.out.println("Failed to read graphs from JSON.");
            return;
        }

        for (GraphData g : graphs) {
            System.out.println("Graph ID: " + g.getId());
            System.out.println("Nodes: " + g.getNodes());
            System.out.println("Edges: " + g.getEdges());
            System.out.println("---------");

            Prim.Result primResult = Prim.computeMST(g);
            System.out.println("Prim MST cost: " + primResult.totalCost);
            System.out.print("Edges in MST: [");
            for (int i = 0; i < primResult.mstEdges.size(); i++) {
                EdgeData e = primResult.mstEdges.get(i);
                System.out.print(e.getFrom() + " - " + e.getTo() + " : " + e.getWeight());
                if (i < primResult.mstEdges.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Operations: " + primResult.operations);
            System.out.println("Execution time (ms): " + primResult.executionTime);
            System.out.println("---------");

            Kruskal.Result kruskalResult = Kruskal.computeMST(g);
            System.out.println("Kruskal MST cost: " + kruskalResult.totalCost);
            System.out.print("Edges in MST: [");
            for (int i = 0; i < kruskalResult.mstEdges.size(); i++) {
                EdgeData e = kruskalResult.mstEdges.get(i);
                System.out.print(e.getFrom() + " - " + e.getTo() + " : " + e.getWeight());
                if (i < kruskalResult.mstEdges.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Operations: " + kruskalResult.operations);
            System.out.println("Execution time (ms): " + kruskalResult.executionTime);
            System.out.println("====================================");
        }
    }
}
