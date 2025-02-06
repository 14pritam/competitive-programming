
package Practice.SlidingWindow;

import java.util.*;

public class IndexOfSubArraySum{

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        System.out.println(subarraySum(arr, target)); // Output: [2, 4] (subarray [3, 7, 5])
    }
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0, sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right]; // Add the current element to the sum
            
            // Shrink the window from the left to keep the sum <= target
            while (sum > target && left <= right) {
                sum -= arr[left]; // Subtract the element at the left pointer
                left++; // Move left pointer to the right
            }
            
            // Check if the current window sum matches the target
            if (sum == target) {
                result.add(left+1);
                result.add(right+1);
                return result;
            }
        }
        
        result.add(-1); // If no subarray found
        return result;
    }
}