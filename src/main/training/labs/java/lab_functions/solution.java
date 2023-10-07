package labs.java.lab_functions;

import java.util.Scanner;

public class solution {

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

        double result = performOperation(num1, num2, choice);

        System.out.println("Result: " + result);

        scanner.close();
    }

    // Function to perform arithmetic operations based on user's choice
    public static double performOperation(double num1, double num2, int choice) {
        switch (choice) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return Double.NaN; // Return NaN (Not-a-Number) for division by zero
                }
            default:
                System.out.println("Invalid choice. Please select a valid operation.");
                return Double.NaN;
        }
    }
}
