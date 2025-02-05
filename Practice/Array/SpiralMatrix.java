package Practice.Array;

import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
        public static void main(String[] args) {
            int[][] matrix = { 
                {1, 2, 3, 4, 5}, 
                {6, 7, 8, 9, 10}, 
                {11, 12, 13, 14, 15}, 
                {16, 17, 18, 19, 20} 
            };
    
            int row = matrix.length;
            int col = matrix[0].length;
    
            int top = 0, bottom = row - 1;
            int left = 0, right = col - 1;
            List<Integer> arr = new ArrayList<>();
    
            while (top <= bottom && left <= right) {
                // Left to right
                for (int i = left; i <= right; i++)
                    arr.add(matrix[top][i]);
                top++;
    
                // Top to bottom
                for (int i = top; i <= bottom; i++)
                    arr.add(matrix[i][right]);
                right--;
    
                // Right to left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--)
                        arr.add(matrix[bottom][i]);
                    bottom--;
                }
    
                // Bottom to top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--)
                        arr.add(matrix[i][left]);
                    left++;
                }
            }
    
            System.out.println(arr);
        }
}
    

