package Practice.Array;

public class KnapsackProblem {

    public static void main(String[] args){

        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;
        System.out.println("KnappSack 0/1 : "+knapSack(wt,val,W,wt.length));

        int[] arr = {7,1, 5, 3, 6, 4};
        // output = 5;
        int max = 0;
        int min = arr[0];
        for (int i = 1 ; i < arr.length ;i++){
          min = Math.min(min,arr[i]);
          max = Math.max(max, arr[i] - min);
        }
        System.out.println(" Buy Sell : "+ max);


    }

    static int knapSack(int[] weight, int[] value, int w, int n){
        if (n == 0 || w == 0 ){
            return 0;
        }
        if (weight[n-1] <= w){
                return Math.max(value[n-1]+ knapSack(weight,value,w - weight[n-1],n-1),
                       knapSack(weight,value,w,n-1) );
        }else {
                return knapSack(weight,value,w,n-1);
        }
    }
}
