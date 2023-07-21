package LinkedList;

public class SinglyLinkedList {

    Node head;

    static class Node {

        // data which is stored in node, type is corresponding to data we want to insert
        int data;

        // reference to next node, this initialization is also called self refrential
        // structure, so linkedlist is example of this kind of structure
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    // trversing the linkedlist => O(n) time
    public void printNodes(Node head) {

        Node currNode = head;

        while (currNode != null) {

            System.out.print(currNode.data + " ");
            currNode = currNode.next;

        }

        System.out.println();
    }

    public static void printNodesRec(Node head) {

        if (head == null) {
            return;
        }

        System.out.print(head.data + " ");
        printNodesRec(head.next);
    }

    // Insert at the beginning => O(1) time
    public Node insertBegin(Node head, int x) {

        Node newHead = new Node(x);
        newHead.next = head;

        return newHead;

    }

    // Insert at the end => O(n) time
    public Node insertEnd(Node head, int x) {

        Node temp = new Node(x);

        if (head == null) {
            return temp;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = temp;

        return head;
    }

    // Insert at the given position => O(n) time
    public Node insertAt(Node head, int i, int x) {

        Node insertedNode = new Node(x);

        if (i == 1) {
            insertedNode.next = head;
            return insertedNode;
        }

        // tracking elements
        int res = 1;

        // getting (x-1)th node

        Node currNode = head;

        // if i > len of linked list , it will run till last node.next which is null
        while (res < i - 1 && currNode != null) {
            res++;
            currNode = currNode.next;
        }

        // if i > len then insert will not happen
        if (currNode != null) {
            insertedNode.next = currNode.next;
            currNode.next = insertedNode;
        }

        return head;

    }

    // Deleting head node => O(1) time
    public Node delHeadNode(Node head) {

        if (head == null) {
            return head;
        }

        return head.next;
    }

    // Deleting last node => O(n) time
    public Node delLastNode(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        Node currNode = head;

        while (currNode.next.next != null) {
            currNode = currNode.next;
        }

        currNode.next = null;

        return head;
    }

    // Search in LinkedList => O(n) time
    public int search(Node head, int x) {

        int res = 0;

        Node currNode = head;

        while (currNode != null) {
            res++;
            if (currNode.data == x) {
                return res;
            }
            currNode = currNode.next;
        }

        return -1;
    }

    public int recSearch(Node head, int x) {

        if (head == null) {
            return -1;
        }

        if (head.data == x) {
            return 1;
        }

        int res = recSearch(head.next, x);

        if (res == -1) {
            return -1;
        }
        return res + 1;

    }

    public static void main(String[] args) {

    }
}
