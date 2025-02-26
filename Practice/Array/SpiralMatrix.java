package Practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpiralMatrix {
        public static void main(String[] args) {
            int[][] matrix = { 
                {1,  2,  3, 4,   5, 6 },
                {7,  8,  9, 10, 11, 12},
                {13,14, 15, 16, 17, 18},
                {19,20, 21, 22, 23, 24},
                    {25,26, 27, 28, 29, 30 }


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

            int[][] arr2 = {{2,2},{1,3}};
            System.out.println("Missing and repeated : " + Arrays.toString(findMissingAndRepeatedValues(arr2)));
        }



    static int[] findMissingAndRepeatedValues(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] missing = new int[row*col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                int value = grid[i][j];
                if(missing[value -1] == -1){
                    missing[value -1] = 1;
                }else if(missing[value -1] >= 0){
                    missing[value -1] = 1 + missing[value -1];
                }
            }
        }
        int[] arr = new int [2];
        int total = row * col;
        for(int i = 0 ; i < total ; i++){
            if(missing[i] > 1){
                arr[0] = i+1;
            }else if(missing[i] == 0) {
                arr[1] = i+1;
            }
        }

        return arr;

    }
}
    

