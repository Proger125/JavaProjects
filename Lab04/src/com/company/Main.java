package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.Add(1);
        tree.Add(2);
        tree.Add(0);
        tree.Add(10);
        tree.traverseInOrder(tree.root);
        tree.traversePreOrder(tree.root);
        tree.traversePostOrder(tree.root);
    }
}
