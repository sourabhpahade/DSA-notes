package LinkedList;

public class MergeTwoSortedList {

    /*
     * My solution : solution is correct and fully optimized....but we can code it
     * in better way.
     * 
     * Note : when you will revise this que. try to write that better code
     */
    Node sortedMerge(Node head1, Node head2) {

        // if there is only one list
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // if both list is non-empty
        // creating pointers to traverse the both lists

        // c1-> to traverse 1st list
        Node c1 = head1;

        // c2-> to traverse 2nd list
        Node c2 = head2;

        // storing previous node in merged list tp store next smaller element
        Node prev = null;

        // merging
        while (c1 != null && c2 != null) {

            // if c1 node is smaller we just move next and store prev.
            if (c1.data <= c2.data) {

                prev = c1;
                c1 = c1.next;

            }
            // if c2 node is smaller then we change fix c2 node in right position in merged
            // list
            else if (c2.data < c1.data) {

                // storing next node of c2 list
                Node temp = c2.next;

                // if c2 is 1st node in 2nd list and samller than the c1 head then we made it
                // head of merged list and store prev.
                if (prev == null) {

                    c2.next = c1;
                    prev = c2;
                    head1 = c2;

                }
                // if 1st list has smaller head then we fix c2 at its right position in merged
                // list and store prev.
                else {

                    prev.next = c2;
                    c2.next = c1;
                    prev = c2;

                }

                // moving ahead in 2nd list
                c2 = temp;
            }

        }

        // if all the 1st list elements are smaller than 2nd list
        if (c2 == head2)
            prev.next = c2;

        // merging remaining rest of the 2nd list to merged list
        if (c1 == null && c2 != null)
            prev.next = c2;

        return head1;
    }
}
