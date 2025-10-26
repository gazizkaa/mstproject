package com.example.mst;

import java.util.List;

public class GraphData {
    public int id;
    public List<String> nodes;
    public List<EdgeData> edges;

    public GraphData(int id, List<String> nodes, List<EdgeData> edges) {
        this.id = id;
        this.nodes = nodes;
        this.edges = edges;
    }


    @Override
    public String toString() {
        return "Graph " + id + " with " + nodes.size() + " nodes and " + edges.size() + " edges";
    }
}
