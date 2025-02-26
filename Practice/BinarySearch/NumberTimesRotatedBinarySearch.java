package Practice.BinarySearch;

public class NumberTimesRotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 12, 14, 15, 1, 2, 3}; // Rotated 4 times
        System.out.println("Array is rotated " + getCount(arr) + " times.");
        System.out.println("Array Index of "  + find(arr,12) + ".");

        int[][] array ={{9,1,7},{8,9,2},{3,4,6}};

        int n = array.length;
        int l = array[0].length;
    }


    public static int find(int[] arr,int target){
        int start = 0, end = arr.length - 1;
        int n = arr.length;

        while(start <= end){

            int mid = start + (end - start) /2;

            if(arr[mid] ==  target){
                return mid;
            } else if (arr[mid] >= arr[start]) {
                //left part is sorted

                if( arr[mid] > target && arr[start] <= target){
                    end = mid -1;
                }else{
                    start = mid+1;
                }


            } else {

                // right part is sorted

                if(arr[mid] < target && arr[end] >= target){
                    start = mid +1;
                }else{
                    end = mid -1;
                }

            }
        }

        return -1;
    }

    public static int getCount(int[] arr) {
        int start = 0, end = arr.length - 1;
        int n = arr.length;

        while (start <= end) {
            if (arr[start] <= arr[end]) return start; // Already sorted case

            int mid = start + (end - start) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            // Check if mid is the smallest element
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }

            // Search in the unsorted half
            if (arr[mid] >= arr[start]) {
                start = mid + 1; // Minimum is in right half
            } else {
                end = mid - 1; // Minimum is in left half
            }
        }
        return 0;
    }
}