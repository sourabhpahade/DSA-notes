package LinkedList;

class Node {

    int data;
    Node next;
    Node arb;

    public Node(int data) {
        this.data = data;
    }
}

public class CloneLinkedList {

    // Function to clone a linked list with next and random pointer.

    /*
     * Approach 1 : a) using HashMap<node,node> in this we store the (curr node :
     * new copy of curr node)
     * b) Then we create new node clone, and travese the original list again,
     * while traversing we make the clone list by adding and connectint next, arnd
     * pointers
     * c) return m.get(h1) -> cloned head
     */

    /*
     * Approach 2 : a) we traverse given list, make copy of current node, insert
     * copy node to next of curr node
     * b) we traverse again and connect rand pointers of copy nodes
     * c) we traverse again and sepearate the lists
     * d) return the head of cloned list
     */
    Node copyList(Node head) {

        // traking curr pointer
        Node curr = head;

        // traversing the list and adding copy nodes
        while (curr != null) {

            // Making clone node
            Node cloneNode = new Node(curr.data);

            // inserting clone node next to the curr node
            Node temp = curr.next;
            curr.next = cloneNode;
            cloneNode.next = temp;

            // jumping to original net node
            curr = temp;
        }

        // travering the changed list again and connecting rand pointers of clone nodes
        curr = head;

        while (curr != null) {

            // storing the rand pointer of curr original node
            Node rand = curr.arb;

            // adding rand to cloned node
            if (rand != null) {
                curr.next.arb = rand.next;
            }

            // jumping to next original node
            curr = curr.next.next;

        }

        // traversing again to seperate the lists
        curr = head;
        Node clonedHead = curr.next;
        Node clonedCurr = clonedHead;

        while (curr != null) {

            // connect original nodes together
            curr.next = curr.next.next;
            curr = curr.next;

            // connect cloned nodes together
            if (clonedCurr.next != null)
                clonedCurr.next = clonedCurr.next.next;
            clonedCurr = clonedCurr.next;

        }

        return clonedHead;

    }
}
