package CodeForce.CF2000_2099;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/2055/A
public class Problem_2064A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            int cnt = 2 * (s.charAt(0) == '1' ? 1 : 0) - (s.charAt(n - 1) == '1' ? 1 : 0);
            
            for (int p = 1; p < n; p++) {
                if (s.charAt(p - 1) == '0' && s.charAt(p) == '1') {
                    cnt += 2;
                }
            }

            result.append(cnt).append("\n");
        }

        System.out.print(result);
        sc.close();
    }
}
