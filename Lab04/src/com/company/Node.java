package com.company;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    T value;
    Node<T> left;
    Node<T> right;
    Node(T value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node<T> o) {
        return value.compareTo(o.value);
    }
}
