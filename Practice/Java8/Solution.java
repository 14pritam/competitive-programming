package Practice.Java8;

import java.util.*;

public class Solution {
    public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr.get(i)) {
                stack.pop();
            }
            result.add(0, stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(13, 7, 6, 12));
        System.out.println(nextGreaterElement(arr, arr.size())); // Output: [-1, 12, 12, -1]
    }
}
