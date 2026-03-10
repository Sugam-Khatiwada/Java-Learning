package com.learninglog.model.dao;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        if (rows > 0) {
            return null;
        } else {
            return null;
        }
    }
}
