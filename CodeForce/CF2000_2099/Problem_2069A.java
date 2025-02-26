package CodeForce.CF2000_2099;

import java.util.*;
//https://codeforces.com/problemset/problem/2069/A
 class Problem_2069A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            boolean possible = true;
            int prevPrev = 0, prev = 0;

            for (int i = 2; i < n; i++) {
                int x = sc.nextInt();
                if (prevPrev == 1 && prev == 0 && x == 1) {
                    possible = false;
                }
                prevPrev = prev;
                prev = x;
            }

            result.append(possible ? "YES\n" : "NO\n");
        }

        System.out.print(result);
        sc.close();
    }
}