
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/2061/A
public class Problem_2061A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0 ; i< n ; i++){
                arr.add(sc.nextInt());
            }
            Collections.sort(arr);
            int point = 0, sum = 0;
            List<Integer> evenOdd = new ArrayList<>();
            for (int i= 0 ; i < n ; i++){
                if (arr.get(i) % 2 == 0) {
                    evenOdd.add(arr.get(i));
                }
            }
            for (int i= 0 ; i < n ; i++){
                if (arr.get(i) % 2 != 0) {
                    evenOdd.add(arr.get(i));
                }
            }


            for (int i = 0 ; i < n ; i++){
                sum = sum + evenOdd.get(i);

                if (sum % 2 == 0){
                    while (sum % 2 == 0) {
                        sum /= 2;
                    }
                    point++;
                }
            }
            System.out.println(point);
        }
    }
}
