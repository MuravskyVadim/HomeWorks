package homework8.arraylist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int ARRAY_LENGTH = 10;
    private int position = 0;
    private T[] array;

    public ArrayList() {
        array = (T[]) new Object[ARRAY_LENGTH];
    }

    @Override
    public void add(T value) {
        if (position >= array.length) {
            int newArrayLength = array.length + (array.length >> 1);
            array = Arrays.copyOf(array, newArrayLength);
        }
        array[position] = value;
        position++;
    }

    @Override
    public void add(T value, int index) {
        if (position >= array.length || index > position) {
            throw new IndexOutOfBoundsException();
        } else {
            T[] tempArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, tempArray, 0, index);
            tempArray[index] = value;
            System.arraycopy(array, index, tempArray, index + 1, array.length - index);
            array = tempArray;
            position++;
        }
    }

    @Override
    public void addAll(List<T> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
        }
    }

    @Override
    public T get(int index) {
        if (index < size() && index > -1) {
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(T value, int index) {
        if (index > position || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            array[index] = value;
        }
    }

    @Override
    public T remove(int index) {
        if (index > position || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T t = array[index];
            T[] tempArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, tempArray, 0, index);
            System.arraycopy(array, index + 1, tempArray, index, array.length - index - 1);
            array = tempArray;
            position--;
            return t;
        }
    }

    @Override
    public T remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == t) {
                remove(i);
                return t;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }
}
