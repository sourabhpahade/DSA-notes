package LinkedList;

import java.util.Scanner;

/**
 * LoopDetection
 */

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

}

public class LoopDetection {

    /*
     * There are multiple approach to solve this problem but the most optimum is by
     * using Floyd's cycle detection algorithm
     */
    static boolean detectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /*
     * loop removal from list
     */
    public static void removeLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // detecting the loop, finding first meeting point
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // case where loop is at head of list
            if (slow.next == head && fast.next.next == head) {
                slow.next = null;
                return;
            }

            if (slow == fast) {
                break;
            }
        }

        // there is no loop
        if (slow != fast) {

            return;
        }

        // finding second meeting point, which is the start of the loop
        // for this we move slow to head, and move slow, fast at same speed of 1 step
        // this approach ensures that they will meet at the start of loop
        slow = head;

        // this will give us the node prev to the starting node, which is basically the
        // end of resultant list
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
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

    }
}