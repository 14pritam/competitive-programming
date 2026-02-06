package Practice.Array;

public class ArrayProblem {


    static int[][] setMatrixZero(int[][] arr){

        /*
         01 02 03
         11 12 13
         21 22 23
         */
        int row = arr.length;
        int col = arr[0].length;
        for(int i = 0 ; i < row; i++){

        }

        return  arr;
    }

    public static void main(String[] args) {

        // Set Matrix Zeros

        int[][] arr= {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};

        System.out.println(setMatrixZero(arr));




    }
    }
