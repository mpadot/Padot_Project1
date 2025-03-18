// SetOperations class that provides utility methods for set operations
public class SetOperations {

    // Method to compute the union of two sets (setA ∪ setB)
    public static CustomHashMap union(CustomHashMap setA, CustomHashMap setB) {
        CustomHashMap result = new CustomHashMap(); // Resultant set for the union

        // Add all elements from setA to the result
        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                result.put(current.key, true);
                current = current.next;
            }
        }

        // Add all elements from setB to the result (duplicates are ignored)
        for (int i = 0; i < setB.capacity; i++) {
            Entry current = setB.buckets[i];
            while (current != null) {
                result.put(current.key, true);
                current = current.next;
            }
        }

        return result; // Return the union set
    }

    // Method to compute the intersection of two sets (setA ∩ setB)
    public static CustomHashMap intersection(CustomHashMap setA, CustomHashMap setB) {
        CustomHashMap result = new CustomHashMap(); // Resultant set for the intersection

        // Iterate through setA and add elements that also exist in setB
        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                if (setB.containsKey(current.key)) { // Check if setB contains the key
                    result.put(current.key, true);
                }
                current = current.next;
            }
        }

        return result; // Return the intersection set
    }

    // Method to compute the complement of a set (universalSet - set)
    public static CustomHashMap complement(CustomHashMap universalSet, CustomHashMap set) {
        CustomHashMap result = new CustomHashMap(); // Resultant set for the complement

        // Add elements from the universal set that are not in the given set
        for (int i = 0; i < universalSet.capacity; i++) {
            Entry current = universalSet.buckets[i];
            while (current != null) {
                if (!set.containsKey(current.key)) { // Check if the element is not in the given set
                    result.put(current.key, true);
                }
                current = current.next;
            }
        }

        return result; // Return the complement set
    }

    // Method to check if two sets are equal (setA == setB)
    public static boolean setEquality(CustomHashMap setA, CustomHashMap setB) {
        // If the sizes of the sets are not equal, they cannot be equal
        if (setA.size() != setB.size()) {
            return false;
        }

        // Check if every element in setA exists in setB
        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                if (!setB.containsKey(current.key)) { // If an element in setA is not in setB, they are not equal
                    return false;
                }
                current = current.next;
            }
        }

        return true; // Sets are equal if all checks pass
    }

    // Method to compute the Cartesian product of two sets (setA × setB)
    public static String cartesianProduct(CustomHashMap setA, CustomHashMap setB) {
        StringBuilder result = new StringBuilder(); // Resultant string for the Cartesian product

        // Iterate through each element in setA
        for (int i = 0; i < setA.capacity; i++) {
            Entry a = setA.buckets[i];
            while (a != null) {
                // Pair each element in setA with every element in setB
                for (int j = 0; j < setB.capacity; j++) {
                    Entry b = setB.buckets[j];
                    while (b != null) {
                        result.append("(").append(a.key).append(", ").append(b.key).append("), ");
                        b = b.next;
                    }
                }
                a = a.next;
            }
        }

        return result.toString(); // Return the Cartesian product as a string
    }
}
