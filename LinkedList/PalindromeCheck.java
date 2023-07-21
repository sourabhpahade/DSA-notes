package LinkedList;

public class PalindromeCheck {

    /*
     * Approach 1 : use stack 1st fill it, traverse again check stack node and list
     * not for palindrome
     * 
     * Approach 2:
     * 
     * step 1 -> Find middle of list.
     * step 2 -> reverse from middle.next
     * step 2 -> compare from head and middle.next for palindrome
     */

    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1 -> finding middle
        Node mid = middle(head);

        // Step 2 -> reversing the list from mid.next
        Node c2 = reverse(mid.next);

        // Step 3 -> comparing for palindrome check
        Node c1 = head;

        while (c2 != null) {

            if (c1.data != c2.data) {
                return false;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }

    static Node middle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node reverse(Node head) {

        Node prev = head;
        Node curr = head.next;

        prev.next = null;

        while (curr != null) {

            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

        return prev;
    }
}
