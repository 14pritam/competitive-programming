package Practice.Array;

public class ElementInRotatedSortedArray {

    public static void main(String[] args){
        int[] arr = {8,9,10,12,14,15,6,3,2,1};

        int el = 3;
        int n =  arr.length;
        int start = 0 , end = n-1;
        int index = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int next = (mid + 1) %n;
            int prev = (mid +n -1)%n;
            if( arr[mid] == el){
                index = mid;
                break;
            }
//            if(arr[next] > arr[mid]){
//            }else if(arr[])

        }

        System.out.println(" Element In rotated Sorted Array : " + index);
    }
}
