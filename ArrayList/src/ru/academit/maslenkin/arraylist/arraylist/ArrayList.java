package ru.academit.maslenkin.arraylist.arraylist;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Александр on 02.11.2017.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int length;
    private int modCount;

    public ArrayList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return length;
    }

    private class Itr implements Iterator<T> {
        private int cursor;
        private int expectedModCount = modCount;
        private int lastRet = -1;

        public Itr() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor != length;
        }

        @Override
        public T next() {
            int i = cursor;
            if (i >= length) {
                throw new NoSuchElementException();
            }
            T[] items = ArrayList.this.items;
            ++cursor;
            lastRet = i;
            return items[lastRet];
        }
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    public void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public void ensureCapacity(int length) {
        if (items.length < length) {
            items = Arrays.copyOf(items, length * 2);
        }
    }

    @Override
    public boolean contains(Object o) {
      return this.indexOf(o) !=-1;
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        System.arraycopy(items, 0, array, 0, length);
        return array;
    }

    @Override //вставка в конец
    public boolean add(T o) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = o;
        ++length;

        return true;
    }

    @Override   // удаление по значению
    public boolean remove(Object o) {
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(items[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int changeCount = 0;
        if (length + c.size() > items.length) {
            ensureCapacity(c.size() + length);
        }
        for (T element : c) {
            length++;
            items[length - 1] = element;
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
        if (length + c.size() > items.length) {
            ensureCapacity(length + c.size());
        }
        System.arraycopy(items, index, items, index + c.size(), length - index);
        length = length + c.size();
        int j = index;
        for (T e : c) {
            items[j] = e;
            j++;
            newModCount++;
            modCount++;
        }
        return newModCount != 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; ++i) {
            items[i] = null;
        }
        length = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        T temp = items[index];
        items[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) { //вставка по индексу
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        if (length > items.length) {        // если длина массива меньше увеличиваем в два раза
            increaseCapacity();
        }
        System.arraycopy(items, index, items, index + 1, length - index);
        items[index] = element;                    // перезаписываем элемент по индексу
        ++length;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        --length;
        modCount++;
        return items[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; --i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int newModCount = 0;
        for (int i = 0; i < length; ++i) {
            if (!c.contains(items[i])) {
                remove(items[i]);
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
                if (Objects.equals(items[i], element)) {
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
            stringBuilder.append(items[i]).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

