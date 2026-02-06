package Practice.Graph;

import java.util.*;


public class Problem {

   static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

   static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Node[] visited = new Node[101];
            return dfs(node, visited);
        }

        private Node dfs(Node node, Node[] visited) {
            if (visited[node.val] != null) {
                return visited[node.val];
            }
            Node copy = new Node(node.val);
            visited[node.val] = copy;
            for (Node neighbor : node.neighbors) {
                copy.neighbors.add(dfs(neighbor, visited));
            }
            return copy;
        }
    }
    public static void main(String[] args) {
        // Build input graph: 1-2-3-4 as a square
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone graph
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print cloned graph
        System.out.println("Cloned Graph:");
        printGraph(clonedGraph, new HashSet<>());
    }

    public static void printGraph(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) return;

        visited.add(node.val);
        System.out.print("Node " + node.val + " neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}
