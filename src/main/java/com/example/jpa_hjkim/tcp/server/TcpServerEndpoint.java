package com.example.jpa_hjkim.tcp.server;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class TcpServerEndpoint {
    private final MessageService messageService;

    public TcpServerEndpoint(MessageService messageService) {
        this.messageService = messageService;
    }

    @ServiceActivator(inputChannel = "inboundChannel", async = "true")
    public byte[] process(byte[] message) {
        return messageService.processMessage(message);
    }
}
