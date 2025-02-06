package CodeForce.CF2000_2099;

import java.util.*;

// Link : https://codeforces.com/problemset/problem/2063/A
public class Problem_2063A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1 && b == 1) {
                System.out.println(1);
            } else {
                System.out.println(b - a);
            }
        }
        sc.close();
    }
}