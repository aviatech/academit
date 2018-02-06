package ru.maslenkin.insertionSort.sort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Александр on 22.01.2018.
 */
public class InsertionSort {
    public static <E> ArrayList<E> sorting(ArrayList<E> list, Comparator<E> eComparator) {
        for (int i = 0; i < list.size(); i++) {
            E temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && eComparator.compare(temp, list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                --j;
            }
            list.set(j + 1, temp);
        }
        return list;
    }
}
