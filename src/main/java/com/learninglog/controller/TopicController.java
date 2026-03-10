package com.learninglog.controller;

import com.learninglog.model.dao.TopicDao;
import com.learninglog.model.Topic;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TopicController {
    private List<Topic> topics = new ArrayList<>();
    private int topicIdCounter = 1;
    public Topic addTopic(String name) throws SQLException{
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

        // Topic topic = new Topic(topicIdCounter++, name, createdDate,updatedDate);
        // topics.add(topic);
        // return topic;
        TopicDao topicDao = new TopicDao();
        Topic topic = topicDao.insertTopic(name, createdDate, updatedDate);
        return topic;
    }

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(int id) {
        for (Topic t : topics) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}