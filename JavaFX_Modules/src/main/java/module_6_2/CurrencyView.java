package module_6_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyView extends Application {
    @Override
    public void start(Stage stage) {
        CurrencyController controller = new CurrencyController();

        // Labels
        Label amountLabel = new Label("Amount:");
        Label fromLabel = new Label("From Currency:");
        Label toLabel = new Label("To Currency:");
        Label resultLabel = new Label("Result:");

        // Input + output fields
        TextField amountField = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        // Currency selectors
        ComboBox<String> fromBox = new ComboBox<>();
        fromBox.getItems().addAll(Currency.getAllCurrencies().keySet());
        fromBox.setValue("EUR");

        ComboBox<String> toBox = new ComboBox<>();
        toBox.getItems().addAll(Currency.getAllCurrencies().keySet());
        toBox.setValue("USD");

        // Convert button
        Button convertButton = new Button("Convert");

        // Event handling
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                double result = controller.convert(fromBox.getValue(), toBox.getValue(), amount);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input.");
            } catch (Exception ex) {
                resultField.setText("Error: " + ex.getMessage());
            }
        });

        // Layout (grid, minimal)
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(amountLabel, 0, 0); grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);   grid.add(fromBox, 1, 1);
        grid.add(toLabel, 0, 2);     grid.add(toBox, 1, 2);
        grid.add(resultLabel, 0, 3); grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);

        // Scene
        Scene scene = new Scene(grid, 350, 220);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
