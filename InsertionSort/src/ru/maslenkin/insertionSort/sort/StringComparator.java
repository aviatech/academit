package ru.maslenkin.insertionSort.sort;

import java.util.Comparator;

/**
 * Created by Александр on 22.01.2018.
 */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
