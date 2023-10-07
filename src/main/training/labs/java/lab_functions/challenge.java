package labs.java.lab_functions;

import java.util.Scanner;

/**
 * In this program:
 * We define a class that includes a main method as the entry point.
 * The program prompts the user to enter two numbers and choose an arithmetic operation.
 * We use the performOperation function (method) to perform the selected operation and return the result.
 * The performOperation function uses a switch statement to handle different arithmetic operations (addition, subtraction, multiplication, and division). It also checks for division by zero.
 * The result is displayed to the user.
 */


public class challenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt();

        //TODO: Call below function to perform arithmetic operation and display the result
        //double result = performOperation(num1, num2, choice);
        //System.out.println("Result: " + result);

        scanner.close();
    }

    //TODO: Write a Function to perform arithmetic operations based on user's choice
    /**
     * The performOperation function uses a switch statement to handle
     * different arithmetic operations (addition, subtraction, multiplication, and division). It also checks for division by zero.
     * It returns the result back
     */

}
