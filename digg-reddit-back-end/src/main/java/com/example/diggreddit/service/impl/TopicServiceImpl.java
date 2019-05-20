package com.example.diggreddit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.diggreddit.dto.Topic;
import com.example.diggreddit.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    private static List<Topic> mockData = new ArrayList<>();

    @PostConstruct
    private void init() {
        for (int i = 1; i <= 20; i++) {
            Topic topic = new Topic();
            UUID uuid = UUID.randomUUID();
            topic.setId(uuid.toString());

            topic.setTitle("Title topic " + i);
            topic.setContent("Content topic " + i);
            topic.setNumOfUpVoting(0);
            topic.setNumOfDownVoting(0);

            mockData.add(topic);
        }
    }

    @Override
    public List<Topic> findAllTopics() {
        return mockData;
    }

    @Override
    public void createTopic(Topic topic) {
        UUID uuid = UUID.randomUUID();
        topic.setId(uuid.toString());
        mockData.add(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        for (Topic item : mockData) {
            if (topic.getId().equals(item.getId())) {
                item.setTitle(topic.getTitle());
                item.setNumOfUpVoting(topic.getNumOfUpVoting());
                item.setNumOfDownVoting(topic.getNumOfDownVoting());
                break;
            }
        }
    }

    @Override
    public Topic findTopicById(String id) {
        for (Topic item : mockData) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void deleteTopic(String id) {
        Topic deletedTopic = null;

        for (Topic item : mockData) {
            if (item.getId().equals(id)) {
                deletedTopic = item;
                break;
            }
        }

        if (deletedTopic != null) {
            mockData.remove(deletedTopic);
        }
    }

}
