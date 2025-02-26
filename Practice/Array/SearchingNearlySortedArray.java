package Practice.Array;

public class SearchingNearlySortedArray {

        public static void main(String[] args) {
            int[] arr = {5, 10, 30, 20, 40,60,50,70};
            int target = 50;

            int index = search(arr, target);
            System.out.println("Index: " + index);
        }

        public static int search(int[] arr, int target) {
            int start = 0, end = arr.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) return mid;
                if (mid > start && arr[mid - 1] == target) return mid - 1;
                if (mid < end && arr[mid + 1] == target) return mid + 1;

                // Adjust search range
                if (arr[mid] > target) {
                    end = mid - 2;  // Move left
                } else {
                    start = mid + 2;  // Move right
                }
            }
            return -1;  // Target not found
        }

}
