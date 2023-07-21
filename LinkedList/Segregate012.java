package LinkedList;

public class Segregate012 {

    /*
     * Approach : Not using any counting and space, just making sublists and
     * connecting them
     * 
     * Problem : code become complex
     * 
     * Another approach we can follow is count and then change data while traversing
     * again.
     */
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if (head.next == null) {
            return head;
        }

        // creating head and tail for 0s,1s,2s
        Node zh = null;
        Node zt = null;

        Node oh = null;
        Node ot = null;

        Node th = null;
        Node tt = null;

        Node curr = head;

        while (curr != null) {

            if (curr.data == 0) {

                if (zh == null) {
                    zh = curr;
                    zt = curr;
                } else {
                    zt.next = curr;
                    zt = zt.next;
                }
            } else if (curr.data == 1) {

                if (oh == null) {
                    oh = curr;
                    ot = curr;
                } else {
                    ot.next = curr;
                    ot = ot.next;
                }
            } else {

                if (th == null) {
                    th = curr;
                    tt = curr;
                } else {
                    tt.next = curr;
                    tt = tt.next;
                }
            }

            curr = curr.next;

        }

        // there is only 2s
        if (zh == null && oh == null) {
            return th;
        }

        // there is only 1s
        if (zh == null && th == null) {
            return oh;
        }

        // there is only 0s
        if (oh == null && th == null) {
            return zh;
        }

        // there is not zero
        if (zh == null) {
            ot.next = th;
            tt.next = null;
            return oh;
        }

        // there is not one
        if (oh == null) {
            zt.next = th;
            tt.next = null;
            return zh;
        }

        // there is not two
        if (th == null) {
            zt.next = oh;
            ot.next = null;
            return zh;
        }

        // if all three present
        zt.next = oh;
        ot.next = th;
        ot = th;
        tt.next = null;

        return zh;
    }
}
