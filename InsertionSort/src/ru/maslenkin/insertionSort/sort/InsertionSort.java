package ru.maslenkin.insertionSort.sort;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * Created by Александр on 22.01.2018.
 */
public class InsertionSort {
    public static <E> ArrayList<E> sorting(ArrayList<E> list, Comparator<E> eComparator) {
        for (int i = 1; i < list.size(); i++) {
            E temp = list.get(i);
            int j = i;
            for (; j > 0 && eComparator.compare(temp, list.get(j - 1)) <= 0; j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(j, temp);
        }
        return list;
    }
}
