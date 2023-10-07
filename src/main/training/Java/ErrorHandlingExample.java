package Java;

import java.util.Scanner;


/**
 * In this program:
 * We import the java.util.Scanner class to read user input.
 * We create a try block to wrap the code that may potentially throw exceptions.
 * We use a Scanner object to prompt the user to enter a number as a string.
 * Inside the try block:
 * We attempt to parse the user's input string into an integer using Integer.parseInt.
 * We intentionally perform a division by zero (10 / number) to trigger an ArithmeticException.
 * We use catch blocks to handle specific exceptions:
 * NumberFormatException: This is thrown if the user's input is not a valid integer.
 * ArithmeticException: This is thrown if division by zero occurs.
 * In each catch block, we display an error message to inform the user about the specific error.
 * We use a finally block to ensure that the Scanner is closed to release resources, regardless of whether exceptions occurred or not.
 */


public class ErrorHandlingExample {
    public static void main(String[] args) {

            // Create a Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter a number
            System.out.print("Enter a number: ");

            try {
                // Read the user's input as a string
                String userInput = scanner.nextLine();

                // Parse the string to an integer
                int number = Integer.parseInt(userInput);

                // Perform a division by zero to trigger an exception (divide by 0)
                int result = 10 / number;

                // Display the result
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                // Handle the NumberFormatException if the user's input is not a valid integer
                System.err.println("Error: Invalid number format. Please enter a valid integer.");
            } catch (ArithmeticException e) {
                // Handle the ArithmeticException if division by zero occurs
                System.err.println("Error: Division by zero is not allowed.");
            } finally {
                // Close the scanner to release resources
                scanner.close();
            }
        }
    }

