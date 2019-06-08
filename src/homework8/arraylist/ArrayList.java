package homework8.arraylist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private int position = 0;
    private T[] array;

    public ArrayList() {
        array = (T[]) new Object[10];
    }

    @Override
    public void add(T value) {
        if (position < array.length) {
            array[position] = value;
            position++;
        } else {
            int newArrayLength = array.length + (array.length >> 1);
            array = Arrays.copyOf(array, newArrayLength);
            array[position] = value;
            position++;
        }
    }

    @Override
    public void add(T value, int index) {
        try {
            T[] tempArray = (T[]) new Object[array.length + 1];
            System.arraycopy(array, 0, tempArray, 0, index);
            tempArray[index] = value;
            System.arraycopy(array, index, tempArray, index + 1, array.length - index);
            array = tempArray;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        try {
            return array[index];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        try {
            array[index] = value;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T remove(int index) {
        try {
            T t = array[index];
            T[] tempArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, tempArray, 0, index);
            System.arraycopy(array, index + 1, tempArray, index, array.length - index - 1);
            array = tempArray;
            return t;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
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
        int count = 0;

        for (T t : array) {
            if (t != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }
}
