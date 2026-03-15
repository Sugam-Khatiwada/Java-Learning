package com.learninglog.controller;

import com.learninglog.model.Topic;
import com.learninglog.model.dao.EntryDao;
import com.learninglog.model.Entry;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class EntryController {
    private List<Entry> entries = new ArrayList<>();
    private int entryIdCounter = 1;

    public Entry addEntry(Topic topic, String content) throws SQLException {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        Timestamp updatedDate = createdDate;
        // Entry entry = new Entry(entryIdCounter++, topic, content, createdDate, updatedDate);
        // entries.add(entry);
        // return entry;
        EntryDao entryDao = new EntryDao();
        Entry entry = entryDao.insertEntry(topic.getId(), content, createdDate, updatedDate);
        return entry;
    }

    public List<Entry> getAllEntries() {
        return entries;
    }

    public List<Entry> getEntriesByTopic(Topic topic) {
        List<Entry> result = new ArrayList<>();
        for (Entry e : entries) {
            if (e.getTopic().getId() == topic.getId()) {
                result.add(e);
            }
        }
        return result;
    }
}