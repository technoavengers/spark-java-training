package Java;

/**In this program:
 * We define a class named Person to represent a person with two instance variables: name and age.
 * The Person class has a constructor method that initializes the name and age instance variables when a Person object is created.
 * The displayInfo method is defined to display information about the person (their name and age).
 * In the main method, we create two instances of the Person class (person1 and person2) with different values.
 * We access the instance variables and call the displayInfo method for each Person object.
**/


// Define a class named "Person"
class Person {
    // Instance variables (attributes)
    String name;
    int age;

    // Constructor method
    public Person(String name, int age) {
        // Initialize the instance variables with the provided values
        this.name = name;
        this.age = age;
    }

    // Method to display information about the person
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class ClassExample {
    public static void main(String[] args) {
        // Create an instance of the Person class
        Person person1 = new Person("Alice", 30);

        // Access instance variables and methods
        System.out.println("Person 1:");
        person1.displayInfo();

        // Create another instance of the Person class
        Person person2 = new Person("Bob", 25);

        // Access instance variables and methods for the second person
        System.out.println("\nPerson 2:");
        person2.displayInfo();
    }
}

