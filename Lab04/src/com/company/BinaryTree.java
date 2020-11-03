package com.company;

public class BinaryTree<T extends Comparable<T>>{
    private Node<T> root;
    public void add(T value){
        root = addRecursive(root, value);
    }
    private Node<T> addRecursive(Node<T> current, T value){
        if (current == null){
            return new Node<T>(value);
        }
        if (current.value.compareTo(value) > 0){
            current.left = addRecursive(current.left, value);
        }else if (current.value.compareTo(value) < 0){
            current.right = addRecursive(current.right, value);
        }else{
            return current;
        }
        return current;
    }
    public boolean containsNode(T value){
        return containsNodeRecursive(root, value);
    }
    private boolean containsNodeRecursive(Node<T> current, T value){
        if (current == null){
            return false;
        }
        if (current.value.compareTo(value) == 0){
            return true;
        }
        return current.value.compareTo(value) < 0
                ? containsNodeRecursive(current.right, value)
                : containsNodeRecursive(current.left, value);
    }
    public void delete(T value){
        root = deleteRecursive(root, value);
    }
    private Node<T> deleteRecursive(Node<T> current, T value){
        if (current == null){
            return null;
        }
        if (current.value.compareTo(value) == 0){
            if (current.left == null && current.right == null){
                return null;
            }
            if (current.right == null){
                return current.left;
            }
            if (current.left == null){
                return current.right;
            }
            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (current.value.compareTo(value) > 0){
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private T findSmallestValue(Node<T> root){
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    public void detourInOrder(){
        traverseInOrder(this.root);
    }
    private void traverseInOrder(Node<T> node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.print(" " + node.value.toString());
            traverseInOrder(node.right);
        }
    }
    public void detourPreOrder(){
        traversePreOrder(this.root);
    }
    private void traversePreOrder(Node<T> node){
        if (node != null){
            System.out.print(" " + node.value.toString());
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    public void detourPostOrder(){
        traversePostOrder(this.root);
    }
    private void traversePostOrder(Node<T> node){
        if (node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value.toString());
        }
    }
}
