// Entry class representing a single key-value pair in the hash map
class Entry {
    String key; // Key of the entry
    boolean value; // Value associated with the key
    Entry next; // Reference to the next entry in the same bucket (for collision handling)

    // Constructor to initialize an entry with a key and value
    public Entry(String key, boolean value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// CustomHashMap class implementing a simple hash map with separate chaining for collision handling
public class CustomHashMap {
    public Entry[] buckets; // Array of buckets, each containing a linked list of entries
    public int capacity = 16; // Default capacity of the hash map
    private int size = 0; // Number of key-value pairs in the hash map

    // Getter method to retrieve all bucket entries
    public Entry[] getEntries() {
        return this.buckets;
    }

    // Getter method to retrieve the capacity of the hash map
    public int getCapacity() {
        return this.capacity;
    }

    // Constructor to initialize the hash map with the default capacity
    public CustomHashMap() {
        buckets = new Entry[capacity];
    }

    // Hash function to compute the index of a bucket for a given key
    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Method to add a key-value pair to the hash map
    public void put(String key, boolean value) {
        int index = hash(key); // Calculate the bucket index
        Entry current = buckets[index]; // Get the head of the linked list at the bucket

        // Iterate through the linked list to check if the key already exists
        while (current != null) {
            if (current.key.equals(key)) {
                // If key exists, update its value
                current.value = value;
                return;
            }
            current = current.next;
        }

        // If key does not exist, create a new entry and add it to the bucket
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++; // Increment the size of the hash map
    }

    // Method to retrieve the value associated with a key
    public Boolean get(String key) {
        int index = hash(key); // Calculate the bucket index
        Entry current = buckets[index]; // Get the head of the linked list at the bucket

        // Iterate through the linked list to find the key
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value; // Return the value if key is found
            }
            current = current.next;
        }

        return null; // Return null if key is not found
    }

    // Method to remove a key-value pair from the hash map
    public void remove(String key) {
        int index = hash(key); // Calculate the bucket index
        Entry current = buckets[index]; // Get the head of the linked list at the bucket
        Entry prev = null; // Previous entry for updating the linked list

        // Iterate through the linked list to find the key
        while (current != null) {
            if (current.key.equals(key)) {
                // Remove the entry by updating references
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--; // Decrement the size of the hash map
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Method to check if the hash map contains a given key
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // Method to return the number of key-value pairs in the hash map
    public int size() {
        return size;
    }

    // Override toString method to represent the hash map as a string
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        // Iterate through all buckets
        for (int i = 0; i < getCapacity(); i++) {
            Entry current = getEntries()[i];
            // Iterate through the linked list in each bucket
            while (current != null) {
                result.append(current.key).append(", "); // Append key to the result string
                current = current.next;
            }
        }
        // Remove the trailing comma and space, if present
        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        result.append("}");
        return result.toString();
    }
}
