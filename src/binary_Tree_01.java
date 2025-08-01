import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class binary_Tree_01 {

    // Binary Tree Node for input-driven creation
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }



    // TreeNode for LeetCode-style problems
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }



    static class BinaryTree {
        Scanner sc = new Scanner(System.in);

        /**
         * Creates a binary tree interactively
         * Time Complexity: O(n), Space Complexity: O(n)
         */
        Node createBinaryTree() {
            System.out.println("Enter node data (-1 for null):");
            int data = sc.nextInt();

            if (data == -1) return null;

            Node node = new Node(data);

            System.out.println("Enter " + data + "'s left child:");
            node.left = createBinaryTree();

            System.out.println("Enter " + data + "'s right child:");
            node.right = createBinaryTree();

            return node;
        }




        /**
         * Recursive in-order traversal (Left-Root-Right)
         * Time Complexity: O(n), Space Complexity: O(h) where h is tree height
         */
        void inOrderTraversal(Node root) {
            if (root == null) return;
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }



        /**
         * Recursive pre-order traversal (Root-Left-Right)
         * Time Complexity: O(n), Space Complexity: O(h)
         */
        void preOrderTraversal(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }



        /**
         * Recursive post-order traversal (Left-Right-Root)
         * Time Complexity: O(n), Space Complexity: O(h)
         */
        void postOrderTraversal(Node root) {
            if (root == null) return;
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }



        /**
         * Calculates height of binary tree
         * Time Complexity: O(n), Space Complexity: O(h)
         */
        int heightOfBinaryTree(Node root) {
            if (root == null) return 0;
            int lh = heightOfBinaryTree(root.left);
            int rh = heightOfBinaryTree(root.right);
            return Math.max(lh, rh) + 1;
        }




        /**
         * Iterative pre-order traversal (Stack-based)
         * Time Complexity: O(n), Space Complexity: O(n)
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);

                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }

            return result;
        }
    }




    /**
     * Iterative in-order traversal (Stack-based)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            inorder.add(pop.val);
            cur = pop.right;
        }

        return inorder;
    }




    /**
     * Iterative post-order traversal (Stack-based)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            // Push all left nodes
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Check if top node has right child
            if (!stack.isEmpty() && stack.peek().right != null) {
                node = stack.peek().right;
            } else {
                // Process node and its ancestors
                TreeNode temp = stack.pop();
                postorder.add(temp.val);

                // Process parent if current node was its right child
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    postorder.add(temp.val);
                }
            }
        }
        return postorder;
    }





    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();

        // Create and traverse binary tree
        System.out.println("Creating Binary Tree:");
        Node root = bTree.createBinaryTree();

        System.out.println("\nIn Order Traversal:");
        bTree.inOrderTraversal(root);

        System.out.println("\n\nPre Order Traversal:");
        bTree.preOrderTraversal(root);

        System.out.println("\n\nPost Order Traversal:");
        bTree.postOrderTraversal(root);

        System.out.println("\n\nHeight of Tree: " + bTree.heightOfBinaryTree(root));

        // Test iterative traversals with TreeNode
        TreeNode sampleRoot = new TreeNode(1);
        sampleRoot.left = new TreeNode(2);
        sampleRoot.right = new TreeNode(3);
        sampleRoot.left.left = new TreeNode(4);
        sampleRoot.left.right = new TreeNode(5);

        System.out.println("\nIterative Preorder Traversal (TreeNode): " +
                bTree.preorderTraversal(sampleRoot));

        System.out.println("Iterative Inorder Traversal (TreeNode): " +
                inorderTraversal(sampleRoot));

        System.out.println("Iterative Postorder Traversal (TreeNode): " +
                postOrderTraversal(sampleRoot));
    }
}

// GitHub commit message: "Implemented binary tree operations: creation, recursive traversals, height calculation, and iterative traversals"