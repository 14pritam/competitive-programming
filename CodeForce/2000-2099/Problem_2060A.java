package CodeForce.Array;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/2060/A
public class Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
           int a1,a2,a4,a5;
           a1 = sc.nextInt();
           a2 = sc.nextInt();
           a4 = sc.nextInt();
           a5 = sc.nextInt();
            int maxCount = 0;
            for (int a3 = -200 ; a3 <= 200 ; ++a3){
                int count = 0;
                if (a3 == a1 + a2){
                    count++;
                }
                if (a3 + a2 == a4){
                    count++;
                }
                if (a3 + a4 == a5){
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }
            System.out.println(maxCount);
        }
    }
}
