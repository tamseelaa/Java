package week2.two.Task3and4;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius+ " & color: "+ shapecolor;
    }
}
