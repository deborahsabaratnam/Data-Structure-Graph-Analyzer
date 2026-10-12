package datastructures;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

public class Graph {

    // Stores each vertex and its connected vertices.
    private Map<String, ArrayList<String>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }

    // Add a new vertex to the graph.
    public boolean addVertex(String vertex) {
        if (vertex == null || vertex.trim().isEmpty()) {
            System.out.println("Vertex name cannot be empty.");
            return false;
        }

        vertex = vertex.trim();

        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        System.out.println("Vertex added successfully.");
        return true;
    }

    // Add an undirected edge between two existing vertices.
    public boolean addEdge(String source, String destination) {
        if (source == null || destination == null
                || !adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {
            System.out.println("Both vertices must exist before adding an edge.");
            return false;
        }

        if (source.equals(destination)) {
            System.out.println("A vertex cannot be connected to itself.");
            return false;
        }

        if (adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return false;
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        System.out.println("Edge added successfully.");
        return true;
    }

    // Remove an edge between two vertices.
    public boolean removeEdge(String source, String destination) {
        if (source == null || destination == null
                || !adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {
            System.out.println("Vertex not found.");
            return false;
        }

        if (!adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge does not exist.");
            return false;
        }

        adjacencyList.get(source).remove(destination);
        adjacencyList.get(destination).remove(source);

        System.out.println("Edge removed successfully.");
        return true;
    }

    // Remove a vertex and all its connected edges.
    public boolean removeVertex(String vertex) {
        if (vertex == null || !adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex not found.");
            return false;
        }

        for (String neighbour : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbour).remove(vertex);
        }

        adjacencyList.remove(vertex);
        System.out.println("Vertex removed successfully.");
        return true;
    }

    // Display the graph using its adjacency list.
    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("The graph is empty.");
            return;
        }

        System.out.println("\n----- GRAPH -----");

        for (Map.Entry<String, ArrayList<String>> entry
                : adjacencyList.entrySet()) {

            System.out.print(entry.getKey() + " -> ");

            if (entry.getValue().isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", entry.getValue()));
            }
        }
    }

    // Check whether a vertex exists.
    public boolean searchVertex(String vertex) {
        if (vertex == null) {
            return false;
        }

        boolean found = adjacencyList.containsKey(vertex);

        if (found) {
            System.out.println("Vertex found: " + vertex);
        } else {
            System.out.println("Vertex not found: " + vertex);
        }

        return found;
    }

    // Breadth-First Search (BFS).
    // Visits neighbouring vertices before moving to the next level.
    public void bfs(String startVertex) {
        if (startVertex == null
                || !adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search (DFS).
    // Visits one path as deeply as possible before backtracking.
    public void dfs(String startVertex) {
        if (startVertex == null
                || !adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    // Recursive helper method for DFS.
    private void dfsRecursive(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbour : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Return the number of vertices.
    public int getVertexCount() {
        return adjacencyList.size();
    }

    // Return the total number of edges.
    // Each undirected edge is counted only once.
    public int getEdgeCount() {
        int total = 0;

        for (ArrayList<String> neighbours : adjacencyList.values()) {
            total += neighbours.size();
        }

        return total / 2;
    }

    // Check whether the graph contains any vertices.
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }
}
