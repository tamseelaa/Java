package module6_3;

import javafx.scene.image.Image;

class Pet {
    private double x, y;  // current position
    private final double speed = 4; // movement speed
    private final Image image;

    public Pet(double x, double y, String imagePath) {
        this.x = x;
        this.y = y;

        // Load image from resources
        this.image = new Image(getClass().getResourceAsStream(imagePath));
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public Image getImage() { return image; }

    public void moveTowards(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > speed) { // still far away
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        } else { // reached
            x = targetX;
            y = targetY;
        }
    }
}
