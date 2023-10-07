package Java;
import java.util.ArrayList; // Import the ArrayList class


/**
 * In this program:
 * We import the ArrayList class from the java.util package.
 * We create an ArrayList named fruits that holds strings.
 * We add elements ("Apple," "Banana," "Cherry," and "Date") to the fruits ArrayList using the add method.
 * We use a for-each loop to iterate through the elements of the fruits ArrayList and print them.
 * We get the size of the fruits ArrayList using the size method and print it.
 * We check if the fruits ArrayList is empty using the isEmpty method and print the result.
 * We modify an element in the fruits ArrayList using the set method.
 * We remove an element ("Banana") from the fruits ArrayList using the remove method.
 * Finally, we print the modified fruits ArrayList to show the changes made.
 */
public class ArrayListExample {
    public static void main(String[] args) {
            // Create an ArrayList of strings
            ArrayList<String> fruits = new ArrayList<>();

            // Add elements to the ArrayList
            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Cherry");
            fruits.add("Date");

            // Access and print elements in the ArrayList
            System.out.println("ArrayList elements:");

            for (String fruit : fruits) {
                System.out.println(fruit);
            }

            // Get the size of the ArrayList
            int size = fruits.size();
            System.out.println("\nSize of the ArrayList: " + size);

            // Check if the ArrayList is empty
            boolean isEmpty = fruits.isEmpty();
            System.out.println("Is the ArrayList empty? " + isEmpty);

            // Modify an element in the ArrayList
            fruits.set(2, "Grapes");

            // Remove an element from the ArrayList
            fruits.remove("Banana");

            // Print the modified ArrayList
            System.out.println("\nModified ArrayList:");

            for (String fruit : fruits) {
                System.out.println(fruit);
            }
        }
    }
