package CodeForce.CF1700_1799;

import java.util.Scanner;

// Link : https://codeforces.com/contest/1742/problem/D
public class Problem_1742D{
    /*
    CoPrime : Co-prime numbers are two numbers that have only 1 as their common factor.
    In other words, their greatest common factor (GCD) is 1.
    */

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] c = new int[1001]; // To store the last occurrence index
            int ans = -1;

            // Initialize the array
            for (int i = 0; i <= 1000; i++) {
                c[i] = -1;
            }

            // Read input and store the last occurrence index
            for (int i = 1; i <= n; i++) {
                int j = sc.nextInt();
                c[j] = i; // Store 1-based index
            }

            // Find the max sum of indices for coprime pairs
            for (int i = 1; i <= 1000; i++) {
                for (int j = i; j <= 1000; j++) {
                    if (c[i] > 0 && c[j] > 0 && gcd(i, j) == 1) {
                        ans = Math.max(ans, c[i] + c[j]);
                    }
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
