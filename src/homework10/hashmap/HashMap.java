package homework10.hashmap;

import java.util.NoSuchElementException;

public class HashMap<K, V> {
    private static final int INITIAL_SIZE = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private static int size = 0;
    private Entry<K, V>[] entries;

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> entryNext;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (isEmpty()) {
            entries = new Entry[INITIAL_SIZE];
        }

        if (checkLoadEntries()) {
            reSize();
        }

        int index = getIndexByHash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (entries[index] == null) {
            entries[index] = newEntry;
        } else {
            Entry<K, V> entry = entries[index];
            if ((key == null && entry.getKey() == null) || entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }

            entry = entry.entryNext;

            while ((entry) != null) {
                if (entry.entryNext.getKey().equals(key)) {
                    entry.entryNext.setValue(value);
                    return;
                }
                entry = entry.entryNext;
            }
        }
        size++;
    }

    public V get(K key) {
        int index = getIndexByHash(key);
        Entry<K, V> entry = entries[index];

        if (entry == null) {
            throw new NoSuchElementException();
        }

        Entry<K, V> entryNext;

        if ((entryNext = entry.entryNext) != null) {
            while ((entryNext) != null) {
                if (entryNext.entryNext.getKey().equals(key)) {
                    return entryNext.entryNext.getValue();
                }
                entryNext = entryNext.entryNext;
            }
        }
        return entry.getValue();
    }

    public int size() {
        return size;
    }

    private boolean checkLoadEntries() {
        return size >= LOAD_FACTOR * entries.length;
    }

    private void reSize() {
        Entry<K, V>[] oldEntries = entries;

        entries = new Entry[entries.length << 1];

        for (Entry<K, V> entry : oldEntries) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
                size--;
            }
        }
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int getIndexByHash(K key) {
        return hash(key) % entries.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
