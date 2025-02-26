package Practice.Array;

public class ImplementStackUsingArray {

    public static void main(String[] args){
        int[] arr  = {1,2,3,4,5,6,7,8,9};
        Stack stack = new Stack();
        for(int num : arr){
            stack.push(num);
            System.out.println(" pop ::" + stack.pop());
        }
        System.out.println(" pop ::" + stack.pop());

    }

    static class Stack{
        int[] arr;
        int top;

        public Stack(){
            arr = new int[1000];
            top = -1;
        }

        public void push(int x){
            if(top < 999){
                arr[++top] = x;
            }
        }

        public  int pop(){
            if (top == -1){
                return -1;
            }
            return arr[top--];
        }
    }
}
