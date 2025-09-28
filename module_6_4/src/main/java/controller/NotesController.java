package controller;

import model.Notebook;
import model.Notes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NotesController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Notes> noteList;

    private Notebook notebook;

    @FXML
    public void initialize() {
        notebook = new Notebook();
    }

    @FXML
    private void handleAddNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (title.isEmpty() || content.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Both title and content are required!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        Notes note = new Notes(title, content);
        notebook.addNote(note);

        // manually update ListView
        noteList.getItems().add(note);

        // Clear input fields
        titleField.clear();
        contentArea.clear();
    }

    @FXML
    private void handleDelete() {
        Notes selected = noteList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notebook.getNotes().remove(selected); // remove from model
            noteList.getItems().remove(selected); // remove from view
        }
    }
}