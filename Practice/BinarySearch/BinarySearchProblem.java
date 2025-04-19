package Practice.BinarySearch;
import java.util.*;

public class BinarySearchProblem {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 10, 10, 12, 14};
        int b = getFirst(arr, true, 10);
        int a = getFirst(arr, false, 10);
        System.out.println("-------------------------");
        System.out.println(a + " " + b);
        System.out.println(uniqueLetterString("LEETCODE"));

        /*
Input : arr[] = {1, 3, 1, 7}
Output : 42
Max of all sub-arrays:
{1} - 1
{1, 3} - 3
{1, 3, 1} - 3
{1, 3, 1, 7} - 7
{3} - 3
{3, 1} - 3
{3, 1, 7} - 7
{1} - 1
{1, 7} - 7
{7} - 7
1 + 3 + 3 + 7 + 3 + 3 + 7 + 1 + 7 + 7 = 42
         */

        int[] arr2 = {1,3,1,7};
        int maxSum = 0;
        for(int i = 0 ; i < arr2.length ; i++){
            int sum = arr2[i];
            for(int j = i ; j < arr2.length ; j++){
                sum = Math.max(sum,arr2[j]);
                maxSum += sum;
            }
        }

        System.out.println(" Max Sum : "+ maxSum);
        System.out.println("Output 1: " + countAndPrintUniqueSubstrings("gffg")); // 6

    }

    static  int countAndPrintUniqueSubstrings(String str) {
        int n = str.length();
        Set<Character> set = new HashSet<>();
        int i = 0, count = 0;

        for (int j = 0; j < n; j++) {
            while (set.contains(str.charAt(j))) {
                set.remove(str.charAt(i));
                i++;
            }
            set.add(str.charAt(j));

            // Print all substrings from i to j
            for (int k = j; k >= i; k--) {
                System.out.println(str.substring(k, j + 1));
                count++;
            }
        }

        return count;
    }

    static int uniqueLetterString(String s) {
        List<Integer>[] indexList = new List[26];
        Arrays.setAll(indexList, x -> new ArrayList<>()); // make arrayList

        for(int i = 0 ; i < 26 ; i++){
            indexList[i].add(-1);
        }

        for(int i = 0 ; i < s.length() ; ++i){
            indexList[s.charAt(i) - 'A'].add(i);
        }
        int ans = 0;
        for(List<Integer> occurences : indexList){
            occurences.add(s.length());
            for (int i = 1; i < occurences.size() - 1; ++i) {
                ans += (occurences.get(i) - occurences.get(i - 1))
                        * (occurences.get(i + 1) - occurences.get(i));
            }
        }
        return ans;
    }

    public static int getFirst(int[] arr, boolean first, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int value = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                value = mid;
                if (first) {
                    right = mid - 1; // Search for first occurrence
                } else {
                    left = mid + 1;  // Search for last occurrence
                }
            } else if (arr[mid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return value;
    }
}