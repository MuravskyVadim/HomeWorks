public class Storage<K, V> {
    private static final int ARRAY_LENGTH = 3;
    private K[] keysArray;
    private V[] valuesArray;

    public Storage() {
        keysArray = (K[]) new Object[ARRAY_LENGTH];
        valuesArray = (V[]) new Object[ARRAY_LENGTH];
    }

    public V get(K key) {
        for (int i = 0; i < keysArray.length; i++) {
            if (key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (key != null && value != null) {
            for (int i = 0; i < keysArray.length; i++) {
                if ((keysArray[i] == null && valuesArray[i] == null) || key.equals(keysArray[i])) {
                    keysArray[i] = key;
                    valuesArray[i] = value;
                    break;
                }else if(i == keysArray.length-1){
                    increaseSize();
                    i = 0;
                }
            }
        }
    }

    public void increaseSize() {
        int newArrayLength = keysArray.length + (keysArray.length >> 1);
        K[] newK = (K[]) new Object[newArrayLength];
        V[] newV = (V[]) new Object[newArrayLength];

        for (int i = 0; i < keysArray.length; i++) {
            newK[i] = keysArray[i];
            newV[i] = valuesArray[i];
        }

        keysArray = newK;
        valuesArray = newV;
    }
}
