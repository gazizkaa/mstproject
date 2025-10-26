# City Transportation Network Optimization (MST Project)

## Overview

This project implements **Prim’s** and **Kruskal’s algorithms** to optimize a city’s transportation network.  
The goal is to determine the **minimum set of roads** connecting all districts with the **lowest total construction cost**.

Graphs are read from JSON files and each algorithm calculates:
- List of edges forming the MST  
- Total cost of the MST  
- Number of operations performed (algorithm-specific)  
- Execution time in milliseconds  

The results are compared to analyze efficiency and performance.

---

## Input Data

Input is a JSON file with a list of graphs. Each graph contains:
- `id`: Graph identifier  
- `nodes`: List of district names  
- `edges`: List of edges with `from`, `to`, and `weight` Running the Project

Build with Maven:

mvn clean compile


Run the program:

mvn exec: java -Dexec.mainClass="com.example.mst.Main"


Output: Results for each graph are printed to the console and stored in output.json.

---

## MST Algorithms

- Prim’s Algorithm

Greedily grows the MST by always adding the minimum weight edge connecting a vertex in the MST to a vertex outside.

Complexity: O(E log V) using a priority queue.

- Kruskal’s Algorithm

Greedily adds edges in order of increasing weight, skipping edges that would form cycles.

Complexity: O(E log E) using Union-Find.

## Results

![MST Graph](results.png)

From the conducted experiments on graphs of different sizes and densities, both Prim’s and Kruskal’s algorithms successfully computed the Minimum Spanning Tree (MST) with identical total costs for all graphs, confirming the correctness of the implementations.

Small Graphs (4–5 vertices)

Graph 1 (5 vertices, 7 edges): Prim’s algorithm performed 12 operations and took 3.07 ms, while Kruskal’s algorithm performed slightly fewer operations (11) and was faster (0.73 ms).

Graph 2 (4 vertices, 5 edges): Both algorithms required 8 operations, with Prim taking 0.02 ms and Kruskal 0.01 ms.

Observation: On small graphs, both algorithms are extremely fast and efficient. Kruskal often executes slightly faster due to fewer internal steps for very small datasets, though differences are negligible in practice.

Medium Graphs (10–12 vertices)

Graph 1 (10 vertices, 14 edges): Prim performed 23 operations in 1.90 ms, while Kruskal also performed 23 operations but completed slightly faster at 1.08 ms.

Graph 2 (12 vertices, 15 edges): Prim needed 26 operations in 0.14 ms, whereas Kruskal took 26 operations in 0.06 ms.

Observation: For medium-sized graphs, Kruskal tends to have slightly faster execution times, though both algorithms scale well. The number of operations grows with graph size, but both remain practical for moderately sized networks.

Large Graphs (20 vertices, 23 edges)

Graph 1: Prim required 44 operations and 5.86 ms, whereas Kruskal used slightly fewer operations (42) and completed in 1.34 ms.

Observation: On larger and sparser graphs, Kruskal shows better performance in terms of execution time, likely due to the union-find structure efficiently managing edges. Prim’s algorithm, which relies on priority queues, takes longer to update costs as the number of vertices grows.

Comparison in Terms of Efficiency and Performance

Prim’s Algorithm:

Works efficiently for dense graphs where the number of edges is close to V².

Slightly higher execution time on large sparse graphs due to the overhead of updating priority queues.

Easier to implement with adjacency matrices or lists for dense graphs.

Kruskal’s Algorithm:

Performs slightly better on sparse graphs due to sorting edges and using union-find structures.

Scales well for larger graphs with fewer edges.

Simpler logic for edge-based operations but requires sorting edges upfront.

Practical Insight:

For small graphs, the difference is negligible; either algorithm is suitable.

For medium-sized graphs, Kruskal shows slightly better execution times, though both remain efficient.

For large, sparse graphs, Kruskal is preferable due to better handling of edges and fewer updates per iteration.

For dense graphs, Prim may be preferred if adjacency-based structures are already used.
## Conclusion

Both algorithms consistently produce MSTs with identical total costs, ensuring correctness.

Kruskal generally performs faster on sparse graphs, while Prim can be advantageous for dense graphs.

The choice of algorithm depends on graph size, density, and internal representation:

Sparse graphs: Kruskal.

Dense graphs: Prim.

Small graphs: Either is sufficient.

The number of operations grows with graph size, but execution time differences become significant only for larger datasets.
