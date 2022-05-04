package com.example.jpa_hjkim.tcp.server;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tcp.server")
@Getter
@Setter
public class TcpServerProperties {
    int port;
}
