import java.util.Scanner;

// Main class to execute the set operations program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to input the universal set as a comma-separated list
        System.out.println("Enter the universal set (comma-separated): ");
        String[] universalArray = scanner.nextLine().split(",");
        CustomHashMap universalSet = createSet(universalArray);

        // Prompting the user to input Set A as a comma-separated list
        System.out.println("Enter Set A (comma-separated): ");
        String[] setAArray = scanner.nextLine().split(",");
        CustomHashMap setA = createSet(setAArray);

        // Prompting the user to input Set B as a comma-separated list
        System.out.println("Enter Set B (comma-separated): ");
        String[] setBArray = scanner.nextLine().split(",");
        CustomHashMap setB = createSet(setBArray);
        int choice; // Variable to store the user's operation choice

        do {
            // Displaying menu of operations to the user
            System.out.println("Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Perform and display the union of Set A and Set B
                    CustomHashMap resultUnion = SetOperations.union(setA, setB);
                    System.out.println("Union: " + resultUnion.toString());
                    break;
                case 2:
                    // Perform and display the intersection of Set A and Set B
                    CustomHashMap resultIntersection = SetOperations.intersection(setA, setB);
                    System.out.println("Intersection: " + resultIntersection.toString());
                    break;
                case 3:
                    // Perform and display the complement of Set A and Set B
                    System.out.println("Complement of Set A: " + SetOperations.complement(universalSet, setA));
                    System.out.println("Complement of Set B: " + SetOperations.complement(universalSet, setB));
                    break;
                case 4:
                    // Perform and display the Cartesian product of Set A and Set B
                    System.out.println("Cartesian Product: " + SetOperations.cartesianProduct(setA, setB));
                    break;
                case 5:
                    // Check and display if Set A is equal to Set B
                    System.out.println("Set Equality: " + SetOperations.setEquality(setA, setB));
                    break;
                case 6:
                    // Exit the program
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6); // Loop until the user chooses to exit

        scanner.close(); // Close the scanner to release resources
    }

    // Helper method to create a set from an array of elements
    public static CustomHashMap createSet(String[] elements) {
        CustomHashMap set = new CustomHashMap();
        for (String element : elements) {
            set.put(element.trim(), true); // Add each trimmed element to the set
        }
        return set; // Return the constructed set
    }
}
