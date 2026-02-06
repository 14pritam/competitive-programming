package Practice.Graph;

import java.util.*;

public class Graph {

    private int[][] adjMatrix;
    private int numVertices;

    public Graph(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i,int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i , int j){
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void addVertex(int num) {
        int newSize = numVertices + num;
        int[][] newAdjMatrix = new int[newSize][newSize];

        // Copy existing connections
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        adjMatrix = newAdjMatrix;
        numVertices = newSize;
    }


    public void removeVertex(int v) {
        int[][] newAdjMatrix = new int[numVertices - 1][numVertices - 1];
        int newI = 0;

        for (int i = 0; i < numVertices; i++) {
            if (i == v) continue;
            int newJ = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == v) continue;
                newAdjMatrix[newI][newJ] = adjMatrix[i][j];
                newJ++;
            }
            newI++;
        }

        adjMatrix = newAdjMatrix;
        numVertices--;
    }
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
            System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
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
                for (int i = 0; i < numVertices; i++) {
                    // If there is an edge and the neighbor hasn't been visited yet
                    if (adjMatrix[vertex][i] == 1 && !visited.contains(i)) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public void BfsIterative(int startVertex) {
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

                // Push all unvisited neighbors onto the queue
                for (int i = 0; i < numVertices; i++) {
                    // If there is an edge and the neighbor hasn't been visited yet
                    if (adjMatrix[vertex][i] == 1 && !visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4); // Create a graph with 4 vertices (0 to 3)

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Original Graph:");
        graph.printGraph();

        graph.addVertex(2); // Add 2 new vertices (now 6 total)

        graph.addEdge(4, 5); // Add edge between new vertices
        graph.addEdge(3, 4); // Connect old to new

        System.out.println("\nAfter Adding 2 Vertices and More Edges:");
        graph.printGraph();

        graph.removeEdge(0, 2);
        System.out.println("\nAfter Removing Edge (0,2):");
        graph.printGraph();

        graph.removeVertex(1); // Remove vertex 1
        System.out.println("\nAfter Removing Vertex 1:");
        graph.printGraph();
        System.out.println(" \n");
        System.out.print("DFS : ");
        graph.DfsIterative(1);

        System.out.println(" \n");
        System.out.print("BFS : ");
        graph.BfsIterative(2);
    }



}
