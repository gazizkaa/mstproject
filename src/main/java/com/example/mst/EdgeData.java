package com.example.mst;

public class EdgeData {
    public String from;
    public String to;
    public int weight;

    public EdgeData(String from, String to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return from + " - " + to + " (" + weight + ")";
    }
}
