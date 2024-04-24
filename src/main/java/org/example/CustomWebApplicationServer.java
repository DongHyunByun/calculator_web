package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10); //스레드풀을 이용
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.",port); //포트 연결

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client."); // 클라이언트 대기

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!"); // 클라이언트 연결(http파일 실행시 연결됨)

//                new Thread(new ClientRequesthandler(clientSocket)).start(); // 연결이 있을때마다 스레드 객체를 생성하여 메모리상 비효율적이므로 아래와같이 스레드풀을 생성.
                executorService.execute(new ClientRequesthandler(clientSocket)); //미리 스레드를 연결해놓는것


            }
        }
    }
}
