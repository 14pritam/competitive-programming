package Practice.GeeksForGeeks;

import java.util.*;

public class Bfs {

    public static class AdjacencyList1 {
        Map<Integer, List<Integer>> adjacencyMatrix;

        public AdjacencyList1(){
            adjacencyMatrix = new HashMap<>();
        }

        public void addVertex(int vertex){
            adjacencyMatrix.put(vertex, new LinkedList<>());
        }

        public void addEdge(int source, int destination){
            adjacencyMatrix.put(source, new LinkedList<>());
            adjacencyMatrix.put(destination, new LinkedList<>());

            adjacencyMatrix.get(source).add(destination);
            adjacencyMatrix.get(destination).add(source);
        }

        public void removeEdge(int source,int destination){
            adjacencyMatrix.get(source).remove(destination);
            adjacencyMatrix.get(destination).remove(source);
        }

        public void print(){
            for ( Map.Entry<Integer, List<Integer>> map: adjacencyMatrix.entrySet()){
                System.out.println(map.getKey() + " - "+map.getValue());
            }
        }

        public void bfs(int startVertex){
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            visited.add(startVertex);
            queue.add(startVertex);
            while(!queue.isEmpty()){
                int value = queue.poll();
                if (!visited.contains(value)){
                    queue.add(value);
                    for (Integer neighbour : adjacencyMatrix.get(value)){
                        if (!visited.contains(neighbour)) {
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }

    }
}
