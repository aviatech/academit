package ru.academit.maslenkin.bst.main;

import ru.academit.maslenkin.bst.bst.BinarySearchTree;
import ru.academit.maslenkin.bst.bst.TreeNode;

/**
 * Created by Александр on 04.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        binarySearchTree.add(2);
        binarySearchTree.add(4);
        binarySearchTree.add(6);
        System.out.println(binarySearchTree.getSize());


    }
}
