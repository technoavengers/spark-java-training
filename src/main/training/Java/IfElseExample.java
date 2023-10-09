package Java;

/**
 * In this program:
 * We declare and initialize an int variable number to store a numeric value.
 * We use an if-else statement to check if number is even or odd. If the condition number % 2 == 0 is true, it means the number is even; otherwise, it's odd.
 * We use System.out.println to display whether the number is even or odd based on the if-else condition.
 * We also demonstrate the use of nested if-else statements to assign a letter grade (A, B, C, D, or F) to a student based on their exam score.
 * The comments in the code explain the purpose of each if-else statement and how they work
 */

public class IfElseExample {
    public static void main(String[] args) {
        // Declare and initialize a variable
        int number = 25;

        // Use an if-else statement to check if the number is even or odd
        if (number % 2 == 0) {
            // If the condition is true (number is even), execute this block
            System.out.println(number + " is an even number.");
        } else if(number%3 ==0) {
            // If the condition is false (number is odd), execute this block
            System.out.println(number + " is an divisble of 3 number.");
        }
        else{
            System.out.println("ood number other than 3");
        }

        // Demonstrate the use of nested if-else statements
        int score = 85;

        System.out.println("\nStudent Grade:");

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}

