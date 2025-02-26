package Practice.Array;

import java.util.*;
import java.util.*;

public class RecoverSequence {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt(); // Number of test cases
            StringBuilder output = new StringBuilder();

            while (t-- > 0) {
                int n = scanner.nextInt(); // Number of cells
                int k = scanner.nextInt(); // Number of teleports

                int[] a = new int[n + 1]; // Teleporter destinations (1-based index)

                // Create a cycle: 1 → 2 → 3 → ... → n → 2
                for (int i = 1; i < n; i++) {
                    a[i] = i + 1;
                }
                a[n] = 2; // Last element loops back to 2

                // Output the teleportation array
                for (int i = 1; i <= n; i++) {
                    output.append(a[i]).append(" ");
                }
                output.append("\n");
            }
            System.out.print(output);
            scanner.close();
        }
    }