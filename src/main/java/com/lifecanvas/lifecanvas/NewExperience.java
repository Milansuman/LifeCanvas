package com.lifecanvas.lifecanvas;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class NewExperience extends Stage implements UpdateEventListener{

    public NewExperience(UpdateEventSource updateSource){
        updateSource.addCustomEventListener(this);
        this.setTitle("New Experience");
        this.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewExperience.fxml"));

        try{
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);

            this.setScene(scene);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpdate(UpdateEvent event){
        this.close();
    }
}
