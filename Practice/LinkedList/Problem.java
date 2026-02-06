package Practice.LinkedList;

public class Problem {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        System.out.println( prev.next.val);
        for (int i = 0; i < right - left; i++) {
            System.out.println("----------");
            System.out.println("Iteration : " + i);

            ListNode temp = curr.next;
            System.out.println("temp : " + curr.next.val);
            printList(temp);

            curr.next = temp.next;
            System.out.println("curr.next : " + temp.next.val);
            printList(curr);

            temp.next = prev.next;
            System.out.println("temp.next : " + prev.next.val);
            printList(temp);

            prev.next = temp;
            System.out.println("prev.next : " + temp.val);

            printList(prev);
        }

        return dummy.next;
    }

    // Helper to create list from array
    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem p = new Problem();

        int[] values = {1, 2, 3, 4, 5};
        ListNode head = p.createList(values);

        System.out.print("Original List: ");
        p.printList(head);

        int left = 2, right = 4;
        ListNode modified = p.reverseBetween(head, left, right);

        System.out.print("Modified List: ");
        p.printList(modified);
    }
}