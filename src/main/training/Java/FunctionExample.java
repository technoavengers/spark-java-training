package Java;

/**
 * In this program:
 * We define two functions (add and findMax) within the FunctionExample class.
 * The add function takes two integer parameters (num1 and num2), calculates their sum, and returns the result.
 * The findMax function takes two integer parameters (num1 and num2), compares them, and returns the larger of the two.
 * In the main method, we call these functions and store the results in variables (result1 and result2).
 * We then print the results using System.out.println.
 */
public class FunctionExample {

    // Function to add two integers and return the result
    public static int add(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    // Function to find the maximum of two numbers and return the result
    public static int findMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static void main(String[] args) {
        // Call the 'add' function and store the result in a variable
        int result1 = add(5, 3);

        // Call the 'findMax' function and store the result in a variable
        int result2 = findMax(8, 12);

        // Display the results
        System.out.println("Result of addition: " + result1);
        System.out.println("Maximum number: " + result2);
    }
}

