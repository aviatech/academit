package ru.academit.maslenkin.myhashtable.myhashtable.main;

import ru.academit.maslenkin.myhashtable.myhashtable.myhashtable.MyHashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Александр on 13.12.2017.
 */
public class Main {

    public static void main(String[] args) {
        MyHashTable<Integer> myHashTable = new MyHashTable<>();
        MyHashTable<Integer> myHashTable1 = new MyHashTable<>();

        myHashTable.add(3);
        myHashTable.add(2);
        myHashTable.add(6);
        myHashTable.add(10);
        myHashTable.add(null);

        System.out.println(myHashTable.size());

        myHashTable1.add(31);
        myHashTable1.add(21);
        myHashTable1.add(422);

        myHashTable.addAll(myHashTable1);
        System.out.println(myHashTable.contains(422));
        System.out.println(myHashTable.containsAll(myHashTable1));

        myHashTable.remove(31);
        System.out.println(myHashTable.contains(31));
        System.out.println(myHashTable.size());

        myHashTable.removeAll(myHashTable1);
        System.out.println(myHashTable.containsAll(myHashTable1));

        System.out.println(myHashTable1.size());
        myHashTable1.clear();
        System.out.println(myHashTable1.size());

        Integer[] array = new Integer[5];
        myHashTable.toArray(array);
        for (Integer e : array) {
            System.out.println(e);
        }
    }
}
