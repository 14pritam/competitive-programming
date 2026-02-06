package Practice.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphProblem {

     static ArrayList<ArrayList<Integer>> adjGraph;
     static int vertices;

    public GraphProblem(int vertices) {
        reset(vertices);
    }

    private void reset(int vertices) {
        this.vertices = vertices;
        adjGraph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjGraph.add(new ArrayList<>());
        }
    }


    public void addEdge(int source, int destination) {
        adjGraph.get(source).add(destination);
    }

    public void addEdge(int source, int destination,int value) {
        adjGraph.get(source).add(destination,value);
    }

    public void addBidirectionalEdge(int source, int destination){
        addEdge(source,destination);
        addEdge(destination,source);
    }

    public void printGraph() {
        for (int i = 0; i < adjGraph.size(); i++) {
            System.out.print(i + " -> ");
            for (int node : adjGraph.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && dfsUndirected(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsUndirected(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adjGraph.get(node)) {
            if (!visited[neighbor]) {
                if (dfsUndirected(neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // cycle found
            }
        }
        return false;
    }


    public boolean hasCycleDirected() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && dfsDirected(i, visited, recStack)) {
                return true; // cycle found
            }
        }
        return false;
    }

    public void clear() {
        for (ArrayList<Integer> neighbors : adjGraph) {
            neighbors.clear();
        }
        vertices = 0;
    }

    private boolean dfsDirected(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true;   // node already in recursion stack → cycle
        if (visited[node]) return false;   // already processed safely

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjGraph.get(node)) {
            if (dfsDirected(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }

    private boolean numberOfIslands(int row, int col , int rowSize, int colSize){

        if (row < 0 || col < 0 || row >= rowSize || col >= colSize || adjGraph.get(row).get(col) == 0) {
            return false;
        }

        // mark visited
        adjGraph.get(row).set(col, 0);

        numberOfIslands(row+1, col, rowSize, colSize);
        numberOfIslands(row, col+1, rowSize, colSize);
        numberOfIslands(row-1, col, rowSize, colSize);
        numberOfIslands(row, col-1, rowSize, colSize);
        return true;
    }

    private int rottenOranges(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        int[][] time = new int[row][col];

        for (int i = 0 ; i < row ; i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }

        for (int i = 0 ; i < row ; i++){

            for (int j = 0 ;j < col ; j++){

                if (grid[row][col] == 2){

                }
            }
        }
        return 5;
    }

    private void dfs(int[][] grid , int row, int col , int[][] time , int currentTime){

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = currentTime;

    }

    static int timer = 0;

    static List<List<Integer>> findBridges(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] inTime = new int[n];
        int[] lowTime = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(inTime, -1);
        Arrays.fill(lowTime, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, inTime, lowTime, graph, bridges);
            }
        }

        return bridges;
    }

    static void dfs(int node, int parent, boolean[] visited, int[] inTime, int[] lowTime, List<List<Integer>> graph, List<List<Integer>> bridges) {
        visited[node] = true;
        inTime[node] = lowTime[node] = timer++;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue; // Skip parent edge

            if (!visited[neighbor]) {
                dfs(neighbor, node, visited, inTime, lowTime, graph, bridges);
                lowTime[node] = Math.min(lowTime[node], lowTime[neighbor]);

                // Bridge condition
                if (lowTime[neighbor] > inTime[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            } else {
                // Back edge
                lowTime[node] = Math.min(lowTime[node], inTime[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        GraphProblem undirectedGraph = new GraphProblem(4);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);

        undirectedGraph.printGraph();

        System.out.println("Cycle in Undirected Graph1 : " + undirectedGraph.hasCycleUndirected());

        undirectedGraph.clear();

        undirectedGraph.reset(4);
        System.out.println("------------- ");

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);

        undirectedGraph.printGraph();


        System.out.println("Cycle in Undirected Graph2 : " + undirectedGraph.hasCycleUndirected());


        GraphProblem directedGraph = new GraphProblem(4);

        directedGraph.addBidirectionalEdge(0, 1);
        directedGraph.addBidirectionalEdge(0, 2);
        directedGraph.addBidirectionalEdge(1, 2);
        directedGraph.addBidirectionalEdge(2, 3);

        directedGraph.printGraph();
        System.out.println("Cycle is Directed Graph : " + directedGraph.hasCycleDirected());
        directedGraph.clear();

        GraphProblem graph = new GraphProblem(4);
        /*
          1 1 1 0
          0 1 1 0
          0 0 0 0
          1 0 1 1
         */
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 0);

        graph.addEdge(1, 0, 0);
        graph.addEdge(1, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 0);

        graph.addEdge(2, 0, 0);
        graph.addEdge(2, 1, 0);
        graph.addEdge(2, 2, 0);
        graph.addEdge(2, 3, 0);

        graph.addEdge(3, 0, 1);
        graph.addEdge(3, 1, 0);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 3, 1);

        int count = 0;

        for (int i = 0; i < adjGraph.size(); i++) {
            for (int j = 0; j < adjGraph.get(0).size(); j++) {
                if (adjGraph.get(i).get(j) == 1) {
                    count++;
                    graph.numberOfIslands(i, j, adjGraph.size(), adjGraph.get(0).size());
                }
            }
        }
        System.out.println("Number of Islands : " + count);


        int n = 5;
        List<List<Integer>> connections = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3),
                Arrays.asList(3, 4)
        );

        List<List<Integer>> bridges = findBridges(n, connections);
        System.out.println("Bridges: " + bridges);


        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> result = findPath(maze, maze.length);

        if (result.isEmpty()) {
            System.out.println("No path exists");
        } else {
            System.out.println("All possible paths: " + result);
        }
    }

    static List<String> possiblePaths = new ArrayList<>();
    static String path = "";

    static int max = 0;
    // Check if move is valid
    static boolean isSafe(int row, int col, int[][] maze, int n, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < n && col < n &&
                maze[row][col] == 1 && !visited[row][col];
    }

    // Recursive backtracking function
    static void solve(int row, int col, int[][] maze, int n, boolean[][] visited) {
        // If destination is reached
        if (row == n - 1 && col == n - 1) {
            possiblePaths.add(path);
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(row + 1, col, maze, n, visited)) {
            path += "D";
            solve(row + 1, col, maze, n, visited);
            path = path.substring(0, path.length() - 1);
        }

        // Left
        if (isSafe(row, col - 1, maze, n, visited)) {
            path += "L";
            solve(row, col - 1, maze, n, visited);
            path = path.substring(0, path.length() - 1);
        }

        // Right
        if (isSafe(row, col + 1, maze, n, visited)) {
            path += "R";
            solve(row, col + 1, maze, n, visited);
            path = path.substring(0, path.length() - 1);
        }

        // Up
        if (isSafe(row - 1, col, maze, n, visited)) {
            path += "U";
            solve(row - 1, col, maze, n, visited);
            path = path.substring(0, path.length() - 1);
        }

        visited[row][col] = false; // backtrack
    }

    static List<String> findPath(int[][] maze, int n) {
        boolean[][] visited = new boolean[n][n];
        possiblePaths.clear();
        path = "";

        if (maze[0][0] == 1) {
            solve(0, 0, maze, n, visited);
        }

        return possiblePaths;
    }

}