package Practice.Graph;

import java.util.*;

class RottenOranges {

    static class Pair {
        int row, col, time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int time = 0, rottenCount = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            time = Math.max(time, p.time);

            for (int d = 0; d < 4; d++) {
                int newRow = p.row + dx[d];
                int newCol = p.col + dy[d];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && grid[newRow][newCol] == 1) {

                    queue.offer(new Pair(newRow, newCol, p.time + 1));
                    visited[newRow][newCol] = true;
                    rottenCount++;
                }
            }
        }

        return (rottenCount == freshCount) ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int result = orangesRotting(grid);
        System.out.println("Minimum minutes to rot all oranges: " + result);
    }
}
