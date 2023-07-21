package LinkedList;

public class PairwiseSwap {

    /*
     * Approch 1 : We can swap the data of nodes and do curr.next.next, But this
     * solution is not good for list having user defined data type.
     */

    /*
     * Better Approach that will work for any type of data -> In this we change the
     * pointer/reference
     */
    public static Node pairwise_swap(Node node) {

        // tracking curr node
        Node curr = node;

        // new head of resultant list
        Node newHead = curr.next;

        // maintaning prev node so we can connect it to the next swaped node
        Node prev = node;

        // checking 1st iteration, because in this we just swap 1st two nodes
        Boolean firstPass = true;

        while (curr != null && curr.next != null) {

            // storing 1st node of next pair
            Node temp = curr.next.next;

            // swapping adjacent nodes
            curr.next.next = curr;

            // connecting last node of swapped pair to 1st node of currently swapped pair
            if (!firstPass) {
                prev.next = curr.next;
                prev = curr;
            }

            // connceting last node of swaped pair to the 1st node of next pair
            curr.next = temp;
            curr = temp;

            firstPass = false;
        }

        // return new head
        return newHead;
    }
}
