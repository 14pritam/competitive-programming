package Practice.Graph;

public class MaxPathInMaze {

    static int maxSum;
    static int minSum;
    static String minPath;
    static String maxPath;

    static boolean isSafe(int row, int col, int n, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < n && col < n && !visited[row][col];
    }

    static void solveMaxMin(int row, int col, int[][] maze, int n, boolean[][] visited, int pathSum, String path) {
        pathSum += maze[row][col];

        if (row == n - 1 && col == n - 1) {
            if (pathSum > maxSum) {
                maxSum = pathSum;
                maxPath = path;
            }
            if (pathSum < minSum) {
                minSum = pathSum;
                minPath = path;
            }
            return;
        }

        visited[row][col] = true;

        // Explore all 4 directions
        if (isSafe(row + 1, col, n, visited))
            solveMaxMin(row + 1, col, maze, n, visited, pathSum, path + "D");
        if (isSafe(row, col - 1, n, visited))
            solveMaxMin(row, col - 1, maze, n, visited, pathSum, path + "L");
        if (isSafe(row, col + 1, n, visited))
            solveMaxMin(row, col + 1, maze, n, visited, pathSum, path + "R");
        if (isSafe(row - 1, col, n, visited))
            solveMaxMin(row - 1, col, maze, n, visited, pathSum, path + "U");

        visited[row][col] = false;
    }

    static void findMaxMinPath(int[][] maze, int n) {
        boolean[][] visited = new boolean[n][n];
        maxSum = Integer.MIN_VALUE;
        minSum = Integer.MAX_VALUE;
        minPath = "";
        maxPath = "";

        solveMaxMin(0, 0, maze, n, visited, 0, "");

        System.out.println("Minimum Path Sum: " + minSum);
        System.out.println("Minimum Path Directions: " + minPath);
        System.out.println("Maximum Path Sum: " + maxSum);
        System.out.println("Maximum Path Directions: " + maxPath);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {10, 4, 0, 0},
                {0, 1, 2, 1},
                {0, 1, 4, 1},
                {0, 1, 1, 1}
        };

        findMaxMinPath(maze, maze.length);  // Correct max path sum
    }
}
