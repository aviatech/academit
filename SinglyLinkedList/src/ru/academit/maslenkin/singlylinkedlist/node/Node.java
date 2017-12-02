package ru.academit.maslenkin.singlylinkedlist.node;

/**
 * Created by Александр on 02.12.2017.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
