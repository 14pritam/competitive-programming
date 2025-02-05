package Practice.Array;

public class NextPermutation {
    public static void main(String[] args) {
        int[] permutation = {3, 2, 4, 1};
        int idx = -1;
        int n = permutation.length - 1;

        // Step 1: Find the rightmost pair where permutation[i] < permutation[i+1]
        for (int i = n - 1; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no such index is found, reverse the entire array (last permutation case)
        if (idx == -1) {
            reverse(permutation, 0, n);
        } else {
            // Step 2: Find the smallest number larger than permutation[idx] to swap with
            for (int i = n; i > idx; i--) {
                if (permutation[i] > permutation[idx]) {
                    // Swap two numbers
                    int temp = permutation[idx];
                    permutation[idx] = permutation[i];
                    permutation[i] = temp;
                    break;
                }
            }

            // Step 3: Reverse the sequence after index 'idx'
            reverse(permutation, idx + 1, n);
        }

        // Print the result with a newline
        System.out.println("Result :: ");
        for (int num : permutation) {
            System.out.print(num + " ");
        }
        System.out.println(); // Ensure a newline to avoid `%` in Zsh
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) { // Fix condition (strictly less than)
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}