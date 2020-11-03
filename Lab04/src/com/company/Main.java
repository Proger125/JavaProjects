package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(30);
        tree.add(10);
        tree.add(50);
        tree.add(60);
        tree.add(40);
        tree.add(7);
        tree.add(20);
        tree.add(15);
        tree.add(25);
        tree.add(45);
        tree.add(43);
        tree.add(3);
        tree.delete(30);
        tree.delete(7);
        tree.delete(15);
        tree.detourInOrder();
    }
}
