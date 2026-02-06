package Practice.GoldManSachsProblems;

import java.util.Map;

public class LRUCache1<T> {

    private int size;
    private int capacity;
    private Map<String, Node> hashMap;
    private DoublyLinkedList internalQueue;

    public void put(String key, T value){
        Node node = hashMap.get(key);

        if (node != null){
            node.value= value;
            internalQueue.moveNodeToFront(node);
            return;
        }

        if (size == capacity){
            String map = internalQueue.getRearKey();
            hashMap.remove(map);
            internalQueue.removeNodeFromRear();
        }

        Node newNode = new Node(key, value);
        hashMap.put(key,newNode);
        internalQueue.addNodeToFront(newNode);
    }

    public T get(String key){

        Node node = hashMap.get(key);

        if (node != null){
            internalQueue.moveNodeToFront(node);
            return node.value;
        }

        return null;
    }


    class Node{
        private String key;
        private T value;
        private Node prev , next;

        public Node(String key, T value){
            this.key = key;
            this.value = value;
        }
    }
    /*
    1, 3
    2, 5
    3, 7
    4, 8

    ----

    2,5
     */

     class DoublyLinkedList{
        private Node rear, front;

        DoublyLinkedList(){
            rear = front =null;
        }

       public void moveNodeToFront(Node node){

            if (rear == null){
                return;
            }

            if (rear == node){
                if (rear == front){
                    return;
                }else{
                    rear = rear.prev;
                    if (rear.next != null){
                        rear.next = null;
                        return;
                    }
                }
            }else{
                if (node.prev != null) {
                    node.prev.next = node.next;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }

        }

        public void addNodeToFront(Node node){
            if (front == null){ // basic condition
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void removeNodeFromRear(){
            if (rear ==  null){
                return;
            }
            else if (front == rear){
                front = rear =  null;
                return;
            }
            else{
                rear = rear.prev;
                if (rear != null) {
                    rear.next = null;
                }
            }
        }

        public String getRearKey(){
            return rear != null ? rear.key : null;
        }


    }
}
