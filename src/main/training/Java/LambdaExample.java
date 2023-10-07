package Java;

/**
 * In this program:
 * We define a functional interface MyFunction with a single abstract method operate that takes two integers and returns an integer.
 * We create lambda functions (lambda expressions) for addition, subtraction, multiplication, and division operations using the MyFunction functional interface.
 * The performOperation method takes two numbers and a functional interface as arguments and uses the lambda functions to perform the specified operation.
 * We demonstrate how to use lambda functions to perform arithmetic operations and handle division by zero using a lambda expression with a block of code.
 * Finally, we display the results of the operations.
 */



// Define a functional interface (an interface with a single abstract method)
interface MyFunction {
    int operate(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Lambda function to add two numbers
        MyFunction add = (a, b) -> a + b;

        // Lambda function to subtract two numbers
        MyFunction subtract = (a, b) -> a - b;

        // Lambda function to multiply two numbers
        MyFunction multiply = (a, b) -> a * b;

        // Lambda function to divide two numbers
        MyFunction divide = (a, b) -> {
            if (b != 0) {
                return a / b;
            } else {
                return -1; // Handle division by zero
            }
        };

        // Perform operations using lambda functions
        int result1 = performOperation(10, 5, add);
        int result2 = performOperation(20, 8, subtract);
        int result3 = performOperation(6, 4, multiply);
        int result4 = performOperation(8, 0, divide);

        // Display results
        System.out.println("Addition Result: " + result1);
        System.out.println("Subtraction Result: " + result2);
        System.out.println("Multiplication Result: " + result3);
        System.out.println("Division Result: " + result4);
    }

    // A method that takes two numbers and a functional interface as arguments
    public static int performOperation(int a, int b, MyFunction operation) {
        return operation.operate(a, b);
    }
}

