package Practice.Array;

import java.util.Arrays;

public class sortZeros {
    public static void main(String[] args) {
    int[] arr = {2,1,2,0,0,1,1};
    int zero = 0 , first = 0 , second = arr.length -1;

    while(first <= second){
        if(arr[first] == 0){
            int temp = arr[first];
            arr[first] = arr[zero];
            arr[zero] = temp;
            zero++;
            first++;
        }else if(arr[first] == 1 ){
            first++;
        }else {
            int temp = arr[second];
            arr[second] = arr[first];
            arr[first] = temp;
            second--;
        }
    }

        Arrays.stream(arr).forEach(System.out::print);    }
}
