package LinkedList;

public class SegregateEvenOdd {

    /*
     * Approach : We maintain 2 pointer (head and tail) for even sublist, similarly
     * 2 pointer for odd sublist
     * If we find curr node even we add it to even sublist else we add it to odd
     * sublist
     * while maintaining head and tail pointer of each sublist
     * After completing given list, we connect head of odd sublist to tail of even
     * sublist
     * and return head of even sublist.
     */
    Node divide(int N, Node head) {

        // creating head and tail for sublists
        Node even = null;
        Node evenHead = null;

        Node odd = null;
        Node oddHead = null;

        // cur node
        Node curr = head;

        // traversing given list
        while (curr != null) {

            int x = curr.data;

            // maintaining sublists
            if (x % 2 == 0) {

                if (even == null) {
                    even = curr;
                    evenHead = even;
                } else {
                    even.next = curr;
                    even = even.next;
                }

            } else {

                if (odd == null) {
                    odd = curr;
                    oddHead = odd;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
            }

            curr = curr.next;
        }

        // case where if there is only even or odd nodes
        if (evenHead == null || oddHead == null) {
            return head;
        }

        // handling tail cases
        if (even != null) {
            even.next = oddHead;
        } else {
            even = oddHead;
        }
        if (odd != null) {
            odd.next = null;
        }

        return evenHead;
    }
}
