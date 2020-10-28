package com.company;

public class BinaryTree<T extends Comparable<T>>{
    Node root;
    public void Add(T value){
        root = addRecursive(root, value);
    }
    private Node addRecursive(Node current, T value){
        if (current == null){
            return new Node(value);
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
    private boolean containsNodeRecursive(Node current, T value){
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
    public void Delete(T value){
        root = deleteRecursive(root, value);
    }
    private Node deleteRecursive(Node current, T value){
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
    private T findSmallestValue(Node root){
        return root.left == null ? (T)root.value : findSmallestValue(root.left);
    }
    public void traverseInOrder(Node node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    public void traversePreOrder(Node node){
        if (node != null){
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    public void traversePostOrder(Node node){
        if (node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
}
