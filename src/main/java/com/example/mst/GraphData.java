package com.example.mst;

import java.util.List;

public class GraphData {
    private int id;
    private List<String> nodes;
    private List<EdgeData> edges;

    // Getters
    public int getId() {
        return id;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public List<EdgeData> getEdges() {
        return edges;
    }
}
