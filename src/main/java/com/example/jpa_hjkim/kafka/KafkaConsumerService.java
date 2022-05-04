package com.example.jpa_hjkim.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumerService {

    private SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics="hjkim", groupId = "hjkim-pc")
    @MessageMapping("/message")
    public void consume(String msg){
        simpMessagingTemplate.convertAndSend("/publish/message", msg);
        System.out.println("received ::: " +  msg);
    }

    @MessageMapping(value = "/message/enter")
    public void enter() {
        System.out.println("연결성공");
        simpMessagingTemplate.convertAndSend("/publish/message" , "채팅방에 참여하셨습니다.");
    }
}
