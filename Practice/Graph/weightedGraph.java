package Practice.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class weightedGraph {

    static class GraphEdge{

        private final int source;

        private final int destination;

        private final int weight;


        GraphEdge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int getSource(){
            return source;
        }

        public int getDestination(){
            return destination;
        }

        public int getWeight(){
            return weight;
        }
    }

    private int vertex;

    private List<GraphEdge>[] adjacencyList;

    public weightedGraph(int vertex){
        this.vertex = vertex;
        this.adjacencyList = new ArrayList[vertex];
        for (int i = 0 ; i < vertex; i++){
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addDirectionalEdge(int source , int destination, int weight){
        GraphEdge edge = new GraphEdge(source, destination, weight);
        adjacencyList[source].add(edge);
    }

    public void addUnidirectionalEdge(int source , int destination, int weight){
       addDirectionalEdge(source, destination, weight);
       addDirectionalEdge(destination, source, weight);
    }

    // Minimum Spanning Tree
    public void primsAlgorithm(int startVertex) {
        boolean[] visited = new boolean[vertex];
        PriorityQueue<GraphEdge> minHeap = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        // Add all edges from the starting vertex
        visited[startVertex] = true;
        minHeap.addAll(adjacencyList[startVertex]);

        int totalWeight = 0;

        System.out.println("Edges in MST:");
        while (!minHeap.isEmpty()) {
            GraphEdge edge = minHeap.poll();

            int dest = edge.getDestination();
            if (!visited[dest]) {
                visited[dest] = true;
                totalWeight += edge.getWeight();
                System.out.println(edge.getSource() + " - " + dest + " (weight: " + edge.getWeight() + ")");

                // Add all adjacent edges from the new vertex
                for (GraphEdge nextEdge : adjacencyList[dest]) {
                    if (!visited[nextEdge.getDestination()]) {
                        minHeap.add(nextEdge);
                    }
                }
            }
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices (0 to 4)
        weightedGraph graph = new weightedGraph(5);

        // Add some unidirectional (undirected) edges
        graph.addUnidirectionalEdge(0, 1, 10);
        graph.addUnidirectionalEdge(0, 2, 5);
        graph.addUnidirectionalEdge(1, 3, 8);
        graph.addUnidirectionalEdge(2, 3, 7);
        graph.addUnidirectionalEdge(3, 4, 3);

        // Add a directional edge
        graph.addDirectionalEdge(4, 0, 6);

        // Print the graph
        System.out.println("Weighted Graph (Adjacency List):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Vertex " + i + ": ");
            for (weightedGraph.GraphEdge edge : graph.adjacencyList[i]) {
                System.out.print(" -> (" + edge.getDestination() + ", w=" + edge.getWeight() + ")");
            }
            System.out.println();
        }
        System.out.println("\n");

        graph.primsAlgorithm(2);
    }

}
