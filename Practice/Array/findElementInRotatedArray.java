package Practice.Array;

 class FindElementInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {23, 24, 25, 0, 12, 14, 19, 20};
        int target = 19;

        int index = search(arr, target);
        System.out.println("Index: " + index);
    }

    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;  // Target is in left half
                } else {
                    start = mid + 1;  // Target is in right half
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;  // Target is in right half
                } else {
                    end = mid - 1;  // Target is in left half
                }
            }
        }
        return -1; // Element not found
    }
}