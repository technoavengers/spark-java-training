package labs.java.lab_switchcase;

import java.util.Scanner;

/**
 * In this program:
 * We use the Scanner class to read user input for two numbers and the choice of operation.
 * The switch statement is used to select the appropriate operation based on the user's choice.
 * Depending on the chosen operation (1 for addition, 2 for subtraction, 3 for multiplication, and 4 for division), the program performs the corresponding calculation and displays the result.
 * If the user chooses an invalid option, the default case handles it and informs the user about the invalid choice
 *
 */

public class challenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt();

        double result;

        //TODO: write switch case statements to handle all scenarios
        /**
         * Depending on the chosen operation (1 for addition, 2 for subtraction, 3 for multiplication, and 4 for division), the program performs the corresponding calculation and displays the result.
         * If the user chooses an invalid option, the default case handles it and informs the user about the invalid choice
         */

        scanner.close();
    }
}