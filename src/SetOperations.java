public class SetOperations {
    public static CustomHashMap union(CustomHashMap setA, CustomHashMap setB) {
        CustomHashMap result = new CustomHashMap();


        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                result.put(current.key, true);
                current = current.next;
            }
        }


        for (int i = 0; i < setB.capacity; i++) {
            Entry current = setB.buckets[i];
            while (current != null) {
                result.put(current.key, true);
                current = current.next;
            }
        }

        return result;
    }

    public static CustomHashMap intersection(CustomHashMap setA, CustomHashMap setB) {
        CustomHashMap result = new CustomHashMap();

        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                if (setB.containsKey(current.key)) {
                    result.put(current.key, true);
                }
                current = current.next;
            }
        }

        return result;
    }

    public static CustomHashMap complement(CustomHashMap universalSet, CustomHashMap set) {
        CustomHashMap result = new CustomHashMap();

        for (int i = 0; i < universalSet.capacity; i++) {
            Entry current = universalSet.buckets[i];
            while (current != null) {
                if (!set.containsKey(current.key)) {
                    result.put(current.key, true);
                }
                current = current.next;
            }
        }

        return result;
    }

    public static boolean setEquality(CustomHashMap setA, CustomHashMap setB) {
        if (setA.size() != setB.size()) {
            return false;
        }

        for (int i = 0; i < setA.capacity; i++) {
            Entry current = setA.buckets[i];
            while (current != null) {
                if (!setB.containsKey(current.key)) {
                    return false;
                }
                current = current.next;
            }
        }

        return true;
    }

    public static String cartesianProduct(CustomHashMap setA, CustomHashMap setB) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < setA.capacity; i++) {
            Entry a = setA.buckets[i];
            while (a != null) {
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

        return result.toString();
    }
}
