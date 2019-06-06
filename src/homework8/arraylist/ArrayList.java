package homework8.arraylist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private int position = 0;
    private boolean checkIsEmpty;
    private T[] array;

    public ArrayList() {
        checkIsEmpty = true;
        array = (T[]) new Object[2];
    }

    @Override
    public void add(T value) {
        checkIsEmpty = false;
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
        checkIsEmpty = false;
        if (index < array.length && index > -1) {
            array[index] = value;
        }
    }

    @Override
    public void addAll(List<T> list) {
        checkIsEmpty = false;
        int newArrayLength = array.length + list.size();
        array = Arrays.copyOf(array, newArrayLength);

        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = list.get(j);
                j++;
            }
        }
    }

    @Override
    public T get(int index) {
        if (index < array.length && index > -1 && array[index] != null) {
            return array[index];
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        checkIsEmpty = false;
        if (index < array.length && index > -1) {
            array[index] = value;
        }
    }

    @Override
    public T remove(int index) {
        if (index < array.length && index > -1) {
            T t = array[index];
            T[] tempArray = array;
            array = (T[]) new Object[tempArray.length - 1];

            for (int i = 0, j = 0; i <= array.length; i++) {
                if (i != index) {
                    array[j] = tempArray[i];
                    j++;
                }
            }
            return t;
        }
        return null;
    }

    @Override
    public T remove(T t) {
        int index = -1;
        if (t != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == t) {
                    index = i;
                    break;
                }
            }

            T[] tempArray = array;
            array = (T[]) new Object[tempArray.length - 1];

            for (int i = 0, j = 0; i <= array.length; i++) {
                if (i != index) {
                    array[j] = tempArray[i];
                    j++;
                }
            }
            return t;
        }
        return null;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return checkIsEmpty;
    }
}
