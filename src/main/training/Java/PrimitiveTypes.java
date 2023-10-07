package Java;


/**
 * In this program
 * byte, short, int, and long are integer types representing whole numbers with different sizes.
 * float and double are floating-point types representing decimal numbers with different precision.
 * char represents a single Unicode character.
 * boolean represents a true or false value.
 **/


public class PrimitiveTypes {

    public static void main(String[] args) {
        // Primitive data types represent basic values and have predefined sizes.

        // Integer Types
        byte byteVar = 127;     // 8-bit signed integer (from -128 to 127)
        short shortVar = 32767; // 16-bit signed integer
        int intVar = 2147483647; // 32-bit signed integer
        long longVar = 9223372036854775807L; // 64-bit signed integer

        // Floating-Point Types
        float floatVar = 3.14159f; // 32-bit floating-point number
        double doubleVar = 3.14159265359; // 64-bit floating-point number

        // Character Type
        char charVar = 'A'; // 16-bit Unicode character

        // Boolean Type
        boolean booleanVar = true; // Represents true or false

        // Display values
        System.out.println("byteVar: " + byteVar);
        System.out.println("shortVar: " + shortVar);
        System.out.println("intVar: " + intVar);
        System.out.println("longVar: " + longVar);
        System.out.println("floatVar: " + floatVar);
        System.out.println("doubleVar: " + doubleVar);
        System.out.println("charVar: " + charVar);
        System.out.println("booleanVar: " + booleanVar);

    }
}
