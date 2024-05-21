package com.lifecanvas.lifecanvas;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class LifeCanvas extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("LifeCanvas");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LifeCanvas.fxml"));
        AnchorPane root = loader.load();

        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void stop() throws Exception {
        SaveSystem.saveExperiences();
        super.stop();
    }
}
