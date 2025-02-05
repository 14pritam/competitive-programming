package Practice.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args){

        int n = 4;

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                // Add the sum of the two numbers directly above
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }

            if (i > 0) {
                row.add(1); // Last element is always 1 for rows > 0
            }

            triangle.add(row);
        }

        printPascalTriangle(triangle);
    }

    private static void printPascalTriangle(List<List<Integer>> triangle) {
        int maxWidth = triangle.get(triangle.size() - 1).size() * 2; // Calculate max width for formatting

        for (List<Integer> row : triangle) {
            // Print leading spaces for centering
            int spaces = (maxWidth - row.size() * 2) / 2;
            System.out.print(" ".repeat(spaces));

            // Print the row elements
            for (int num : row) {
                System.out.print(num + " ");
            }

            System.out.println(); // Move to the next line
        }
    }
}
