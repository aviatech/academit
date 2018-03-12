package ru.academit.maslenkin.bst.bst;

import java.util.Comparator;

/**
 * Created by Александр on 04.02.2018.
 */
public class BinarySearchTree<T extends Comparable> {
    private TreeNode<T> root;
    private int size;

 /*   public BinarySearchTree(T data) {
        root = new TreeNode<>(data);
        size = 1;
    }*/

    public BinarySearchTree() {
        root = null;
        size = 1;
    }

    public TreeNode<T> getRoot(){
        return root;
    }

    public int getSize() {
        return size;
    }


    public int compare(T data, T currentNode) {
        //noinspection unchecked
        return data.compareTo(currentNode);
    }

    public void add(T data) {
        TreeNode<T> currentNode = root;
        TreeNode<T> parentNode = null;
        while (currentNode != null) {
            int result = compare(data, currentNode.getData());
            parentNode = currentNode;
            if (result <= 0) {
                currentNode = currentNode.getLeft();
            } else
                currentNode = currentNode.getRight();
        }
        TreeNode<T> p = new TreeNode<>(data);
        if (parentNode == null) {
            root = p;
        } else {
            int result = compare(data, parentNode.getData());
            if (result <= 0) {
                parentNode.setLeft(p);
            } else {
                parentNode.setRight(p);
            }
            ++size;
        }
    }

    public void delete(T data) {
        TreeNode<T> p = root;
        TreeNode<T> parent = null;
    }


    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
