package Practice.Array;

public class StockBuyAndSell {
    public static void main(String[] args) {

        int[] arr = {7,6,4,3,1};
        int maxSum = 0, min = 999999;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            maxSum = Math.max(maxSum, arr[i] - min);
        }
        System.out.println(maxSum);
    }
}
