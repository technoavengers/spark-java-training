package Java;

// Public class with a public access modifier
public class AccessModifierExample {

    // Public variable with a public access modifier
    public int publicVariable = 10;

    // Private variable with a private access modifier
    private int privateVariable = 20;

    // Default variable with package-private access modifier
    int defaultVariable = 30;

    // Protected variable with protected access modifier
    protected int protectedVariable = 40;

    // Public method with a public access modifier
    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    // Private method with a private access modifier
    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    // Default method with package-private access modifier
    void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Protected method with protected access modifier
    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    public static void main(String[] args) {
        // Create an instance of the AccessModifierExample class
        AccessModifierExample example = new AccessModifierExample();

        // Access variables and methods from the instance
        System.out.println("Accessing variables and methods:");

        System.out.println("Public variable: " + example.publicVariable);
        System.out.println("Private variable: " + example.privateVariable); // Error: Cannot access private variable
        System.out.println("Default variable: " + example.defaultVariable);
        System.out.println("Protected variable: " + example.protectedVariable);

        example.publicMethod();
        example.privateMethod(); // Error: Cannot access private method
        example.defaultMethod();
        example.protectedMethod();
    }
}
