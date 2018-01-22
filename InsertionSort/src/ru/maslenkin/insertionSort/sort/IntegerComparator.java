package ru.maslenkin.insertionSort.sort;

import java.util.Comparator;

/**
 * Created by Александр on 22.01.2018.
 */
public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
