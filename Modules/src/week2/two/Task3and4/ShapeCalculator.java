package week2.two.Task3and4;

public class ShapeCalculator {
    public static void main(String[] args) {
        System.out.println("Shape Calculator\n");

        Shape[] shapes = {
                new Circle(4.0),
                new Rectangle(2.0, 10.0),
                new Triangle(2.0, 10.0)
        };

        for (Shape s : shapes) {
            System.out.println("Area of " + s + ": " + s.calculateArea());
        }
    }
}