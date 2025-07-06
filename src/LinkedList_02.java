public class LinkedList_02 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Prints the linked list
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static void printLL(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }





    /**
     * Merges two sorted linked lists into one sorted list
     * Time Complexity: O(n+m), Space Complexity: O(1)
     */
    static Node mergeTwosorteLL(Node head1, Node head2) {
        Node head = null, tail = null;
        Node a = head1, b = head2;

        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            head = a;
            tail = a;
            a = a.next;
        } else {
            head = b;
            tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        if (a == null) tail.next = b;
        if (b == null) tail.next = a;

        return head;
    }





    /**
     * Finds the middle node of linked list using slow-fast pointer technique
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static Node findMiddleLL(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }





    /**
     * Reverses the linked list iteratively
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static Node reverseLL(Node head) {
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            Node nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev; // New head of the reversed list
    }






    /**
     * Checks if linked list is palindrome
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node mid = findMiddleLL(head);
        Node rev = reverseLL(mid);

        Node left = head;
        Node right = rev;

        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }




    public static void main(String[] args) {
        // Test reverse and middle node functionality
        Node head1 = new Node(4);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printLL(head1);

        head1 = reverseLL(head1);
        System.out.println("Reversed List:");
        printLL(head1);

        Node middle = findMiddleLL(head1);
        System.out.println("Middle Node: " + middle.data);

        // Test merge sorted lists
        Node head2 = new Node(2);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(13);
        head2.next.next.next.next = new Node(16);

        Node head3 = new Node(1);
        head3.next = new Node(4);
        head3.next.next = new Node(7);
        head3.next.next.next = new Node(10);

        System.out.println("\nFirst Sorted Linked List:");
        printLL(head2);

        System.out.println("Second Sorted Linked List:");
        printLL(head3);

        System.out.println("Merged Linked List:");
        Node mergedHead = mergeTwosorteLL(head2, head3);
        printLL(mergedHead);

        // Test palindrome check
        Node head4 = new Node(5);
        head4.next = new Node(4);
        head4.next.next = new Node(1);
        head4.next.next.next = new Node(4);
        head4.next.next.next.next = new Node(5);

        System.out.println("\nPalindrome Test List:");
        printLL(head4);
        System.out.println("Is Palindrome? " + isPalindrome(head4));
    }
}

