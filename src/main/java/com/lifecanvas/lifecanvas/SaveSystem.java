package com.lifecanvas.lifecanvas;

import java.util.ArrayList;

public class SaveSystem {
    private static ArrayList<Experience> experiences;
    private static Database db;
    private static UpdateEventSource eventSource;
    public static void initialise(UpdateEventSource updateSource){
        eventSource = updateSource;
        try{
            db = new Database();
            experiences = db.loadExperiences();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Experience> getExperiences(){
        return experiences;
    }

    public static void addExperience(String title, String emotions, String content){
        Experience experience = new Experience(-1);
        experience.title = title;
        experience.content = content;
        experience.setEmotions(emotions);
        experiences.add(experience);
        eventSource.triggerUpdate();
    }

    public static void saveExperiences(){
        try{
            db.commitExperiences(experiences);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
