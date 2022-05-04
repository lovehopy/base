package com.example.jpa_hjkim.tcp.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class TcpServerEndpointTest {

    @Test
    void test_send_sensor_status() throws IOException {
//
//        Socket socket = new Socket("localhost", 10091);
//        OutputStream output = socket.getOutputStream();
//
//        String str = "OCSY012021091300000000580000A5492ALP102NZ017  PP11432003     0020.0002225004920001719 ";
//        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//
//        output.write(bytes);
//
//        InputStream input = socket.getInputStream();
//        byte[] data = input.readAllBytes();
//
//        System.out.println(new String(data));
//
//        socket.close();
//
//        Assertions.assertTrue(true);
    }
}
