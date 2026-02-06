package Practice.PriorityQueue;

import java.util.*;


public class PriorityQueue {

        public static void main(String[] args) throws java.lang.Exception {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] a = new int[n];

                for (int i = 0; i < n; i++) a[i] = sc.nextInt();

                List<Integer> motu = new ArrayList<>();
                List<Integer> tomu = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if ((i & 1) == 0) motu.add(a[i]);  // Even index - Motu
                    else tomu.add(a[i]);              // Odd index - Tomu
                }

                // Sort Motu descending, Tomu ascending
                Collections.sort(motu, Collections.reverseOrder());
                Collections.sort(tomu);

                // Perform up to K swaps
                int swapCount = Math.min(k, Math.min(motu.size(), tomu.size()));
                for (int i = 0; i < swapCount; i++) {
                    if (motu.get(i) > tomu.get(i)) {
                        // Swap
                        int temp = motu.get(i);
                        motu.set(i, tomu.get(i));
                        tomu.set(i, temp);
                    } else {
                        break; // No more beneficial swaps possible
                    }
                }

                // Calculate final scores
                long motuSum = 0, tomuSum = 0;
                for (int val : motu) motuSum += val;
                for (int val : tomu) tomuSum += val;

                System.out.println(tomuSum > motuSum ? "YES" : "NO");
            }
        }
    }
