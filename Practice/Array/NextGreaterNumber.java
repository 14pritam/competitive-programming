package Practice.Array;

import java.util.Arrays;

public class NextGreaterNumber {

    /*
    112
    121

    12435
    12453

    bruteforce ::
    1. To  find the all the combination of this and after that check that if is greater

    12435

    12453


    1234

    1243

    / 1. first find the next grester

     */

    public static void main(String[] args){
        String input = "12321";
        // 12215
        /*
        12345
        01234
         */
        int n = input.length();

        int[] arr = new int[n];
        int j = 0;
        for (char ch : input.toCharArray()) {
            arr[j] = ch - '0';  // Convert char to int
            j++;
        }
        int index  = -1;

        for (int i = n - 2 ; i > 0 ;i--){
            if (arr[i] < arr[i+1] ){
                index = i;
                break;
            }
        }

        if (index == -1){
            System.out.println(-1);
        }else{
            for (int i = n-1 ; i > 0 ;i--){
                if (arr[index] < arr[i] ){
                    // swap two numbers
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }

            // reverse it
            reverse(arr,index+1,n-1);
for (int i = 0 ; i < n ;i++){
    System.out.print( " " + arr[i]+" ");
}
        }

    }

     static void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
