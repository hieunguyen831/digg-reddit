package com.example.diggreddit.service;

import java.util.List;

import com.example.diggreddit.dto.Topic;

public interface TopicService {

    List<Topic> findAllTopics();

    void createTopic(Topic topic);

    void updateTopic(Topic topic);

    Topic findTopicById(String id);

    void deleteTopic(String id);
}
