package com.lifecanvas.lifecanvas;

import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LifeCanvasController implements UpdateEventListener {
    @FXML
    private GridPane postGrid;

    @FXML
    private TextField search;

    private UpdateEventSource eventSource;

    public LifeCanvasController(){
        this.eventSource = new UpdateEventSource();
        this.eventSource.addCustomEventListener(this);
        SaveSystem.initialise(this.eventSource);
    }

    @FXML
    public void initialize(){
        int i = 0, j = 0;
        for(Experience experience: SaveSystem.getExperiences()){
            Card card = new Card();
            card.setTitle(experience.title);
            card.setDescription(experience.content);
            card.setEmotions(experience.emotions);
            postGrid.add(card, j%3, i);

            j += 1;
            i = j/3;
        }
    }

    @FXML
    public void onNewExperienceClick(Event e){
        NewExperience newExperienceStage = new NewExperience(this.eventSource);
        newExperienceStage.show();
    }

    @FXML
    public void onSearchChanged(Event e){
        this.eventSource.triggerUpdate();
    }

    @Override
    public void onUpdate(UpdateEvent event) {
        int i = 0, j = 0;

        postGrid.getChildren().clear();

        for(Experience experience: SaveSystem.getExperiences()){
            if(!experience.title.contains(search.textProperty().get()) && !experience.content.contains(search.textProperty().get())) continue;
            Card card = new Card();
            card.setTitle(experience.title);
            card.setDescription(experience.content);
            card.setEmotions(experience.emotions);
            postGrid.add(card, j%3, i);

            j += 1;
            i = j/3;
        }
    }
}
