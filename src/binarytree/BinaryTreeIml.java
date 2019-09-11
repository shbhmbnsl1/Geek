package binarytree;

import java.util.*;

class BinaryTreeIml {
    Node root;

    static class Node {
        int key;
        int horizontalDistance;
        Node left, right, nextRight;
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    BinaryTreeIml() {
        root = null;
    }
    BinaryTreeIml(int key) {
        root = new Node(key);
    }

    /**
     * Depth first Traversals
     */
    static void inorder(Node root) {
        if (root==null)
            return;

        inorder(root.left);
        System.out.print(root.key);
        inorder(root.right);
    }

    static void postorder(Node root) {
        if (root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key);
    }

    static void preorder(Node root) {
        if (root==null)
            return;

        System.out.print(root.key);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        if (root == null)
            return;
        while (current!=null || stack.size()>0) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key);
            current = current.right;
        }
    }

    public void preorderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.key);
            if (current.right!=null)
                stack.push(current.right);
            if (current.left!=null)
                stack.push(current.left);
        }
    }

    public void postorderWithoutRecursion() {
        Stack<Node> stackOne = new Stack<Node>();
        Stack<Node> stackTwo = new Stack<Node>();
        if (root==null)
            return;
        Node current = root;
        stackOne.push(current);
        while (!stackOne.isEmpty()) {
            current = stackOne.pop();
            stackTwo.push(current);
            if (current.left!=null)
                stackOne.push(current.left);
            if (current.right!=null)
                stackOne.push(current.right);
        }
        while(!stackTwo.isEmpty()) {
            System.out.print(stackTwo.pop().key);
        }
    }

    /**
     * Breadth first traversal
     */
    public static int height(Node root) {
        if (root==null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            return Math.max(lheight+1, rheight+1);
        }
    }

    public void levelOrder() {
        int height = height(root);
        for (int i=1; i<=height; i++) {
            printGivenLevel(root, i);
        }
    }

    public void printGivenLevel(Node root, int level) {
        if (root==null)
            return;
        if (level==1)
            System.out.print(root.key);
        else if (level>1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public void levelorderUsingQueue() {
        Queue<Node> queue = new LinkedList<Node>();
        if (root==null)
            return;
        Node current;
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.key);
            if (current.left!=null)
                queue.add(current.left);
            if (current.right!=null)
                queue.add(current.right);
        }
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        Queue<Node> queue = new LinkedList<Node>();
        Node current;
        if (root==null) {
            root = newNode;
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left!=null) {
                queue.add(current.left);
            } else {
                current.left = newNode;
                return;
            }
            if (current.right!=null) {
                queue.add(current.right);
            } else {
                current.right = newNode;
                return;
            }
        }
    }

    public int findMaxEle() {
        Node current;
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return -1;
        }
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.key > max) {
                max = current.key;
            }
            if (current.left!=null)
                queue.add(current.left);
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return max;
    }

    public void delete(int key) {
        Node deepestRightMostNode = root;
        Node deepestRightMostNodeParent = root;

        // check if root is null, return
        if (root==null) {
            System.out.print("Empty tree");
            return;
        }

        // find deepest right most node in tree
        while (deepestRightMostNode.right!=null) {
            deepestRightMostNodeParent = deepestRightMostNode;
            deepestRightMostNode = deepestRightMostNode.right;
        }

        // find node to be deleted
        Queue<Node> queue = new LinkedList<Node>();
        Node nodeToBeDeleted = root;
        queue.add(root);
        while(!queue.isEmpty()) {
            nodeToBeDeleted = queue.poll();
            if (nodeToBeDeleted.key == key)
                break;
            if (nodeToBeDeleted.left!=null)
                queue.add(nodeToBeDeleted.left);
            if (nodeToBeDeleted.right != null)
                queue.add(nodeToBeDeleted.right);
        }
        if (nodeToBeDeleted.key!=key) {
            System.out.println("Key not found");
            return;
        }

        // make key of node to be deleted equal to deepest right most node's key
        nodeToBeDeleted.key = deepestRightMostNode.key;

        deepestRightMostNodeParent.right = null;
    }

    // Find bottom view of tree
    public void bottomView() {
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return;
        }
        int hd = 0;
        root.horizontalDistance = hd;
        queue.add(root);
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        Node current = root;
        while (!queue.isEmpty()) {
            current = queue.poll();
            hd = current.horizontalDistance;
            treeMap.put(current.horizontalDistance, current.key);
            if (current.left != null) {
                current.left.horizontalDistance = hd - 1;
                queue.add(current.left);
            }
            if (current.right != null) {
                current.right.horizontalDistance = hd + 1;
                queue.add(current.right);
            }
        }
        for (Map.Entry m: treeMap.entrySet()) {
            System.out.println(m.getValue());
        }
    }

    // Find vertical sum of tree
    public void verticalSum() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        if (root == null)
            return;
        verticalSumUtil(root, 0, hashMap);
        if (hashMap!=null) {
            System.out.println(hashMap.entrySet());
        }
    }

    public void verticalSumUtil(Node node, int hd, HashMap<Integer, Integer> hashMap) {
        if (node==null)
            return;

        verticalSumUtil(node.left, hd-1, hashMap);

        int prevSum = hashMap.get(hd)==null ? 0 : hashMap.get(hd);
        hashMap.put(hd, prevSum+node.key);

        verticalSumUtil(node.right, hd+1, hashMap);
    }

    public void levelOrderInSpiral() {
        int h = height(root);
        boolean spiral = false;
        for (int i=1; i<=h; i++) {
            printGivenLevelSpiral(root, i, spiral);
            spiral = !spiral;
        }
    }

    public void printGivenLevelSpiral(Node root, int level, boolean spiral) {
        if (root==null)
            return;
        if (level==1)
            System.out.println(root.key);
        else if (level>1) {
            if (spiral) {
                printGivenLevelSpiral(root.left, level-1, spiral);
                printGivenLevelSpiral(root.right, level-1, spiral);
            }
            else {
                printGivenLevelSpiral(root.right, level-1, spiral);
                printGivenLevelSpiral(root.left, level-1, spiral);
            }
        }
    }

    // Connect each node with its right node
    public void connectRightNodes() {
        Queue<Node> queue = new LinkedList<Node>();
        Node current = root;
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current!=null) {
                current.nextRight = queue.peek();

                if (current.left!=null)
                    queue.add(current.left);
                if (current.right!=null)
                    queue.add(current.right);
            }
            else if (!queue.isEmpty())
                queue.add(null);
        }
    }
}
