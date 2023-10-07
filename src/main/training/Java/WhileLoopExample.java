package Java;

public class WhileLoopExample {
    public static void main(String[] args) {
        // This program demonstrates a simple while loop.

        // The while loop has one part:
        // 1. Condition: Check if the loop should continue based on a condition.

        // In this example, we're using a while loop to count from 1 to 5.

        // Part 1: Condition - Initialize a loop variable 'i' to 1.
        int i = 1;

        while (i <= 5) {
            // Check if 'i' is less than or equal to 5.
            // If true, the loop continues; otherwise, it exits.

            // Print the value of 'i'.
            System.out.println("Count: " + i);

            // Increment 'i' by 1 for the next iteration.
            i++;
        }

        // The loop exits when 'i' becomes greater than 5.
        System.out.println("Loop finished!");
    }
}
