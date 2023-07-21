package LinkedList;

/*
 * In the circular LlinkedList the reference of the last node is not null, it refers to the head.
 */
public class CircularLinkedList {

    // making head of linkedlist
    Node head;

    // making node, making static ad node is attribute of
    // linkedlist
    static class Node {

        // node consist two attributes which are data, and refrence to the next node.
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

    // traversing the list
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

    // Insert at end => theta(1)
    public Node insertEnd(Node head, int data) {

        Node temp = new Node(data);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        // inserting temp at 2nd node
        temp.next = head.next;
        head.next = temp;

        // swapping the data of head and temp
        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        // returning temp as our oringinal head is moved to 2nd position
        return temp;
    }

    // insert at Begin => theta(1) time
    public Node insertBegin(Node head, int data) {

        Node temp = new Node(data);

        if (head == null) {
            temp.next = temp;
            return temp;
        }

        // putting temp at 2nd node
        temp.next = head.next;
        head.next = temp;

        // now we will swap the head.data with next.data
        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        return head;
    }

    // deleting the head => theta(1) time
    public Node delHead(Node head) {

        if (head == null || head.next == head) {
            return null;
        }

        // getting second node
        Node second = head.next;

        // connecting head.next to second.next (third node)
        head.next = second.next;

        // copying the data second node in head node so second node will become new head
        head.data = second.data;

        return head;
    }

    // deleting kth node => theta(k-1) time if k (2,n-1)
    public Node delKthNode(Node head, int k) {

        if (head == null || head.next == head) {
            return null;
        }

        if (k == 1) {
            return delHead(head);
        }

        int i = 1;
        Node curr = head;

        while (i < k - 1 && curr.next != head) {
            i++;
            curr = curr.next;
        }

        if (curr.next != head) {
            curr.next = curr.next.next;
        }

        return head;
    }

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();
        list.head = list.insertBegin(list.head, 50);
        list.head = list.insertEnd(list.head, 10);
        list.head = list.insertEnd(list.head, 20);
        list.head = list.insertEnd(list.head, 30);
        list.head = list.insertBegin(list.head, 40);
        list.traverse(list.head);

        list.head = list.delKthNode(list.head, 6);

        list.traverse(list.head);

    }
}
