package Practice.Graph;

import java.util.*;

public class AdjacencyListGraph {

        // The adjacency list maps each vertex to a list of its neighboring vertices
        Map<Integer, List<Integer>> adjacencyMatrix;

        // Constructor to initialize the adjacency list
        public AdjacencyListGraph(){
            this.adjacencyMatrix = new HashMap<>();
        }

        // Adds a new vertex to the graph
        public void addVertex(int vertex){
            // If the vertex is not already present, add it with an empty list
            adjacencyMatrix.putIfAbsent(vertex, new LinkedList<>());
        }

        // Removes a vertex and all edges associated with it
        public void removeVertex(int vertex){
            if (!adjacencyMatrix.containsKey(vertex)) return;

            // Remove the vertex from the graph
            adjacencyMatrix.remove(vertex);

            // Remove this vertex from the adjacency lists of all other vertices
            for (List<Integer> neighbours : adjacencyMatrix.values()){
                neighbours.remove(Integer.valueOf(vertex));
            }
        }

        // Adds an edge between two vertices (undirected)
        public void addEdge(int source , int destination){
            // Ensure both vertices exist in the graph
            adjacencyMatrix.putIfAbsent(source, new LinkedList<>());
            adjacencyMatrix.putIfAbsent(destination, new LinkedList<>());

            // Add the destination to the source's list if not already connected
            if (!adjacencyMatrix.get(source).contains(destination))
                adjacencyMatrix.get(source).add(destination);

            // Add the source to the destination's list to make the edge bidirectional
            if (!adjacencyMatrix.get(destination).contains(source))
                adjacencyMatrix.get(destination).add(source);
        }

        // Removes an edge between two vertices (undirected)
        public void removeEdge(int source ,int destination){
            // Remove the destination from the source's list if it exists
            if (adjacencyMatrix.containsKey(source))
                adjacencyMatrix.get(source).remove(Integer.valueOf(destination));

            // Remove the source from the destination's list if it exists
            if (adjacencyMatrix.containsKey(destination))
                adjacencyMatrix.get(destination).remove(Integer.valueOf(source));
        }

    public void DfsIterative(int startVertex){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // Push the start vertex onto the stack
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            // Pop a vertex from the stack
            int vertex = stack.pop();

            // If the vertex is not visited yet, mark it as visited
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");  // Print or process the vertex

                // Push all unvisited neighbors onto the stack
                for (Integer neighbour : adjacencyMatrix.getOrDefault(vertex, Collections.emptyList())) {
                    // If the neighbor hasn't been visited yet, push it to the stack
                    if (!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public void BfsIterative(int startVertex){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Add the start vertex to the queue
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Remove a vertex from the queue
            int vertex = queue.poll();

            // If the vertex is not visited yet, mark it as visited
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");  // Print or process the vertex

                // Add all unvisited neighbors to the queue
                for (Integer neighbour : adjacencyMatrix.getOrDefault(vertex, Collections.emptyList())) {
                    // If the neighbor hasn't been visited yet, add it to the queue
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Printing the graph
        System.out.println("Graph adjacency list:");
        for (int vertex : graph.adjacencyMatrix.keySet()) {
            System.out.println(vertex + " -> " + graph.adjacencyMatrix.get(vertex));
        }

        // Removing an edge
        graph.removeEdge(1, 3);

        // Removing a vertex
        graph.removeVertex(2);

        // Printing the graph after modifications
        System.out.println("\nGraph after modifications:");
        for (int vertex : graph.adjacencyMatrix.keySet()) {
            System.out.println(vertex + " -> " + graph.adjacencyMatrix.get(vertex));
        }


        System.out.println(" \n");

        System.out.print("DFS : ");
        graph.DfsIterative(2);

        System.out.println("\n");
        System.out.print("BFS : ");
        graph.BfsIterative(2);
    }

}
