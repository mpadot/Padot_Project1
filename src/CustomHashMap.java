class Entry {
    String key;
    boolean value;
    Entry next;

    public Entry(String key, boolean value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}

public class CustomHashMap {
    public Entry[] buckets;
    public int capacity = 16;
    private int size = 0;


    public Entry[] getEntries() {
        return this.buckets;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public CustomHashMap() {
        buckets = new Entry[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(String key, boolean value) {
        int index = hash(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;
    }

    public Boolean get(String key) {
        int index = hash(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        Entry current = buckets[index];
        Entry prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < getCapacity(); i++) {
            Entry current = getEntries()[i];
            while (current != null) {
                result.append(current.key).append(", ");
                current = current.next;
            }
        }
        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        result.append("}");
        return result.toString();
    }
}
