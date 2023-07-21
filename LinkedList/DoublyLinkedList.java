package LinkedList;

/*
 * Doubly linkedList, each node has three attributes which are 1. referecence to prev. node, 2. data, 3. reference to next node.
 */
public class DoublyLinkedList {

    // Creating head
    Node head;

    // Creating node class, as static class so main can access directly

    static class Node {

        // type of data can be as per req.
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // traversig forward
    public void traverse(Node head) {

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // traversing backward takes two traversals
    public void traverseBack(Node head) {

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }

        System.out.println();
    }

    // Reversing the DDL => O(n) time
    public Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            // swapping prev with next refrence
            prev = curr.prev;

            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;

        }

        return prev.prev;
    }

    // Insert at begin => O(1) time
    public Node insertBegin(Node head, int data) {

        Node temp = new Node(data);
        temp.next = head;

        if (head != null) {
            head.prev = temp;
        }
        return temp;
    }

    // Insert at end => theta(n) time
    public Node insertEnd(Node head, int data) {

        Node temp = new Node(data);

        if (head == null) {
            return temp;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
        temp.prev = curr;

        return head;
    }

    // Deleting Head node => theta(1) time
    public Node delHead(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }

    // Deleting Last Node => theta(n) time, we can do it in theta(1) if we maintain
    // a tail pointer and pass it in params
    public Node delLast(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.head = new Node(10);

        list.head = list.insertBegin(list.head, 9);
        list.head = list.insertBegin(list.head, 8);

        // list.head = list.reverse(list.head);
        // list.head = list.delHead(list.head);

        list.head = list.insertEnd(list.head, 11);
        list.head = list.insertBegin(list.head, 11);

        // list.traverseBack(list.head);
        list.traverse(list.head);

    }

}
