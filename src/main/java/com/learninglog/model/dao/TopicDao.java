package com.learninglog.model.dao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learninglog.model.Topic;
import com.learninglog.util.DbConnection;


public class TopicDao {
    public Topic insertTopic(String name, Timestamp createdDate, Timestamp updatedDate) throws SQLException{
        String query = "INSERT INTO topic (name, createdDate, updatedDate) VALUES (?, ?, ?)";
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setTimestamp(2, createdDate);
        preparedStatement.setTimestamp(3, updatedDate);

        int rows = preparedStatement.executeUpdate();

        if(rows >){
        // Getting latest if from topic table
        ResultSet rs = preparedStatement.getGeneratedKeys();
        while (rs.next()) {
            int id = rs.getInt(1);
            Topic topic = new Topic(id, name, createdDate, updatedDate);
            return topic;
        }
    }
    return null;
    }


        public List<Topic> selectTopics() throws SQLException {
            String query = "SELECT * FROM topic";
            try(
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            ){
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Topic> listOfTopics = new ArrayList<>();
                while(resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Timestamp createdDate = resultSet.getTimestamp(3);
                    Timestamp updatedDate = resultSet.getTimestamp(4);

                    // Create a Topic object and add it to the list
                    Topic topic = new Topic(id, name, createdDate, updatedDate);
                    listOfTopics.add(topic);
                }
                return listOfTopics;
            }
        }
    
}
