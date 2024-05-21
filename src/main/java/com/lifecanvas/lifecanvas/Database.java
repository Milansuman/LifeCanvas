package com.lifecanvas.lifecanvas;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private final Connection conn;

    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/lifecanvas", "lifecanvas", "lifecanvas");
    }

    public void commitExperiences(ArrayList<Experience> experiences) throws SQLException{
        String[] generatedCols = {"id"};
        PreparedStatement updateExperience = this.conn.prepareStatement("update `experiences` set `title`=?, `content`=? where `id`=?;");
        PreparedStatement insertExperience = this.conn.prepareStatement("insert into `experiences` (`title`, `content`) values (?,?);", generatedCols);

        for(Experience experience: experiences){
            if(experience.id == -1){
                insertExperience.setString(1, experience.title);
                insertExperience.setString(2, experience.content);
                insertExperience.execute();

                ResultSet insertExperienceResult = insertExperience.getGeneratedKeys();
                insertExperienceResult.first();
                experience.id = insertExperienceResult.getInt("insert_id");
                this.updateEmotions(experience);
            }else{
                updateExperience.setString(1, experience.title);
                updateExperience.setString(2, experience.content);
                updateExperience.setInt(3, experience.id);
                updateExperience.execute();
                this.updateEmotions(experience);
            }
        }
    }

    public void updateEmotions(Experience experience) throws SQLException{
        PreparedStatement deleteEmotions = this.conn.prepareStatement("delete from `emotions` where `experience_id`=?;");
        PreparedStatement insertEmotion = this.conn.prepareStatement("insert into `emotions` (`emotion`, `experience_id`) values (?,?);");

        deleteEmotions.setInt(1, experience.id);
        deleteEmotions.execute();

        for(String emotion: experience.emotions){
            insertEmotion.setString(1, emotion);
            insertEmotion.setInt(2, experience.id);
            insertEmotion.execute();
        }
    }

    public ArrayList<Experience> loadExperiences() throws SQLException{
        Statement statement = conn.createStatement();
        ResultSet experienceResults = statement.executeQuery("select * from `experiences`;");

        ArrayList<Experience> experiences = new ArrayList<>();

        while(experienceResults.next()){
            PreparedStatement emotionsStatement = conn.prepareStatement("select * from `emotions` where `experience_id`=?;");
            emotionsStatement.setInt(1, experienceResults.getInt("experiences.id"));
            emotionsStatement.execute();

            ResultSet emotionResults = emotionsStatement.getResultSet();
            ArrayList<String> emotions = new ArrayList<>();

            while(emotionResults.next()){
                emotions.add(emotionResults.getString("emotions.emotion"));
            }

            Experience experience = new Experience(
                    experienceResults.getInt("experiences.id"),
                    experienceResults.getString("experiences.title"),
                    emotions,
                    experienceResults.getString("experiences.content")
                    );

            experiences.add(experience);
        }

        return experiences;
    }
}
