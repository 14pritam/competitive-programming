package Practice.GeeksForGeeks;

import Practice.Graph.Graph;

import java.util.LinkedList;

public class AdjacencyList {

    public static class Graph1{
       private int vertex;

       public int[][] adjacencyList;

        public Graph1(int vertex ){
            this.vertex = vertex;
            adjacencyList = new int[vertex][vertex];
        }

        public void add(int value1 , int value2){
            adjacencyList[value1][value2] = 1;
        }

        public void unidirectional(int value1 , int value2){
            add(value1,value2);
            add(value2,value1);
        }

        public void print(){
            for (int i = 0 ; i < vertex ; i++){
                for (int j = 0 ; j < i ; j++){
                    System.out.println(adjacencyList[i][j]);
                }
            }
        }
    }







    public static void main(String[] args){
        Graph1 graph = new Graph1(3);
        graph.adjacencyList = new int[][]{{0, 1}, {1, 2}, {2, 0}};

        graph.print();

    }
}
