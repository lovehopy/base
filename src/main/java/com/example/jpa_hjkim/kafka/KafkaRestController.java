package com.example.jpa_hjkim.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class KafkaRestController {

    KafkaProducerService kafkaProducerService;

    @PostMapping("/sendKafka")
    public ResponseEntity<?> sendKafka(String msg){
        kafkaProducerService.sendMessage(msg);
        return ResponseEntity.ok(msg);
    }

}
