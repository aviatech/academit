package ru.academit.maslenkin.myarraylist.myarraylist;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Александр on 02.11.2017.
 */
public class MyArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData;
    private int length;
    private int modCount;
    private int size;

    public MyArrayList() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }
    }


    private class MyListIterator extends MyIterator implements ListIterator<T> {
        MyListIterator(int index) {
            super();
            cursor = index;
        }

        public MyListIterator() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return cursor + 1 < length;
        }

        @Override
        public T next() {
            if (cursor + 1 >= length) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            ++cursor;
            return elementData[cursor];
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public T previous() {
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i;
            return (T) elementData[lastRet = i];
        }


        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(cursor);
            expectedModCount = modCount;
        }

        @Override
        public void set(T t) {
            elementData[cursor] = t;
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(cursor, t);
            expectedModCount = modCount;
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void increaseCapacity() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    public void ensureCapacity(int length) {
        if (elementData.length < length) {
            elementData = Arrays.copyOf(elementData, length * 2);
        }
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        System.arraycopy(elementData, 0, array, 0, length);
        return array;
    }

    @Override //вставка в конец
    public boolean add(T o) {
        if (length >= elementData.length) {
            increaseCapacity();
        }
        elementData[length] = o;
        ++length;

        return true;
    }

    @Override   // удаление по значению
    public boolean remove(Object o) {
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(elementData[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int changeCount = 0;
        if (length + c.size() > elementData.length) {
            ensureCapacity(c.size() + length);
        }
        for (T element : c) {
            length++;
            elementData[length - 1] = element;
            changeCount++;
            modCount++;
        }
        return changeCount != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int newModCount = 0;
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        if (length + c.size() > elementData.length) {
            ensureCapacity(length + c.size());
        }
        System.arraycopy(elementData, index, elementData, index + c.size(), length - index);
        length = length + c.size();
        int j = index;
        for (T e : c) {
            elementData[j] = e;
            j++;
            newModCount++;
            modCount++;
        }
        return newModCount != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; ++i) {
            elementData[i] = null;
        }
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        return elementData[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        T temp = elementData[index];
        elementData[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) { //вставка по индексу
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        if (length > elementData.length) {        // если длина массива меньше увеличиваем в два раза
            increaseCapacity();
        }
        System.arraycopy(elementData, index, elementData, index + 1, length - index);
        elementData[index] = element;                    // перезаписываем элемент по индексу
        ++length;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        if (index < length - 1) {
            System.arraycopy(elementData, index + 1, elementData, index, length - index - 1);
        }
        --length;
        modCount++;
        return elementData[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(elementData[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; --i) {
            if (Objects.equals(elementData[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        return new MyListIterator();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int newModCount = 0;
        for (int i = 0; i < length; ++i) {
            if (!c.contains(elementData[i])) {
                remove(elementData[i]);
                newModCount++;
                i--;
            }
        }
        return newModCount != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int newModCount = 0;
        for (Object element : c) {
            for (int i = 0; i < length; ++i) {
                if (Objects.equals(elementData[i], element)) {
                    this.remove(i);
                    --i;
                    newModCount++;
                }
            }
        }
        return newModCount != 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < length; ++i) {
            stringBuilder.append(elementData[i]).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

