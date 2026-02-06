package Practice.Graph;

public class FloodFillAlgorithm {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // Check bounds and color match
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;

        // Recursively call for all 4 directions
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    // Sample usage
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1,0},
                {1, 1, 0,1},
                {1, 0, 1,0}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
