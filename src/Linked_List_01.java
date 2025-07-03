class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}


public class Linked_List_01 {

    /**
     * Prints the linked list
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static void printLL(Node<Integer> head) {
        Node<Integer> cur = head;

        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("end");
    }




    /**
     * Inserts a new node at given position (0-based)
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static Node<Integer> insertLL(int data, int position, Node<Integer> head) {
        Node<Integer> newNode = new Node<>(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node<Integer> cur = head;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }

        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }




    /**
     * Deletes node at given position (0-based)
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static Node<Integer> deleteLL(int position, Node<Integer> head) {
        if (head == null) return null;

        if (position == 0) {
            head = head.next;
            return head;
        }

        Node<Integer> cur = head;
        for (int i = 0; i < position - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }




    /**
     * Finds middle element using slow-fast pointer technique
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static int findMidlleLL(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }



    public static void main(String[] args) {
        // Create initial linked list: 10->20->30
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);

        Node<Integer> head = n1;
        n1.next = n2;
        n2.next = n3;

        // Test print functionality
        System.out.println("Original List:");
        printLL(head);

        // Test insert at position 2
        System.out.println("\nAfter inserting 40 at position 2:");
        head = insertLL(40, 2, head);
        printLL(head);

        // Test delete at position 2
        System.out.println("\nAfter deleting at position 2:");
        head = deleteLL(2, head);
        printLL(head);

        // Test find middle element
        System.out.println("\nMiddle element of current list:");
        System.out.println(findMidlleLL(head));
    }
}

