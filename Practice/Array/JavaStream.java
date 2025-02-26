package Practice.Array;

import java.util.*;

public class JavaStream {

    public static void main(String[] args){

        int[]  his = {2,1,5,6,2,3,1};

        System.out.println(" Hist : " +largestRectangleArea(his));
int[] arr = {3,5,4,2};
        System.out.println(" 2his : "+ largest(arr));

        System.out.println("Word : " + getLongestSubString("abcdebfg"));
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//        List<Integer> evens = new ArrayList<>();
//        for (Integer number : numbers) {
//            if (number % 2 == 0) {
//                evens.add(number);
//            }
//        }

//       List<Integer> even2 = numbers.stream().filter(arr -> arr % 2 == 0).toList();
//        System.out.println(even2);
//        int[] arr = {-1,-1,-2,1};
//        System.out.println(circularSubArraySum(arr));
//        int[] war = {4,2,0,3,2,5};
//        int sum = getTrappingRainWater(war);
//        System.out.println("Total : " + sum);
    }

    static int largest(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int i = 0;
        for(i = 0; i < n; i++) {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int rightBoundary = i;
                int leftBoundary = stack.peek();
                maxArea = Math.max(maxArea, (rightBoundary - leftBoundary -1) * heights[top]);
            }
            stack.push(i);
        }
        // process remaining elements from stack
        while(stack.peek() != -1) {
            int top = stack.pop();
            int rightBoundary = i;
            int leftBoundary = stack.peek();
            maxArea = Math.max(maxArea, (rightBoundary - leftBoundary -1) * heights[top]);
        }
        return maxArea;
    }

    public static int MaximumSumCircularSubArray(int[] arr){

        int max = kadane(arr);

        int total = 0;
        for (int i = 0 ; i  < arr.length ; i++){
            total += arr[i];
            arr[i] = - arr[i];
        }
        int min = kadane(arr);

        int maxTotal = min +total;

        return max > 0 ? Math.max(maxTotal,max) : max;

    }

    public static int kadane(int[] arr){
        int total = 0, max = 0;
        for (int i = 0 ; i < arr.length ; i++){
             max = Math.max(arr[i], arr[i]+max);
            total = Math.max(total, max);
        }
        return total;
    }

    static int getLongestSubArrayUsingSlidingWindow(String word){
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int end = 0 ; end < word.length() ; end++ ){
            int c = word.charAt(end);
            if (charIndex.containsKey(c)){
                start = Math.max(start, charIndex.get(c)+1);
            }

            maxLen = Math.max(maxLen, end -start +1);
        }


        return maxLen;

    }

    // Longest substring without repeating characters

    static int getLongestSubString(String word){
        char[] character= word.toCharArray();
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> char1 = new HashMap<>();
        int max = 0;
        int n = character.length;
        for(int i = 0 ; i < n ; i++){
            // if letter contains
            if (char1.containsKey(character[i]) && i +1 < n ){
                i = char1.get(character[i]) ;
                char1.clear();
            } else {
                // do not contain
                char1.put(character[i],1);
            }
            if (char1.size() > max){
                max = char1.size();
                result.append(char1.toString());
            }

        }
        return max;
    }






    static int largestRectangleArea(int histo[]) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    public static int getRectangleHistogram(int[] arr){
        int n = arr.length;
        int total = 0;
        for (int i = 0 ; i < n ; i++){
            //left side
            int count = 0;
            if (i != 0) {
                for (int j = i + 1; j <= 0; j--) {

                    if (arr[i] <= arr[j]){
                        count++;
                    }else {
                        break;
                    }
                }
            }

            for (int k = i ; k < n ; k++){
                if (arr[i] <= arr[k]){
                    count++;
                } else {
                    break;
                }
            }

           total = Math.max(count*arr[i],total);
        }

        return total;
    }






    public static int getTrappingRainWater(int[] arr){
        int n = arr.length;
//        int left = 0, right = n -1;
        int total = 0;
//        for(int i = 0 ; i < n ; i++){
//            int maxLeft = Integer.MIN_VALUE;
//            int maxRight = Integer.MIN_VALUE;
//
//            for(int j = 0 ; j <= i ; j++){
//                maxLeft = Math.max(maxLeft, arr[j]);
//            }
//
//            for (int k = n-1 ; k >= 0 ; k-- ){
//                maxRight = Math.max(maxRight,arr[k]);
//            }
//
//            total += Math.min(maxRight,maxLeft) - arr[i];
//        }
        int left1 = 0 , right1 = n-1 , water = 0;
        int leftmax = 0 ,rightMax = 0;
        while (left1 <= right1){
            if (arr[left1] <= arr[right1]){
                if (arr[left1] >= leftmax){
                    leftmax = arr[left1];
                } else {
                    water += leftmax - arr[left1];
                }

            } else {
                if (arr[right1] >= rightMax){
                    rightMax = arr[right1];
                } else {
                    water += rightMax - arr[right1];
                }
            }
        }


        return total;
    }


    public static int circularSubArraySum(int arr[]) {
        // Your code here
        int maxKadane = kadenes(arr);
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }
        int minKadane = kadenes(arr); // Min subarray sum (inverted array)
        int maxCircular = totalSum + minKadane; // Case 2: Circular sum

        // If all elements are negative, return maxKadane
        return (maxKadane > 0) ? Math.max(maxKadane, maxCircular) : maxKadane;
    }


    public static int kadenes(int[] arr){
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}
