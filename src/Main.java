import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the universal set (comma-separated): ");
        String[] universalArray = scanner.nextLine().split(",");
        CustomHashMap universalSet = createSet(universalArray);

        System.out.println("Enter Set A (comma-separated): ");
        String[] setAArray = scanner.nextLine().split(",");
        CustomHashMap setA = createSet(setAArray);

        System.out.println("Enter Set B (comma-separated): ");
        String[] setBArray = scanner.nextLine().split(",");
        CustomHashMap setB = createSet(setBArray);
        int choice;

        do {
            System.out.println("Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CustomHashMap resultUnion = SetOperations.union(setA, setB);
                    System.out.println("Union: " + resultUnion.toString());
                    break;
                case 2:
                    CustomHashMap resultIntersection = SetOperations.intersection(setA, setB);
                    System.out.println("Intersection: " + resultIntersection.toString());
                    break;
                case 3:
                    System.out.println("Complement of Set A: " + SetOperations.complement(universalSet, setA));
                    System.out.println("Complement of Set B: " + SetOperations.complement(universalSet, setB));
                    break;
                case 4:
                    System.out.println("Cartesian Product: " + SetOperations.cartesianProduct(setA, setB));
                    break;
                case 5:
                    System.out.println("Set Equality: " + SetOperations.setEquality(setA, setB));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }while(choice != 6);

        scanner.close();
    }

    public static CustomHashMap createSet(String[] elements) {
        CustomHashMap set = new CustomHashMap();
        for (String element : elements) {
            set.put(element.trim(), true);
        }
        return set;
    }


}