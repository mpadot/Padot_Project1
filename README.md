Project: Custom HashMap with Set Operations

Description: A Java project that implements a custom HashMap without libraries and applies it to perform set operations: 
union, intersection, complement, Cartesian product, and set equality.

Features:  Custom HashMap using arrays and linked lists.
Set operations supported: Union, Intersection, Complement, Cartesian Product, and Set Equality
-Utilizes Command-line interface for input and output.

How to Use:
Run the Main class.
Follow prompts to:
1.Input the universal set.
2.Input two sets (Set A and Set B). 
3.Choose an operation.
4.View the output.
5.Continue if desired

Example input and output:
Enter the universal set (comma-separated): 
A, B, C, D, E
Enter Set A (comma-separated): 
A, B
Enter Set B (comma-separated): 
B, C
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
1
Union: {A, B, C}
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
2
Intersection: {B}
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
3
Complement of Set A: {C, D, E}
Complement of Set B: {A, D, E}
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
4
Cartesian Product: (A, B), (A, C), (B, B), (B, C), 
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
5
Set Equality: false
Choose operation: 1. Union 2. Intersection 3. Complement 4. Cartesian Product 5. Set Equality 6. Exit
6

File Structure
Entry.java: Key-value pair for HashMap.
CustomHashMap.java: Hashmap data structure.
SetOperations.java: Set operation methods.
Main.java: Runs the program and has switch statement for users choice.

Author
Developed by Miles Padot
