package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import dao.CurrencyDao;
import controller.CurrencyController;

public class CurrencyView extends Application {
    @Override
    public void start(Stage stage) {
        CurrencyDao dao = new CurrencyDao();
        CurrencyController controller = new CurrencyController(dao);

        Label amountLabel = new Label("Amount:");
        Label fromLabel = new Label("From Currency:");
        Label toLabel = new Label("To Currency:");
        Label resultLabel = new Label("Result:");

        TextField amountField = new TextField();
        TextField resultField = new TextField();
        resultField.setEditable(false);

        ComboBox<String> fromBox = new ComboBox<>();
        ComboBox<String> toBox = new ComboBox<>();

        try {
            fromBox.getItems().addAll(dao.getAllCurrencies().keySet());
            toBox.getItems().addAll(dao.getAllCurrencies().keySet());
            fromBox.setValue("EUR");
            toBox.setValue("USD");
        } catch (Exception e) {
            showError("Database unavailable: " + e.getMessage());
        }

        Button convertButton = new Button("Convert");

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                double result = controller.convert(fromBox.getValue(), toBox.getValue(), amount);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid number.");
            } catch (Exception ex) {
                showError("Error: " + ex.getMessage());
            }
        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(amountLabel, 0, 0); grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);   grid.add(fromBox, 1, 1);
        grid.add(toLabel, 0, 2);     grid.add(toBox, 1, 2);
        grid.add(resultLabel, 0, 3); grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);

        Scene scene = new Scene(grid, 350, 220);
        stage.setTitle("Currency Converter (DB-backed)");
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
