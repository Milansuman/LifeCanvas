package com.lifecanvas.lifecanvas;

import javafx.beans.property.StringProperty;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Card extends VBox{
    @FXML
    private Label title;

    @FXML
    private Label description;

    @FXML
    private HBox tags;

    public Card(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public StringProperty titleProperty(){
        return this.title.textProperty();
    }

    public String getTitle(){
        return this.titleProperty().get();
    }

    public void setTitle(String title){
        this.titleProperty().set(title);
    }

    public StringProperty descriptionProperty(){
        return this.description.textProperty();
    }

    public String getDescription(){
        return this.descriptionProperty().get();
    }

    public void setDescription(String description){
        this.descriptionProperty().set(description);
    }

    public void setEmotions(ArrayList<String> emotions){
        for(String emotion: emotions){
            Tag tag = new Tag();
            tag.setText(emotion);
            this.tags.getChildren().add(tag);
        }
    }
}
