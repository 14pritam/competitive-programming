package Practice.Array;

public class MissingInArray {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        
        // XOR all numbers from 1 to n+1
        int xor_n = 0;
        for (int i = 1; i <= n + 1; i++) {
            xor_n ^= i;
        }
        
        // XOR all numbers in the array
        int xor_arr = 0;
        for (int num : arr) {
            xor_arr ^= num;
        }
        
        // The result will be the missing number
        return xor_n ^ xor_arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8}; // Missing 5
        System.out.println(findMissingNumber(arr));  // Output: 5
    }
    
}
