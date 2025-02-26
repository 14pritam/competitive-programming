package Practice.DP;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 12;
        int[] dp = new int[n + 1];
        
        // Initialize dp array with -1 to indicate uncomputed values
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        // Memoization
        System.out.println(fib(n, dp));

        System.out.println(fibonacci(n));

        System.out.println(fibonacciMethodTwo(n));
    }




    // Memoization
    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        // Top Down Approach
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);  // Memoization step
        return dp[n];
    }

    // Tabulation
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] dp = new int[n + 1]; 
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    // Another way
    public static int fibonacciMethodTwo(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev2 = 0;
        int prev = 1;
        
        for (int i = 2; i <= n; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        
        return prev;
    }
}