package Practice.Array;

public class kadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};

        int sum = 0, maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(sum,maxSum);
        }
        System.out.println("MaxSum : " + maxSum);
    }
}
