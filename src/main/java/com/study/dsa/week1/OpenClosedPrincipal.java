package com.study.dsa.week1;

/**
 * Open/Closed Principle: A class should be OPEN for extension but CLOSED for modification.
 * This means you should add new functionality by creating new classes, not modifying existing ones.
 */

public class OpenClosedPrincipal {
    public static void main(String[] args) {
        System.out.println("========== BAD CODE (Violates Open/Closed Principle) ==========");
        badCodeExample();

        System.out.println("\n========== GOOD CODE (Follows Open/Closed Principle) ==========");
        goodCodeExample();
    }

    // BAD CODE - Violates Open/Closed Principle
    static void badCodeExample() {
        // Problem: AreaCalculator needs modification for each new shape type
        AreaCalculatorBad calculator = new AreaCalculatorBad();

        double circleArea = calculator.calculateArea("Circle", 5);
        double rectangleArea = calculator.calculateArea("Rectangle", 4, 5);
        double triangleArea = calculator.calculateArea("Triangle", 3, 4);

        System.out.println("Circle Area: " + circleArea);
        System.out.println("Rectangle Area: " + rectangleArea);
        System.out.println("Triangle Area: " + triangleArea);
        System.out.println("Problem: Adding new shapes requires modifying AreaCalculatorBad class!");
    }

    // GOOD CODE - Follows Open/Closed Principle
    static void goodCodeExample() {
        // Solution: Create new Shape classes without modifying existing code
        ShapeCalculator calculator = new ShapeCalculator();

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 5);
        Shape triangle = new Triangle(3, 4);

        double circleArea = calculator.calculateArea(circle);
        double rectangleArea = calculator.calculateArea(rectangle);
        double triangleArea = calculator.calculateArea(triangle);

        System.out.println("Circle Area: " + circleArea);
        System.out.println("Rectangle Area: " + rectangleArea);
        System.out.println("Triangle Area: " + triangleArea);
        System.out.println("Benefit: Adding new shapes requires only new Shape class, no modification!");
    }
}

// ============= BAD CODE IMPLEMENTATION =============
class AreaCalculatorBad {
    // BAD: Needs to be modified every time a new shape is added
    public double calculateArea(String shapeType, double... dimensions) {
        if (shapeType.equals("Circle")) {
            return Math.PI * dimensions[0] * dimensions[0];
        } else if (shapeType.equals("Rectangle")) {
            return dimensions[0] * dimensions[1];
        } else if (shapeType.equals("Triangle")) {
            return 0.5 * dimensions[0] * dimensions[1];
        }
        // Adding new shape means modifying this class - VIOLATION!
        return 0;
    }
}

// ============= GOOD CODE IMPLEMENTATION =============
// GOOD: Open for extension (add new Shape classes), Closed for modification
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

class ShapeCalculator {
    // GOOD: No modification needed when new shapes are added
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}



