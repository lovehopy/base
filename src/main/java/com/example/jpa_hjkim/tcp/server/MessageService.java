package com.example.jpa_hjkim.tcp.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageService {
    private static final byte[] DEFAULT_RESPONSE = new byte[0];

    public byte[] processMessage(byte[] message) {
        log.info("Receive message : {}", message);
        return DEFAULT_RESPONSE;
    }
}
