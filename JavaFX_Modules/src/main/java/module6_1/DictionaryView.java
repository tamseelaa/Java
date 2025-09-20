package module6_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    @Override
    public void start(Stage stage) {
        Dictionary model = new Dictionary();
        DictionaryController controller = new DictionaryController(model);

        TextField inputField = new TextField();
        inputField.setPromptText("Enter a word...");
        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        searchButton.setOnAction(e -> {
            String word = inputField.getText();
            String meaning = controller.searchWord(word);
            resultLabel.setText(meaning);
        });

        FlowPane root = new FlowPane(10, 10, inputField, searchButton, resultLabel);
        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
