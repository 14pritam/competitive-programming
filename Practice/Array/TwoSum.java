package Practice.Array;

public class TwoSum {

    public static void main(String[] args){
        int[] arr = {-1,-2,-3,-4,-5};
        System.out.println(twoSum(arr, -8));
    }
    public static int[] twoSum(int[] nums, int target) {
        int left = 0 , right = nums.length -1;
  
        while(left <= right){
          int sum = nums[left] + nums[right];
  
          if(sum == target){
              break;
          }else if( sum > target){
              right = right -1;
          }else{
              left = left +1;
          }
        }
      return new int[]{left,right};  
      }
    
}
