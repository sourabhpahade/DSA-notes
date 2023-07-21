package LinkedList;

public class MergeSortLinkedList {

    static Node findMid(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node merge(Node left, Node right) {

        if (left == null)
            return right;
        if (right == null)
            return left;

        Node c1 = null;
        Node c2 = null;
        Node prev = null;
        Node head = null;

        if (left.data <= right.data) {
            head = left;
            c1 = left.next;
            c2 = right;
            prev = left;
        } else {
            head = right;
            c1 = right.next;
            c2 = left;
            prev = right;
        }

        while (c1 != null && c2 != null) {

            if (c1.data <= c2.data) {
                prev = c1;
                c1 = c1.next;
            } else {
                Node temp = c2.next;
                prev.next = c2;
                c2.next = c1;
                prev = c2;
                c2 = temp;
            }

        }

        if (c1 != null) {
            prev.next = c1;
        }

        if (c2 != null) {
            prev.next = c2;
        }

        return head;
    }

    public static Node mergesort(Node head) {

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // breaking list into two halves by finding mid
        Node mid = findMid(head);

        // creating two parts
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // Using mergeSort for each part
        left = mergesort(left);
        right = mergesort(right);

        // After Sorting we merge the both parts
        Node result = merge(left, right);

        return result;

    }

}
