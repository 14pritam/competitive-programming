package Practice.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    static class Tree {
        int val;
        Tree left;
        Tree right;
        Tree(int x) { val = x; }
    }

    public void flatten(Tree root) {
        Tree curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Tree rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void printRight(Tree root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode solution = new TreeNode();

        // Construct example tree:
        //       1
        //      / \
        //     2   5
        //    / \   \
        //   3   4   6

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(5);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right.right = new Tree(6);

        // Flatten the tree
        solution.flatten(root);

        // Print flattened tree
        printRight(root);  // Output: 1 2 3 4 5 6
        System.out.println(inputString("ABCABEABE"));
        
//        System.out.println(lCS());
    }


    public static int lCS(String s1, String s2, int n , int m){

        return 1;
    }

    // Example Input: ABCABEABE
    //Example Output: ABC* E *

    public static String inputString(String input){
        StringBuilder result = new StringBuilder();
        HashSet<Character> map = new HashSet<>();
        int count = 0 ;
        for (int i = 0 ; i < input.length() ; i++){
            char letter = input.charAt(i);
            if (!map.contains(letter)){
                result.append(letter);
                map.add(letter);
                count = 0;
            } else if (count == 0){
                result.append("*");
                count++;
            }
        }
        return result.toString();
    }


    public static Tree buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;

        Tree root = new Tree(Integer.parseInt(arr[0]));
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            Tree curr = queue.poll();

            if (i < arr.length && !arr[i].equals("-1")) {
                curr.left = new Tree(Integer.parseInt(arr[i]));
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("-1")) {
                curr.right = new Tree(Integer.parseInt(arr[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }



    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(Tree root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(Tree node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));  // Ignore negative paths
        int right = Math.max(0, dfs(node.right));

        // Update global max: including both left and right paths
        maxSum = Math.max(maxSum, left + right + node.val);

        // Return one-side path for parent
        return node.val + Math.max(left, right);
    }
}