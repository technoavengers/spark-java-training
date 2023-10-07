package Java;


/**
 * A simple Java program that uses a for loop to count from 1 to 5,
 *
 */
public class ForLoopExample {
    public static void main(String[] args) {
        // This program demonstrates a simple for loop.

        // The for loop has three parts:
        // 1. Initialization: Initialize the loop variable.
        // 2. Condition: Check if the loop should continue based on a condition.
        // 3. Iteration: Update the loop variable in each iteration.

        // In this example, we're using a for loop to count from 1 to 5.

        // Part 1: Initialization - Initialize a loop variable 'i' to 1.
        for (int i = 1; i <= 5; i++) {
            // Part 2: Condition - Check if 'i' is less than or equal to 5.
            // If true, the loop continues; otherwise, it exits.

            // Part 3: Iteration - 'i' is incremented by 1 in each iteration.

            // Print the value of 'i' in each iteration.
            System.out.println("Count: " + i);
        }

        // The loop exits when 'i' becomes greater than 5.
        System.out.println("Loop finished!");
    }
}

