package module6_3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void start(Stage stage) {
        // Model + Controller
        Pet pet = new Pet(WIDTH / 2.0, HEIGHT / 2.0, "/Image.png"); // image in resources
        PetController controller = new PetController(pet);

        // Canvas
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext graphicContext = canvas.getGraphicsContext2D();

        // Mouse events
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, e -> controller.setTarget(e.getX(), e.getY()));
        canvas.addEventHandler(MouseEvent.MOUSE_EXITED, e -> controller.stopMoving());

        // Animation loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.update();
                draw(graphicContext, controller.getPet());
            }
        };
        timer.start();

        // Scene
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("/module6_3/style.css").toExternalForm());
        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();
    }

    private void draw(GraphicsContext gc, Pet pet) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(pet.getImage(), pet.getX() - 32, pet.getY() - 32, 64, 64); // center image
    }

    public static void main(String[] args) {
        launch();
    }
}
