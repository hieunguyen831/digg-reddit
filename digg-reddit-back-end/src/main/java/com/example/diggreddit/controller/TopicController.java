package com.example.diggreddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diggreddit.dto.Topic;
import com.example.diggreddit.service.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable String id) {
        return topicService.findTopicById(id);
    }

    @PutMapping
    public void createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
    }

    @PostMapping
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
