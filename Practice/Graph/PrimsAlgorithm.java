package Practice.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import java.util.*;

public class PrimsAlgorithm {

    static class GraphEdges {
        int weight;
        int source;
        int destination;

        public GraphEdges(int source, int destination, int weight) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }

        public int getSource() { return source; }
        public int getWeight() { return weight; }
        public int getDestination() { return destination; }
    }

    private int vertex;
    private List<GraphEdges>[] adjacencyList;

    public PrimsAlgorithm(int vertex) {
        this.vertex = vertex;
        this.adjacencyList = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addUnidirectionalEdge(int source, int destination, int weight) {
        GraphEdges edge1 = new GraphEdges(source, destination, weight);
        GraphEdges edge2 = new GraphEdges(destination, source, weight);
        adjacencyList[source].add(edge1);
        adjacencyList[destination].add(edge2);
    }

    public int primsAlgo(int startVertex) {
        boolean[] visited = new boolean[vertex];
        PriorityQueue<GraphEdges> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GraphEdges::getWeight));
        int totalWeight = 0;

        visited[startVertex] = true;

        // Add initial edges from the start vertex
        for (GraphEdges edge : adjacencyList[startVertex]) {
            priorityQueue.add(edge);
        }

        while (!priorityQueue.isEmpty()) {
            GraphEdges graphEdge = priorityQueue.poll();
            int dest = graphEdge.getDestination();

            if (visited[dest]) continue;

            visited[dest] = true;
            totalWeight += graphEdge.getWeight();

            for (GraphEdges nextEdge : adjacencyList[dest]) {
                if (!visited[nextEdge.getDestination()]) {
                    priorityQueue.add(nextEdge);
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        PrimsAlgorithm graph = new PrimsAlgorithm(9);

        // Add undirected edges
        graph.addUnidirectionalEdge(1, 2, 2);
        graph.addUnidirectionalEdge(1, 3, 5);
        graph.addUnidirectionalEdge(1, 5, 3);
        graph.addUnidirectionalEdge(2, 3, 4);
        graph.addUnidirectionalEdge(2, 5, 1);
        graph.addUnidirectionalEdge(3, 4, 8);
        graph.addUnidirectionalEdge(3, 7, 7);
        graph.addUnidirectionalEdge(4, 7, 2);
        graph.addUnidirectionalEdge(5, 6, 9);
        graph.addUnidirectionalEdge(5, 7, 1);

        int totalWeight = graph.primsAlgo(1);
        System.out.println("TOTAL MST WEIGHT: " + totalWeight);
    }
}
