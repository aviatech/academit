package ru.academit.maslenkin.singlylinkedlist.main;

import ru.academit.maslenkin.singlylinkedlist.singlylinkedlist.Node;
import ru.academit.maslenkin.singlylinkedlist.singlylinkedlist.SinglyLinkedList;

/**
 * Created by Александр on 02.12.2017.
 */
public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addTop(3);
        singlyLinkedList.add(1, 4);
        singlyLinkedList.add(2, 5);

        System.out.println("Список " + singlyLinkedList.toString());
        System.out.println("Удаление первого элемента");
        singlyLinkedList.deleteTop();
        System.out.println(singlyLinkedList.toString());
        singlyLinkedList.deleteTop();
        System.out.println(singlyLinkedList.toString());
        singlyLinkedList.deleteTop();
        System.out.println(singlyLinkedList.toString());

        singlyLinkedList.addTop(1);
        singlyLinkedList.add(1, 4);
        singlyLinkedList.add(2, 5);
        singlyLinkedList.add(3, 41);
        singlyLinkedList.add(4, 25);
        singlyLinkedList.add(5, 44);
        singlyLinkedList.add(6, 55);
        System.out.println("Список " + singlyLinkedList.toString());

        singlyLinkedList.delete(3);
        System.out.println("Удаление по индексу " + singlyLinkedList.toString());

        singlyLinkedList.deleteElement(25);
        System.out.println("Удаление по значению " + singlyLinkedList.toString());

        singlyLinkedList.setElement(0, 232);
        singlyLinkedList.setElement(1, 233);
        singlyLinkedList.setElement(4, 235);
        System.out.println("Изменение значения по индексу " + singlyLinkedList.toString());

        System.out.println("Получение значения по индексу " + singlyLinkedList.getElement(2).toString());

        Node<Integer> node = new Node<>(11);
        singlyLinkedList.insertAfter(1, node);
        System.out.println("Вставка после указанного узла " + singlyLinkedList.toString());

        singlyLinkedList.deleteAfter(2);
        System.out.println("Удаление после указанного узла " + singlyLinkedList.toString());

        singlyLinkedList.reverseList();
        System.out.println("Разворот" + singlyLinkedList.toString());

        ;
        System.out.println("Копирование " + singlyLinkedList.copyList());
    }
}
