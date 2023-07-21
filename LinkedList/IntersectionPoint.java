package LinkedList;

public class IntersectionPoint {
    // Function to find intersection point in Y shaped Linked Lists.

    /*
     * Approach 1 : using hashing
     * Approach 2 : using length of two lists using each heads
     * 1. calc. the len (c1, c2) using each head
     * 2. calc the abs(c1-c2)
     * 3. traverse bigger list abs(c1-c2);
     * 4. traverse both head simultaneously, and find the intersection point
     */
    static int intersectPoint(Node head1, Node head2) {

        // creating currs
        Node curr1 = head1;
        int c1 = 0;

        Node curr2 = head2;
        int c2 = 0;

        // traversing head1
        while (curr1 != null) {
            c1++;
            curr1 = curr1.next;
        }

        // traversing head2
        while (curr2 != null) {
            c2++;
            curr2 = curr2.next;
        }

        // finding bigger len list
        Node bigger = null;
        Node smaller = null;

        if (c1 > c2) {
            bigger = head1;
            smaller = head2;
        } else {
            bigger = head2;
            smaller = head1;
        }

        // traversing bigger abs(c1-c2) times
        int i = 0;
        while (i < Math.abs(c1 - c2)) {
            i++;
            bigger = bigger.next;
        }

        // finding intersection by traversing both at same time
        while (bigger != smaller) {
            bigger = bigger.next;
            smaller = smaller.next;
        }

        if (bigger == null || smaller == null) {
            return -1;
        }

        return bigger.data;
    }
}
