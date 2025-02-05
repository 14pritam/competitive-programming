package Practice.Array;

public class sortAnArray0s1s2s {
    public static void main(String[] args) {

        int[] arr = {1,2,1,0,0,1,2,1,1,2};

        int low  = 0 , mid = 0 , high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0){
               swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }
            else {
              swap(arr,mid,high);
                high--;
            }
        }

        System.out.println("Result :: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void swap(int[] arr, int index1 , int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }
}
