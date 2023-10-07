package labs.java.lab_classes;

import java.util.Scanner;

// Rectangle class to represent a rectangle shape
class Rectangle1 {
    private double length;
    private double width;

    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}


public class solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shape Calculator");

        // Create a Rectangle object
        System.out.print("Enter the length of the rectangle: ");
        double rectLength = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double rectWidth = scanner.nextDouble();
        Rectangle1 rectangle = new Rectangle1(rectLength, rectWidth);

        // Calculate and display the properties of the rectangle
        System.out.println("\nRectangle Properties:");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());

        scanner.close();
    }
}

