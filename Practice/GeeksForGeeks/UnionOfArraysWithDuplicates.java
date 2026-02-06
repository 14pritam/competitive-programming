package Practice.GeeksForGeeks;

import java.util.*;

public class UnionOfArraysWithDuplicates {

     public static void main(String[] args) {
        int[] a= {1, 2, 3, 2, 1};
        int[] b ={3, 2, 2, 3, 3, 2};
        System.out.println(findUnion(a, b));
         System.out.println(firstRepeated(a));

         System.out.println(rearrange(new ArrayList<>( Arrays.asList(9, 4, -2, -1, 5, 0, -5, -3, 2))));
         //Sum Pair closest to target
    }

   static ArrayList<Integer> rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        // Alternately add elements from both lists
        while (i < positive.size() && j < negative.size()) {
            ans.add(positive.get(i++));
            ans.add(negative.get(j++));
        }

        // Add remaining elements (if any)
        while (i < positive.size()) {
            ans.add(positive.get(i++));
        }

        while (j < negative.size()) {
            ans.add(negative.get(j++));
        }

        // Update original list
        arr.clear();
        arr.addAll(ans);

        return ans;
    }

    public static int firstRepeated(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > 1) {
                return i + 1; // return 1-based index
            }
        }
        return -1; // no repeated element
    }

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
         Arrays.sort(a);
         Arrays.sort(b);
         ArrayList<Integer> ans = new ArrayList<>();
         int n =  a.length ,  m = b.length;
         int lastAdded = Integer.MIN_VALUE, i = 0 , j = 0;
         while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (a[i] != lastAdded) {
                    ans.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
            } else if (b[j] < a[i]) {
                if (b[j] != lastAdded) {
                    ans.add(b[j]);
                    lastAdded = b[j];
                }
                j++;
            } else {
                if (a[i] != lastAdded) {
                    ans.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (a[i] != lastAdded) {
                ans.add(a[i]);
                lastAdded = a[i];
            }
            i++;
        }

        while (j < m) {
            if (b[j] != lastAdded) {
                ans.add(b[j]);
                lastAdded = b[j];
            }
            j++;
        }
        return ans;
    }
}