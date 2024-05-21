package com.lifecanvas.lifecanvas;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.Event;

public class NewExperienceController {
    @FXML
    private TextField titleField;

    @FXML
    private TextField emotionsField;

    @FXML
    private TextArea contentField;

    @FXML
    public void onSave(Event e){
        SaveSystem.addExperience(titleField.getText(), emotionsField.getText(), contentField.getText());
    }

}
