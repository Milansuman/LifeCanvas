package com.lifecanvas.lifecanvas;

import java.util.ArrayList;

public class Experience {
    public int id;
    public String title;
    public ArrayList<String> emotions;
    public String content;

    public Experience(int id){
        this.id = id;
        this.title = "";
        this.emotions = new ArrayList<>();
        this.content = "";
    }

    public Experience(int id, String title, ArrayList<String> emotions, String content){
        this.id = id;
        this.title = title;
        this.content = content;
        this.emotions = emotions;
    }

    public void setEmotions(String emotions){
        String[] rawEmotions = emotions.split(",");
        for(String rawEmotion: rawEmotions) {
            this.emotions.add(rawEmotion.trim());
        }
    }
}
