package week2.two.Task3and4;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle with width: " + width + " , height: " + height+" & color: " + shapecolor;
    }
}