package com.example.mst;

import java.util.*;

public class Prim {
    public static class Result {
        public List<EdgeData> mstEdges;
        public int totalCost;
        public int operations;
        public long executionTime;

        public Result(List<EdgeData> mstEdges, int totalCost, int operations, long executionTime) {
            this.mstEdges = mstEdges;
            this.totalCost = totalCost;
            this.operations = operations;
            this.executionTime = executionTime;
        }
    }

    public static Result computeMST(GraphData graph) {
        long startTime = System.currentTimeMillis();

        List<EdgeData> mst = new ArrayList<>();
        int totalCost = 0;
        int operations = 0;

        Set<String> visited = new HashSet<>();
        PriorityQueue<EdgeData> pq = new PriorityQueue<>(Comparator.comparingInt(EdgeData::getWeight));

        String start = graph.getNodes().get(0);
        visited.add(start);

        // add all edges from start node
        for (EdgeData e : graph.getEdges()) {
            if (e.getFrom().equals(start) || e.getTo().equals(start)) {
                pq.add(e);
                operations++;
            }
        }

        while (!pq.isEmpty() && visited.size() < graph.getNodes().size()) {
            EdgeData edge = pq.poll();
            operations++;

            String nextNode = null;
            if (visited.contains(edge.getFrom()) && !visited.contains(edge.getTo())) {
                nextNode = edge.getTo();
            } else if (visited.contains(edge.getTo()) && !visited.contains(edge.getFrom())) {
                nextNode = edge.getFrom();
            }

            if (nextNode != null) {
                mst.add(edge);
                totalCost += edge.getWeight();
                visited.add(nextNode);

                for (EdgeData e : graph.getEdges()) {
                    if ((e.getFrom().equals(nextNode) && !visited.contains(e.getTo())) ||
                            (e.getTo().equals(nextNode) && !visited.contains(e.getFrom()))) {
                        pq.add(e);
                        operations++;
                    }
                }
            }
        }

        long endTime = System.currentTimeMillis();
        return new Result(mst, totalCost, operations, endTime - startTime);
    }
}
