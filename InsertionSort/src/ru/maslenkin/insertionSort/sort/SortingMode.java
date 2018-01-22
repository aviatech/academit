package ru.maslenkin.insertionSort.sort;

import java.util.Comparator;

/**
 * Created by Александр on 22.01.2018.
 */
public class SortingMode {
    public static <T> Comparator<T> select(String sortingMode, Comparator<T> eComparator) {
        if (sortingMode.equals("-a")) {
            return eComparator;
        }
        if (sortingMode.equals("-d")) {
            return eComparator.reversed();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
