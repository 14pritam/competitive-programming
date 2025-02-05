package Practice.Array;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 7;

        // Handle cases where k > length
        k = k % arr.length;

        // Rotate using three-step reversal method
        reverseArray(arr, 0, arr.length - 1);    // Reverse entire array
        reverseArray(arr, 0, k - 1);             // Reverse first k elements
        reverseArray(arr, k, arr.length - 1);    // Reverse remaining elements

        // Print rotated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
