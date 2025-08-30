package week2.two.Task3and4;
import java.util.Random;
public class Shape {
    protected String shapecolor;
    private static final String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple", "Orange"};
    private static final Random random = new Random();

    public Shape(String shapecolor) {
        this.shapecolor = colors[random.nextInt(colors.length)];
    }

    public double calculateArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Shape Color"+ shapecolor;
    }
}
