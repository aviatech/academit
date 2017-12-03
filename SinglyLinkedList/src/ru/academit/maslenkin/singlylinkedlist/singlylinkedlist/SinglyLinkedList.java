package ru.academit.maslenkin.singlylinkedlist.singlylinkedlist;

import ru.academit.maslenkin.singlylinkedlist.node.Node;
import sun.invoke.empty.Empty;

import java.util.Objects;

/**
 * Created by Александр on 02.12.2017.
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;

    }

    public SinglyLinkedList(T data) {
        head = new Node<>(data);
        size = 1;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead() {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    // получение головы списка
    public T getFirstNode() {
        return head.getData();
    }

    //изменение значения по индексу

    public T setData(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index);
        T tmp = node.getData();
        node.setData(data);
        return tmp;
    }

    //получение значения по индексу
    public T getElement(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).getData();
    }

    //получение узла по индексу
    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p;
        int i = 0;
        for (p = head; p != null; p = p.getNext()) {
            if (i == index) {
                break;
            }
            ++i;
        }
        return p;
    }

    //вставка в начало
    public void addTop(T object) {
        Node<T> node = new Node<T>(object);
        node.setNext(head);
        head = node;
        ++size;
    }

    // удаление первого элемента
    public T deleteTop() {
        T tmp = head.getData();
        head = head.getNext();
        --size;
        return tmp;
    }

    //добавление по индексу
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index - 1);
        Node<T> p = new Node<T>(data);
        p.setNext(node.getNext());
        node.setNext(p);
        ++size;
    }

    //удаление по индексу
    public T delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0) {
            return deleteTop();
        } else {
            Node<T> p = getNode(index - 1);
            Node<T> q = p.getNext();
            p.setNext(q.getNext());
            size--;
            return q.getData();
        }
    }

    //удаление по значению
    public boolean deleteElement(T object) {
        if (Objects.equals(object, head.getData())) {
            deleteTop();
            return true;
        }
        Node<T> p, q;
        for (p = head, q = p.getNext(); q != null; p = p.getNext(), q = p.getNext()) {
            if (Objects.equals(q.getData(), object)) {
                p.setNext(q.getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    //вставка после указанного узла
    public void insertAfter(int index, Node<T> object) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = getNode(index);
        object.setNext(p.getNext());
        p.setNext(object);
        size++;
    }

    //удаление после указанного узла
    public void deleteAfter(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> p = getNode(index);
            Node<T> q = p.getNext();
            p.setNext(q.getNext());
            size--;
        }
    }

    // разворот
    public void reverseList() {
        Node<T> tmp;
        for (Node<T> p = head, prev = null; p != null; prev = p, p = tmp) {
            tmp = p.getNext();
            p.setNext(prev);
            head = p;
        }
    }

    //копирование
    public SinglyLinkedList<T> copyList() {
        SinglyLinkedList<T> newSinglyLinkedList = new SinglyLinkedList<>(getHead().getData());
        for (Node<T> p = head.getNext(), q = newSinglyLinkedList.head; p != null; p = p.getNext(), q = q.getNext()) {
            q.setNext(new Node<>(p.getData()));
        }
        return newSinglyLinkedList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Node p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData());
            if (p.getNext() != null) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("}");
            }
        }
        return stringBuilder.toString();
    }
}
