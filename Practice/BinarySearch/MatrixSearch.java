package Practice.BinarySearch;

public class MatrixSearch {

    public static void main (String[] args){
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0 , right = row*col +1;
        int target = 11;
        boolean exist = false;
        while(left <= right){
            int mid = left + (right -left)/2;
            int midValue = matrix[mid/col][mid %col];
            
            if (midValue == target){
                exist = true;
                break;
            } else if (midValue < target) {
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        System.out.println("exist : " + exist);
        int m = 27 , n = 3;
        System.out.println( " Nth Root of an Integer : "  +nthRoot(m,n));
    }
    static int nthRoot(int m, int n){
        int left = 0 , right = m;
        while(left <= right){
            int mid  = left + (right - left)/2;
            int value = func(m,n,mid);
            if (value == 1){
                return mid;
            }else if (value == 2){
                right = mid -1;
            }else{
                left = mid +1;
            }

        }
        return -1;
    }

    static int func(int m , int n,int mid){
        int ans =1;
        for(int i = 1 ; i<= n ; i++){
            ans = ans * mid;
            if(ans  > m){
                return 2;
            }
        }
        if (ans == m){
            return 1;
        }
        return 0;
    }


}
