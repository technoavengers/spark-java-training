package Java;

import java.util.Scanner;

/**
 * In this program:
 * The user is presented with a menu to check the balance, make a deposit, make a withdrawal, or exit the program.
 * The while loop continues to display the menu until the user chooses to exit (isRunning becomes false).
 * User input is obtained using the Scanner class.
 * The program validates input, performs transactions, and provides appropriate feedback to the user.
 * The user can repeatedly check their balance, deposit money, withdraw money, and exit the program.
 *
 */

public class SwitchCase {

    public static void  getInfo(double balance){
        System.out.println(balance);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0; // Initial account balance
        boolean isRunning = true;

        getInfo(balance);

        System.out.println("Welcome to Your Bank Account!");

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Make a Deposit");
            System.out.println("3. Make a Withdrawal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive value.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal successful!");
                    } else if (withdrawalAmount <= 0) {
                        System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using our banking services.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();




    }
}
