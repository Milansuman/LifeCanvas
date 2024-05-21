package com.lifecanvas.lifecanvas;

import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;

public class Tag extends Label{

    public Tag(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tag.fxml"));

        try {
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
