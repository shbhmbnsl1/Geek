package binarytree;

import binarytree.BinaryTreeIml;
import sun.lwawt.macosx.CSystemTray;

public class MainClass {
    public static void main(String[] args) {
//        System.out.println("Hello world");
//        BinaryTreeIml binaryTreeIml = new BinaryTreeIml(2);
//        binaryTreeIml.root.left = new BinaryTreeIml.Node(3);
//        binaryTreeIml.root.right = new BinaryTreeIml.Node(4);
//        binaryTreeIml.root.left.left = new BinaryTreeIml.Node(5);
//        binaryTreeIml.root.left.right = new BinaryTreeIml.Node(6);
//        System.out.println("Max element is : "+binaryTreeIml.findMaxEle());
//        binaryTreeIml.insert(8);
//        binaryTreeIml.insert(9);
//        System.out.println("Max element is: "+binaryTreeIml.findMaxEle());
//        binaryTreeIml.insert(11);
//        binaryTreeIml.delete(4);
//        System.out.print("Inorder traversal:");
//        binaryTreeIml.inorderWithoutRecursion();
//        System.out.print("\nPostorder traversal:");
//        binaryTreeIml.postorderWithoutRecursion();
//        System.out.print("\nPreorder traversal:");
//        binaryTreeIml.preorderWithoutRecursion();
//        System.out.print("\nHeight of this tree is:"+BinaryTreeIml.height(binaryTreeIml.root));
//        System.out.print("\nLevel order traversal:");
//        binaryTreeIml.levelorderUsingQueue();
//
//        System.out.print("\nElements at level 2: ");
//        binaryTreeIml.printGivenLevel(binaryTreeIml.root, 3);
        BinaryTreeIml binaryTreeIml = new BinaryTreeIml(20);
        binaryTreeIml.root.left = new BinaryTreeIml.Node(8);
        binaryTreeIml.root.right = new BinaryTreeIml.Node(22);
        binaryTreeIml.root.left.left = new BinaryTreeIml.Node(5);
        binaryTreeIml.root.left.right = new BinaryTreeIml.Node(3);
        binaryTreeIml.root.right.right = new BinaryTreeIml.Node(25);
        binaryTreeIml.root.left.right.left = new BinaryTreeIml.Node(10);
        binaryTreeIml.root.left.right.right = new BinaryTreeIml.Node(14);

        binaryTreeIml.connectRightNodes();
        System.out.println("Next Right node of 20 is : "+binaryTreeIml.root.nextRight);
        System.out.println("Next right node of 8 is : " + binaryTreeIml.root.left.nextRight.key);
        System.out.println("Next right node of 22 is : " + binaryTreeIml.root.right.nextRight);
        System.out.println("Next right node of 5 is : " + binaryTreeIml.root.left.left.nextRight.key);
        System.out.println("Next right node of 3 is : " + binaryTreeIml.root.left.right.nextRight.key);
        System.out.println("Next right node of 25 is : " + binaryTreeIml.root.right.right.nextRight);


        MaxHeapIml maxHeapIml = new MaxHeapIml();
        System.out.print("\nList before max heap creation");
        System.out.print(maxHeapIml.list);
        maxHeapIml.buildMaxHeap();
        System.out.print("\nList after max heap");
        System.out.print(maxHeapIml.list);
        System.out.print("\nMax element is heap : " + maxHeapIml.getMaxElement());
        maxHeapIml.deleteMaxElement();
        System.out.print("\nList after deleting max element");
        System.out.print(maxHeapIml.list);
        System.out.print("\nList after inserting element");
        maxHeapIml.insertElement(8);
        maxHeapIml.insertElement(188);
        System.out.print(maxHeapIml.list);
        System.out.print("\nHeap after heap sort:");
        maxHeapIml.heapSort();
        System.out.print(maxHeapIml.list);

        MinHeapIml minHeapIml = new MinHeapIml();
        System.out.print("\n\nList before min heap creation");
        System.out.print(minHeapIml.list);
        minHeapIml.buildMinHeap();
        System.out.print("\nList after min heap");
        System.out.print(minHeapIml.list);

    }
}
