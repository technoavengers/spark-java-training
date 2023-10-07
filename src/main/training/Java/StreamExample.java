package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In this program:
 * We create a list of integers called numbers.
 * We use the Stream API to perform various operations on the list.
 * Filter: We use the filter method to select even numbers from the list using a lambda expression.
 * Map: We use the map method to square each number in the list using a lambda expression.
 * Reduce: We use the reduce method to calculate the sum of all numbers in the list using a lambda expression.
 * We collect the results using the collect method and display them.
 */
public class StreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Using the Stream API to perform operations on the list

        // 1. Filter: Select even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Lambda expression to filter even numbers
                .collect(Collectors.toList()); // Collect the filtered numbers into a list

        System.out.println("Even numbers: " + evenNumbers);

        // 2. Map: Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n) // Lambda expression to square each number
                .collect(Collectors.toList()); // Collect the squared numbers into a list

        System.out.println("Squared numbers: " + squaredNumbers);

        // 3. Reduce: Calculate the sum of all numbers
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // Lambda expression to reduce (sum) the numbers

        System.out.println("Sum of numbers: " + sum);
    }
}

