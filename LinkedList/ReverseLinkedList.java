package LinkedList;

import java.util.Scanner;

// node class
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

}

public class ReverseLinkedList {

    // printing the list
    static void print(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // reversing the list iterative
    static Node reverse(Node head) {

        Node prev = head;
        Node curr = head.next;

        prev.next = null;

        while (curr != null) {

            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // method 1 : making last node head and recursively adding prev nodes and making
    // prev.next = null
    static Node recursiveReverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node restHead = recursiveReverse(head.next);
        Node tail = head.next;
        tail.next = head;
        head.next = null;
        return restHead;
    }

    // method 2 : converting iterative logic into recursive code using two pointers
    // prev, and next
    static Node recursiveReverse(Node curr, Node prev) {

        if (curr == null) {
            return prev;
        }

        Node next = curr.next;
        curr.next = prev;

        return recursiveReverse(next, curr);

    }

    // reversing the list in groups of k
    public static Node reverse(Node head, int k) {

        Node curr = head;

        // tail of every kth part of list
        Node tail = null;

        // checking the 1st iteration to make head of reversed list
        boolean isFirstPass = true;

        while (curr != null) {

            int i = 0;

            // storing head of each part
            Node first = curr;
            // storing prev node
            Node prev = null;

            // reversing the parts of size <= k
            while (curr != null && i < k) {

                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                i++;

            }

            // changing head at 1st iteration
            if (isFirstPass == true) {
                head = prev;
                isFirstPass = false;
            }
            // connecting the head of next part to tail of previous part
            else {
                tail.next = prev;
            }

            // storing tail of currently stored path
            tail = first;

        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());

        Node tail = head;

        for (int i = 0; i < n - 1; i++) {

            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        sc.close();

        print(reverse(head, 3));

    }
}
