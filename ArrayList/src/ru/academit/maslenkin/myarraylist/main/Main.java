package ru.academit.maslenkin.myarraylist.main;

import ru.academit.maslenkin.myarraylist.myarraylist.MyArrayList;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Александр on 06.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(8);
        myArrayList.add(66);
        myArrayList.add(null);
        myArrayList.add(7);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(53);

        System.out.println("Список 1 " + myArrayList.toString());

        System.out.println("Размер " + myArrayList.size());

        //добавление по индексу
        myArrayList.add(0, 234);
        System.out.println("Добавление по  индексу " + myArrayList.toString());

        //удаление
        myArrayList.remove(0);
        System.out.println("Удаление по индексу" + myArrayList.toString());

        myArrayList.remove(myArrayList.get(2));
        System.out.println("Удаление объекта " + myArrayList.toString());

        //замена
        myArrayList.set(0, 222);


        System.out.println(myArrayList.get(1));

        ArrayList<Integer> arrayList1 = new ArrayList<>();
       arrayList1.add(15);
       arrayList1.add(81);
        arrayList1.add(616);
        // myArrayList1.add(34);
        //arrayList1.add(null);
        //System.out.println("Список 2 " + ArrayList1.toString());
        Integer object = 8;
        if (arrayList1.contains(object)) {
            System.out.println("myArrayList1 содержит " + object);
        } else {
            System.out.println("myArrayList1 не содержит " + object);
        }

        boolean res = arrayList1.containsAll(myArrayList);
        System.out.println(res);

        /*if (myArrayList.containsAll(myArrayList1)) {

               System.out.println("myArrayList cодержит myArrayList1");
        } else {
            System.out.println("Не содержит");
        }*/
        //lastIndexOf
        System.out.println(myArrayList.lastIndexOf(3));

       // myArrayList.removeAll(myArrayList1);
        System.out.println(myArrayList.toString());


        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(78);
        myArrayList2.add(4);
        myArrayList2.add(5);
        System.out.println(myArrayList2.toString());
        myArrayList.addAll(3, myArrayList2);
        System.out.println(myArrayList);

    }
}
