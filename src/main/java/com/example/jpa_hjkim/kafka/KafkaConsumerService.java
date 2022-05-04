package com.example.jpa_hjkim.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumerService {

    private SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics="hjkim", groupId = "hjkim-pc")
    public void consume(String msg){
        simpMessagingTemplate.convertAndSend("/publish/message", msg);
        System.out.println("received ::: " +  msg);
    }
}
