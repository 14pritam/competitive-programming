package Practice.BinarySearch;

import java.util.Arrays;

public class BSProblem {

    /**
     * BS , lower and Upper bound
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        int result = binarySearch(nums, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }

        int[] nums1 = {3,5,8,15,19};

        int[] res = bounds(nums1, 9);

        System.out.println("bounded : "+res[0]+ " unbounded : " + res[1]);
        int[] nums3 = {3, 4, 5, 12, 12, 12, 18, 19, 202, 204};

        System.out.println("Search Index : "+searchRotated(nums3,4));
        System.out.println("Duplicate Search Index : "+searchRotatedWithDuplicates(nums3,12));
        System.out.println("Min :" +findMin(nums3));
        System.out.println("First : " + firstAndLastOccurrence(nums3, true, 12));
        System.out.println("Last : " + firstAndLastOccurrence(nums3, false, 12));

        int[] bloomDay = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 3, k = 2;
        System.out.println("Bloom day :: " + bloomDay(bloomDay,m,k));

    }

    static int bloomDay(int[] arr, int m , int k){
        int start = Integer.MAX_VALUE , end = Integer.MIN_VALUE;
        for (int num : arr){
            start = Math.min(start,num);
              end = Math.max(end,num);
        }
        while(start <= end){
            int mid = (end - start)/2 + start;

            if (possibleNumberOfBouteq(arr,mid,m,k)){
                end = mid -1;
            }else{
                start = mid +1;
            }
        }

        return start;
    }

    static boolean possibleNumberOfBouteq(int[] arr, int day, int m, int k) {

        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    static int nthRoot(int target, int n) {
        int low = 1, high = target;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = power(mid, target, n);

            if (val == 0) return mid;       // found exact root
            else if (val == 1) high = mid - 1; // mid^n > target
            else low = mid + 1;             // mid^n < target
        }
        return -1; // not a perfect n-th root
    }

    // Compare mid^pow with target safely
    static int power(int mid, int target, int pow) {
        long result = 1; // use long to reduce overflow risk

        for (int i = 0; i < pow; i++) {
            result *= mid;
            if (result > target) {
                return 1;  // mid^pow > target
            }
        }

        if (result == target) return 0;  // mid^pow == target
        return -1;                       // mid^pow < target
    }

    static boolean searchRotatedWithDuplicates(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static int findMin(int []arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]); // hidden one
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }


    static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // found
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1; // target in left half
                } else {
                    low = mid + 1; // target in right half
                }
            }
            // Otherwise, right half is sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1; // target in right half
                } else {
                    high = mid - 1; // target in left half
                }
            }
        }

        return -1; // not found
    }

    static int firstAndLastOccurrence(int arr[], boolean first, int target) {
        int start = 0, end = arr.length - 1;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (first) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    static int[] bounds(int[] arr, int target) {
        int n = arr.length;
        int lb = n, ub = n;

        int start = 0, end = n - 1;
        // Lower Bound: first index where arr[i] >= target
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                lb = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }


        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > target) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            }
            else {
                low = mid + 1; // look on the right
            }
        }
        return new int[]{arr[lb], arr[ans]};
    }
}
