package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@SuppressWarnings("unchecked")
@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;	
	
	public List<Topic> getAllTopics() {
		List topics = new ArrayList();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {

	return (Topic) topicRepository.findOne(id);

	}

	public void addTopic(Topic tt) {
	 topicRepository.save(tt);

	}

	public void updateTopic(Topic topic2) {
		topicRepository.save(topic2);	
		
	}
}
