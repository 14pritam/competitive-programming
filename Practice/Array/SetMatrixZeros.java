package Practice.Array;

public class SetMatrixZeros {

        public static void main(String[] args){
        int[][] arr = {{1,1,0},{1,1,1},{1,1,0}};

        int row = arr.length;
        int col = arr[0].length;
//
        int zeroColumn = 1;
        for (int i = 0 ; i < row ;i++){
            for (int j = 0; j < col; j++){
                if (arr[i][j] == 0){

                    arr[i][0] = 0;

                    if (j == 0)
                    {
                        zeroColumn = 0;
                    }else {
                        arr[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1 ; i < row ;i++){
            for (int j = 1 ;j < col ; j++){
                if (arr[i][0] == 0 || arr[j][i] ==0){
                    arr[i][j] = 0;
                }
            }
        }

        if (arr[0][0] == 0) {
            for (int i = 1 ; i < row ;i++){
                arr[0][i] = 0;
            }
        }

        if (zeroColumn == 0){
            for (int  i = 1 ; i< col ; i++){
                arr[i][0] = 0;
            }
        }

        for (int i = 0 ; i < row ; i++){
            for (int j =0 ; j< col ; j++){

                System.out.printf(arr[i][j]+" ");
            }
            System.out.println("\n");
        }

    }
}
