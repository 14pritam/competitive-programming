package Practice.Array;

import java.util.*;

public class Fibonacci {
 // BOILER PLATE CODE
    //Find the nth Fibonacci number using dynamic programming.
    public static void main(String args[]){

        HashMap<String,String> map = new HashMap<>();
        map.put(null, "code");
        map.put(null,"abc");
        System.out.println("hashmap :: "+ map.get(null));
        int n = 2;
        int[] dp = new int[n+1];
        int i = 0;
        Arrays.fill(dp,-1);
        System.out.println(fib(n,dp));
        int[] height = { 30, 10, 60, 10, 60, 50 };
        int np = height.length;
        int k = 2;
        System.out.println("Frog Jump 1 or 2 times : " + frogJump(np -1,height));
        System.out.println("Frog Jump K times : " + frogKTimesJump(np-1,height,k));
        System.out.println(" Max : " + maxActiveSectionsAfterTrade("01110"));
        System.out.println("answer : " + encoding("GGGGrrrrttt"));
        List<String> inputArray = new ArrayList<>();
        inputArray.add("a");
        inputArray.add("c");
        inputArray.add("c");

        System.out.println("Remove burst Length : " + getShrunkArray(inputArray,3));
        int[] arr= {10,20,30,20};
        int n1 = arr.length;
        int[] dp1 = new int[n1+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        System.out.println("k frog : "+ kFrogTimes(arr,n-1,dp));
        int[] arc ={2,3,5};
        System.out.println(coinChange(arc,10));
    }

    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int MAX = amount+1;
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        for(int coin : coins){
            for(int i = coin ; i <= amount ; i++){
                dp[i] = Math.min(dp[i], dp[i-coin] +1);
            }
        }

        return dp[amount] != MAX ? dp[amount] : 0;
    }


    static int kFrogTimes(int[] arr, int n, int[] dp){
        if( n == 0){
            return 0;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        for (int i = 1 ; i < n ; i--){

            int kTime  = kFrogTimes(arr,n - i,dp) + Math.abs(dp[n-i] - dp[i]);

        }
        return 0;
    }

    static int findFirstAndLastPosition(int[] arr, int n, boolean flag){
        int start = 0 , end = arr.length -1;
        int result = -1;
        while (start <= end) {
            int mid = start +(end -start) /2;

            //0 0 1 1 2 2 2
            if (arr[mid] == n){
                result = mid;
                if (flag){
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }


        }
        return  result;
    }

    static class Pair{
        String character;
        int count;

        public Pair(String character, int count){
            this.character = character;
            this.count = count;
        }
    }


    static List<String> burstLength(List<String> inputArray, int burstLength){
        Stack<Pair> stack = new Stack<>();
        for(String ch : inputArray){
            if ( !stack.isEmpty() && stack.peek().character.equals(ch)) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(ch,  1));
            }

            if (stack.peek().count >= burstLength){
                stack.pop();
            }
        }
        List<String> newArrayList = new ArrayList<>();

        for( Pair pair : stack){
            while (pair.count > 0 ){
                newArrayList.add(pair.character);
                pair.count--;
            }
        }
        return newArrayList;
    }
    static String encoding(String word){
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i = 1 ; i < word.length(); i++){
            if(word.charAt(i) == word.charAt(i-1)){
                count++;
            } else {
                result.append(count).append(word.charAt(i-1));
                count = 1;
            }
        }
        result.append(count).append(word.charAt(word.length() - 1));
        return result.toString();
    }

//    static class Pair {
//        String ch;
//        int count;
//
//        Pair(String ch, int count) {
//            this.ch = ch;
//            this.count = count;
//        }
//    }

//   static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
//        inputArray = new ArrayList<>(inputArray);
//
//        while (true) {
//            Stack<Pair> stack = new Stack<>();
//            boolean removed = false;
//
//            for (String ch : inputArray) {
//                if (!stack.isEmpty() && stack.peek().ch.equals(ch)) {
//                    stack.peek().count++;
//                } else {
//                    stack.push(new Pair(ch, 1));
//                }
//
//                if (stack.peek().count >= burstLength) {
//                    stack.pop();
//                    removed = true;
//                }
//            }
//
//            List<String> newList = new ArrayList<>();
//            for (Pair p : stack) {
//                for (int j = 0; j < p.count; j++) {
//                    newList.add(p.ch);
//                }
//            }
//
//            if (!removed) break;
//
//            inputArray = newList;
//        }
//
//        return inputArray;
//    }




    static int maxActiveSectionsAfterTrade(String s) {
        int oneCount = 0, convertedOne = 0, curZeroCount = 0, lastZeroCount = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '0') {
                curZeroCount++;
            }
            else{
                if(curZeroCount != 0){
                    lastZeroCount = curZeroCount;
                }
                curZeroCount = 0;
                oneCount++; // 1
            }
            convertedOne = Math.max(convertedOne, curZeroCount + lastZeroCount); // 1
        }
        if(convertedOne == curZeroCount || convertedOne == lastZeroCount) return oneCount;    // corner case
        return oneCount + convertedOne;
    }

    // top-down approach
    static int fib(int n, int[] dp){

        if( n <= 1 ){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n-1,dp) + fib(n-2,dp);
    }

    // bottom-up approach

    static int fibUp(int n , int[] dp){
        dp[0] = 0 ;
        dp[1] = 1;
        int i = 2;
        while ( i <= n){
            dp[i] = dp[n-1]+dp[n-2];
        }
        return dp[n];
    }

    // Optimal Solution

    static int Optimal(int n){
        int prev2 = 1;
        int prev = 0;
        int i =2;

        while(i <= n){
            int curr  = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return  prev;
    }

    // Top-Down Approach (Memoization)
    static  int frogJump(int n , int[] heights){
        if(n == 0){
            return 0;
        }
        int firstJump = frogJump(n-1,heights) + Math.abs(heights[n] - heights[n-1]);
        int SecondJump = Integer.MAX_VALUE;
        if (n > 1){
            SecondJump = frogJump(n-2,heights) + Math.abs(heights[n]- heights[n-2]);
        }
        return Math.min(firstJump,SecondJump);
    }

    static int frogKTimesJump(int index, int[] height, int k){
        if (index == 0){
            return 0;
        }

        int minStep = Integer.MAX_VALUE;

        for (int i = 1 ; i <= k ; i++){
            if (index - i >= 0) {
                int jump = frogKTimesJump(index - i,height,k) +
                           Math.abs(height[index] - height[index - i]);
                minStep = Math.min(minStep, jump);
            }
        }
        return minStep;
    }

     static List<String> getShrunkArray(List<String> inputArray, int burstlength) {
        List<String> currentArray = new ArrayList<>(inputArray);
        boolean shrunk = true;

        while (shrunk) {
            shrunk = false;
            List<String> nextArray = new ArrayList<>();
            int i = 0;
            while (i < currentArray.size()) {
                String currentChar = currentArray.get(i);
                int count = 0;
                int j = i;
                while (j < currentArray.size() && currentArray.get(j).equals(currentChar)) {
                    count++;
                    j++;
                }

                if (count < burstlength) {
                    for (int k = i; k < j; k++) {
                        nextArray.add(currentArray.get(k));
                    }
                } else {
                    shrunk = true;
                }
                i = j;
            }
            currentArray = nextArray;
        }
        return currentArray;
    }
}
