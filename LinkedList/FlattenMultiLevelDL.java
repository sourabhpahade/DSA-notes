package LinkedList;

public class FlattenMultiLevelDL {

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int value, Node prev, Node next, Node children) {
            this.val = value;
            this.prev = prev;
            this.next = next;
            this.child = children;
        }
    }

    /*
     * Approach: Resolving one level at a time
     */
    public static Node flatten(Node head, Node rest) {

        // making curr to traverse list
        Node curr = head;

        while (curr != null) {

            // checking if child exist or not
            if (curr.child != null) {

                Node c2 = curr.child;

                // traversing child till end node
                while (c2.next != null) {
                    c2 = c2.next;
                }

                // connecting child tail to curr.next
                c2.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = c2;
                }

                // connecting curr.next to its child head
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;

            }

            // moving ahead
            curr = curr.next;
        }

        return head;
    }

}
