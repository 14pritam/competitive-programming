package Practice.LinkedList;

public class LinkedListProblem {

    Node head;

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void printLinkedListProblem(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void median(Node head){

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null && slow.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("Median Value : " + slow.data);

    }

    static void reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        System.out.print("Reverse Linked List: ");
        printLinkedListProblem(prev);
    }

    public static void main(String args[]) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);


        // Link the nodes manually
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedListProblem(n1);
        median(n1);

        // Reverse the Linked List
        reverseLinkedList(n1);

        // Print reversed list

        Node list1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(4);

        list1.next = l2;
        l2.next = l3;
        l3.next = null;

        Node list2 = new Node(1);
        Node l22 = new Node(3);
        Node l33 = new Node(5);

        list2.next = l22;
        l22.next = l33;
        l33.next = null;


        // Merge two sorted Lists
        Node dummy = new Node(-1); // Dummy head node
        Node tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        printLinkedListProblem(dummy.next);

        // Linked List Cycle Detection
        Node list11 = new Node(1);
        Node l21 = new Node(2);
        Node l31 = new Node(4);
        Node l34 = new Node(2);

        list11.next = l2;
        l21.next = l3;
        l31.next = null;

        Node fas1 = list11;
        Node slow1 = list11;


        // Reordered Linked List

    }
}