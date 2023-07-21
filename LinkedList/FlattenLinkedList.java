package LinkedList;

public class FlattenLinkedList {

    static class Node {

        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    // merge function
    static Node merge(Node h1, Node h2) {

        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        Node c1 = null;
        Node c2 = null;
        Node head = null;
        Node prev = null;

        if (h1.data <= h2.data) {
            head = h1;
            c1 = h1.down;
            c2 = h2;
            prev = h1;
        } else {
            head = h2;
            c1 = h2.down;
            c2 = h1;
            prev = h2;
        }

        while (c1 != null && c2 != null) {

            if (c1.data <= c2.data) {
                prev = c1;
                c1 = c1.down;
            } else {
                Node temp = c2.down;
                prev.down = c2;
                c2.down = c1;
                prev = c2;
                c2 = temp;
            }
        }

        if (c1 != null) {
            prev.down = c1;
        }

        if (c2 != null) {
            prev.down = c2;
        }

        return head;
    }

    static Node flatten(Node root) {

        // handling root case
        if (root == null || root.right == null) {
            return root;
        }

        // selecting adjacent nodes and merging them
        Node curr = root;
        Node flatten = null;

        while (curr.right != null) {

            // storing next node of resultant list

            Node temp = curr.right.right;
            Node head1 = curr;
            Node head2 = curr.right;

            // disconnecting adjacent sub-list from list
            head1.right = null;
            head2.right = null;

            // merging selected sub-list and connecting to rest of the unflattened list
            flatten = merge(head1, head2);
            flatten.right = temp;

            // fixing current to new start point
            curr = flatten;

        }

        return flatten;
    }

    static void printList(Node head) {
        // your code here
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.down;
        }

        System.out.println();
    }
}
