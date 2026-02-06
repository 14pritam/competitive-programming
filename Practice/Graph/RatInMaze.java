package Practice.Graph;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    static List<String> possiblePath = new ArrayList<>();
    static String path = "";
    static boolean isSafe(int row , int col,int[][] m,int n){
        if (row >= n || row <= -1 || col >= n || col <= -1 || m[row][col] == 0){
            return false;
        }

        return  true;
    }

    static void printPathHelper(int row , int col,int[][] m,int n){

        if (row == n-1 && col == n-1){
            possiblePath.add(path);
            return;
        }

        if (isSafe(row, col, m, n)){
            path +="D";
            printPathHelper(row+1, col, m, n);

            path = path.substring(0,path.length() -1);

            path +="R";

            printPathHelper(row, col+1, m, n);

        }


    }
}
