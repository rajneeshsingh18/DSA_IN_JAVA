import java.util.EmptyStackException;

public class Stack_01_Implementaion {

    class MyStack {
        private int[] arr;
        private int top;
        private int capacity;

        public MyStack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int x) {
            if (isFull()) {
                throw new StackOverflowError("Stack is Full");
            }
            top++;
            arr[top] = x;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public int size() {
            return top + 1;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class MyLLStack {
        private Node head;
        private int size;

        public MyLLStack() {
            head = null;
            size = 0;
        }

        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            int popped = head.data;
            head = head.next;
            size--;
            return popped;
        }

        public int peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Stack_01_Implementaion impl = new Stack_01_Implementaion();

        // Array-based stack
        MyStack arrayStack = impl.new MyStack(5);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        System.out.println("Array Stack Peek: " + arrayStack.peek()); // 30
        System.out.println("Array Stack Pop: " + arrayStack.pop());   // 30
        System.out.println("Array Stack Size: " + arrayStack.size()); // 2

        // LinkedList-based stack
        MyLLStack llStack = impl.new MyLLStack();
        llStack.push(100);
        llStack.push(200);
        llStack.push(300);
        System.out.println("LinkedList Stack Peek: " + llStack.peek()); // 300
        System.out.println("LinkedList Stack Pop: " + llStack.pop());   // 300
        System.out.println("LinkedList Stack Size: " + llStack.size()); // 2
    }
}