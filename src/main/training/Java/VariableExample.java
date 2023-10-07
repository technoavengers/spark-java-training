package Java;

/**
 * In this program:
 * We declare and initialize several variables of different types:
 * An int variable age to store an age value.
 * A double variable salary to store a salary value.
 * A String variable name to store a name.
 * A boolean variable isEmployed to store an employment status.
 * We use the System.out.println method to display the values of these variables.
 * After displaying the initial values, we modify the values of the age, salary, and isEmployed variables.
 * Finally, we display the updated values to show how variables can change.
 */
public class VariableExample {
    public static void main(String[] args) {
        // Declare and initialize variables
        int age = 30; // An integer variable to store age
        double salary = 45000.50; // A double variable to store salary
        String name = "John"; // A string variable to store name
        boolean isEmployed = true; // A boolean variable to store employment status

        // Display variable values
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
        System.out.println("Employed: " + isEmployed);

        // Modify variable values
        age = 31;
        salary = 46000.75;
        isEmployed = false;

        // Display modified variable values
        System.out.println("\nUpdated Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
        System.out.println("Employed: " + isEmployed);
    }
}

