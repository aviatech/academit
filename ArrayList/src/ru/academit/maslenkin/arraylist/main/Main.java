package ru.academit.maslenkin.arraylist.main;

import ru.academit.maslenkin.arraylist.arraylist.ArrayList;

/**
 * Created by Александр on 06.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(66);
        arrayList.add(null);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(53);

        System.out.println("Список 1 " + arrayList.toString());

        System.out.println("Размер " + arrayList.size());

        //добавление по индексу
        arrayList.add(0, 234);
        System.out.println("Добавление по  индексу " + arrayList.toString());

        //удаление
        arrayList.remove(0);
        System.out.println("Удаление по индексу" + arrayList.toString());

        arrayList.remove(arrayList.get(2));
        System.out.println("Удаление объекта " + arrayList.toString());

        //замена
        arrayList.set(0, 222);


        System.out.println(arrayList.get(1));

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(5);
        arrayList1.add(8);
        arrayList1.add(66);
        arrayList1.add(34);
        arrayList1.add(null);
        System.out.println("Список 2 " + arrayList1.toString());
        Integer object = 8;
        if (arrayList1.contains(object)) {
            System.out.println("arrayList1 содержит " + object);
        } else {
            System.out.println("arrayList1 не содержит " + object);
        }

        if (arrayList.containsAll(arrayList1)) {
            System.out.println("arrayList cодержит arrayList1");
        } else {
            System.out.println("Не содержит");
        }
        //lastIndexOf
        System.out.println(arrayList.lastIndexOf(3));

        arrayList.removeAll(arrayList1);
        System.out.println(arrayList.toString());

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(78);
        arrayList2.add(4);
        arrayList2.add(5);
        System.out.println(arrayList2.toString());
        arrayList.addAll(3, arrayList2);
        System.out.println(arrayList);

    }
}
