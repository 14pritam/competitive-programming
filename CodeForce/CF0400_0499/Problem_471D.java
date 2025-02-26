package CodeForce.CF0400_0499;

import java.util.Scanner;

public class Problem_471D {
        static final int MOD = 1_000_000_007;
        static int MAX = 100_005;

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int k = sc.nextInt();

            int[] dp = new int[MAX];
            int[] prefix = new int[MAX];

            dp[0] = 1; // base case

            for (int i = 1; i < MAX; i++) {
                dp[i] = dp[i - 1];
                if (i >= k) dp[i] = (dp[i] + dp[i - k]) % MOD;
            }

            // Build prefix sums
            for (int i = 1; i < MAX; i++) {
                prefix[i] = (prefix[i - 1] + dp[i]) % MOD;
            }

            StringBuilder out = new StringBuilder();

            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                int ans = (prefix[b] - prefix[a - 1] + MOD) % MOD;
                out.append(ans).append('\n');
            }

            System.out.print(out);
        }
}
