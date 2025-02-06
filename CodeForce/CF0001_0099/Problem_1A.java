package CodeForce.CF0001_0099;


import java.util.Scanner;

//https://codeforces.com/problemset/problem/1/A
public class Problem_1A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
         // Read input values
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long a = scanner.nextLong();
            
         // Compute number of flagstones
        long tilesAlongN = (n + a - 1) / a;
        long tilesAlongM = (m + a - 1) / a;
            
        // Compute total flagstones needed
        long totalTiles = tilesAlongN * tilesAlongM;
            
        // Print result
        System.out.println(totalTiles);
            
        scanner.close();
     }
}
