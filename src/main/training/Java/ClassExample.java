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

    public Person(){

    }

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

class Manager extends  Person{

    public Manager(String name,int age){
        super(name,age);
    }

    public void displayInfo() {
        System.out.println("Name from child: " + name);
        System.out.println("Age from child: " + age);
    }

    public void displayInfo(String s) {
        System.out.println("This overloaded method with name : " + name);
        System.out.println("Age from child: " + age);
        System.out.println("extra paramater: " + s);
    }




}

class Employee extends  Person{
    public void getSalary(){

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

        Manager m  = new Manager("Namit",30);
        m.displayInfo();
        m.displayInfo("Overloaded");


        Person p1 = new Employee();
        Person p2 = new Manager("hds",34);



    }
}

