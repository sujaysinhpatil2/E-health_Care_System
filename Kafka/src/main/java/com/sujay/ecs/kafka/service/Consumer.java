package com.sujay.ecs.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "ecs_Topic", groupId = "ecs_group")
    public void listenToTopic(String receivedMsg) {
        System.out.println("The message received is " + receivedMsg);
    }
    
}
