package Practice.PriorityQueue;

import java.util.*;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PriorityQueueExample2 {

    public static void main(String[] args) {

        int[] arr = {2,3,4,5};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        PriorityQueue<Integer> reverse = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0 ; i < 4 ; i++){
            priorityQueue.add(arr[i]);
            reverse.add(arr[i]);
        }

        System.out.println(" Priority : "+priorityQueue); // 2, 3 ,4, 5
        System.out.println("Reverse : "+reverse); // 5 4 3 2

        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list);

        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list);
    }
}
