package LinkedList;

public class CircularDoublyLinkedList {

    // head node
    Node head;

    // creating node
    static class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node insertBegin(Node head, int data) {

        Node temp = new Node(data);

        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.prev = head.prev;
        head.prev.next = temp;
        head.prev = temp;
        temp.next = head;

        return temp;
    }

    public Node insertEnd(Node head, int data) {

        Node temp = new Node(data);

        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.prev = head.prev;
        head.prev.next = temp;
        head.prev = temp;
        temp.next = head;

        return head;
    }

    public void traverse(Node head) {

        if (head == null) {
            return;
        }

        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.head = list.insertBegin(list.head, 10);
        list.head = list.insertBegin(list.head, 20);
        list.head = list.insertBegin(list.head, 30);

        list.traverse(list.head);
    }

}
