package com.learninglog.model.dao;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learninglog.util.DbConnection;
import com.learninglog.model.Entry;

public class EntryDao {
    public Entry insertEntry(int topicId, String content, Timestamp createdDate, Timestamp updatedDate) throws SQLException{
        String query = "INSERT INTO entry (topicId, content, createdDate, updatedDate) VALUES (?, ?, ?, ?)";
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, topicId);
        preparedStatement.setString(2, content);
        preparedStatement.setTimestamp(3, createdDate);
        preparedStatement.setTimestamp(4, updatedDate);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            return null;
        } else {
            return null;
        }
    }
}
