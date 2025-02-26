package Practice.Array;
import java.util.Comparator;
import java.util.PriorityQueue;
public class kthSmallestElement {

    public static void main(String[] args){
        int[] arr = {10,5,6,71,1,2,90,0};
        int k = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr){
            minHeap.add(num);
        }

        for (int i = 1; i < k; i++) {
            minHeap.poll(); // Remove k-1 smallest elements
        }

        System.out.println( "4th smallest : "+ minHeap.poll());


        // Kth largest Element

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : arr){
            maxHeap.add(num);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        System.out.println("Keth largest Element: " + maxHeap.poll());


    }
}
