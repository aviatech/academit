package ru.academit.maslenkin.myhashtable.myhashtable.myhashtable;

import java.util.*;

/**
 * Created by 11111 on 12.12.14.
 */
public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] arrayHashTable;
    private int lengthHashTable;
    private int modCount;

    public MyHashTable() {
        //noinspection unchecked
        arrayHashTable = new ArrayList[100];
    }

    private int getIndex(Object obj) {
        return (obj == null) ? 0 : Math.abs(obj.hashCode() % arrayHashTable.length);
    }

    private class MyIterator implements Iterator<T> {
        private int cursor = -1;
        int expectedModCount = modCount;
        private int cursorListIndex = 0;
        private int index = 0;

        @Override
        public boolean hasNext() {    // достигнут ли конец коллекции
            return cursor + 1 < lengthHashTable;
        }

        @Override
        public T next() {
            if (cursor + 1 > lengthHashTable) {
                throw new NoSuchElementException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            for (int i = cursorListIndex; i < arrayHashTable.length; ++i) {
                cursorListIndex = i;
                if (arrayHashTable[i] != null && arrayHashTable[i].size() > 0) {
                    T tmp = arrayHashTable[i].get(index);
                    ++cursor;
                    ++index;
                    if (index == arrayHashTable[i].size()) {
                        ++cursorListIndex;
                        index = 0;
                    }
                    return tmp;
                }
            }
            return null;
        }
    }

    @Override
    public int size() {
        return lengthHashTable;
    }

    @Override
    public boolean isEmpty() {
        return lengthHashTable == 0;
    }

    @Override
    public boolean contains(Object obj) {
        int i = getIndex(obj);
        return arrayHashTable[i] != null && arrayHashTable[i].contains(obj);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[lengthHashTable];
        int i = 0;
        for (T element : this) {
            array[i] = element;
            ++i;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < lengthHashTable) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(toArray(), lengthHashTable, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, a, 0, lengthHashTable);
        if (a.length > lengthHashTable) {
            a[lengthHashTable] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        int i = getIndex(t);
        if (arrayHashTable[i] == null) {
            arrayHashTable[i] = new ArrayList<>();
        }
        arrayHashTable[i].add(t);
        ++lengthHashTable;
        ++modCount;
        return true;

    }

    @Override
    public boolean remove(Object o) {
        int i = getIndex(o);
        if (arrayHashTable[i] == null || arrayHashTable[i].size() < 1){
            return false;
        }
            if (arrayHashTable[i].remove(o)) {
                --lengthHashTable;
                ++modCount;
                return true;
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int changeCount = 0;
        for (T element : c) {
            add(element);
            changeCount++;
        }
        return changeCount != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int changeCount = 0;
        for (Object element : c) {
            int i = getIndex(element);
            if (arrayHashTable[i] != null && arrayHashTable[i].size() >= 1) {
                while (remove(element)) {
                    ++changeCount;
                }
            }
        }
        return changeCount != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int changeCount = 0;
        for (ArrayList<T> list : arrayHashTable) {
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (!c.contains(list.get(i))) {
                        list.remove(i);
                        --lengthHashTable;
                        --i;
                        ++changeCount;
                    }
                }
            }
        }
        return changeCount != 0;
    }

    @Override
    public void clear() {
        for (ArrayList<T> list : arrayHashTable) {
            if (list != null && list.size() > 0) {
                list.clear();
                ++modCount;
            }
        }
        lengthHashTable = 0;
    }
}
