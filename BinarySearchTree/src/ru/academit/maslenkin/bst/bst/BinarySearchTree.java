package ru.academit.maslenkin.bst.bst;

import java.util.Comparator;

/**
 * Created by Александр on 04.02.2018.
 */
public class BinarySearchTree<T extends Comparable> {
    private TreeNode<T> root;

    public BinarySearchTree(T data) {
        root = new TreeNode<>(data);
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
                currentNode.getRight();
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
        }
    }


}
