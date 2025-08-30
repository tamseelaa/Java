package week2.two.Task3and4;

public class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle with base: " + base + " , height: " + height + " & color: " + shapecolor;
    }
}