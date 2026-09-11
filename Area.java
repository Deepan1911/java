import java.util.Scanner;

abstract class Shape {
    int a, b;

    Shape(int x, int y) {
        a = x;
        b = y;
    }

    abstract void printArea();
}

class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        int area = a * b;
        System.out.println("Area of Rectangle = " + area);
    }
}

class Triangle extends Shape {

    Triangle(int base, int height) {
        super(base, height);
    }

    void printArea() {
        int area = (a * b) / 2;
        System.out.println("Area of Triangle = " + area);
    }
}

class Circle extends Shape {

    Circle(int radius) {
        super(radius, 0);
    }

    void printArea() {
        double area = 3.14 * a * a;
        System.out.println("Area of Circle = " + area);
    }
}

public class Area {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a shape:");
        System.out.println("1. Rectangle");
        System.out.println("2. Triangle");
        System.out.println("3. Circle");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter length: ");
                int length = sc.nextInt();

                System.out.print("Enter breadth: ");
                int breadth = sc.nextInt();

                Rectangle r = new Rectangle(length, breadth);
                r.printArea();
                break;

            case 2:
                System.out.print("Enter base: ");
                int base = sc.nextInt();

                System.out.print("Enter height: ");
                int height = sc.nextInt();

                Triangle t = new Triangle(base, height);
                t.printArea();
                break;

            case 3:
                System.out.print("Enter radius: ");
                int radius = sc.nextInt();

                Circle c = new Circle(radius);
                c.printArea();
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
} 