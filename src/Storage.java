public class Storage<T, K> {
    private static final int ARRAY_LENGTH = 10;
    private T[] keysArray;
    private K[] valuesArray;

    public Storage() {
        keysArray = (T[]) new Object[ARRAY_LENGTH];
        valuesArray = (K[]) new Object[ARRAY_LENGTH];
    }

    public K get(T key) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (keysArray[i].equals(key)) {
                return valuesArray[i];
            }
        }
        return null;
    }

    public void put(T key, K value) {
        if (key != null && value != null) {
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                if ((keysArray[i] == null && valuesArray[i] == null) || key.equals(keysArray[i])) {
                    keysArray[i] = key;
                    valuesArray[i] = value;
                    break;
                }
            }
        }
    }
}
