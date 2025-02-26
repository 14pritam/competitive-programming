package Practice.GoldManSachsProblems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    private final int capacity;
    private int size;
    private final Map<String, Node> hashMap;
    private final DoublyLinkedList internalQueue;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();
        this.size = 0;
    }

    public T get(final String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        internalQueue.moveNodeToFront(node);
        return node.value;
    }

    public void put(String key, T value) {
        Node currentNode = hashMap.get(key);

        if (currentNode != null) {
            currentNode.value = value;
            internalQueue.moveNodeToFront(currentNode);
            return;
        }

        if (size == capacity) {
            String rearKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashMap.remove(rearKey);
            size--;
        }

        Node newNode = new Node(key, value);
        internalQueue.addNodeToFront(newNode);
        hashMap.put(key, newNode);
        size++;
    }

    private class Node {
        String key;
        T value;
        Node next, prev;

        public Node(final String key, final T value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoublyLinkedList {
        private Node front, rear;

        public DoublyLinkedList() {
            front = rear = null;
        }

        private void addNodeToFront(Node node) {
            if (rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        private void moveNodeToFront(Node node) {
            if (front == node) return;

            // Remove node from current position
            if (rear == node) {
                rear = rear.prev;
                if (rear != null){
                    rear.next = null;
                }
            } else {
                if (node.prev != null)
                {
                    node.prev.next = node.next;
                }
                if (node.next != null){
                    node.next.prev = node.prev;
                }
            }

            // Move to front
            node.prev = null;
            node.next = front;
            if (front != null) front.prev = node;
            front = node;
        }

        private void removeNodeFromRear() {
            if (rear == null) return;

            if (front == rear) {
                front = rear = null;
            } else {
                rear = rear.prev;
                if (rear != null) rear.next = null;
            }
        }

        private String getRearKey() {
            return rear != null ? rear.key : null;
        }
    }
}