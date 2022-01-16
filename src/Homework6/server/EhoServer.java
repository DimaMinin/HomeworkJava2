package Homework6.server;

import Homework6.helper.ConnectionAndSend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class EhoServer {

    private static final int PORT = 8189;

    private int port;

    public static void main(String[] args) {
        new EhoServer().startChatServer();
    }

    public EhoServer(int port) {
        this.port = port;
    }

    public EhoServer() {
        this.port = PORT;
    }

    public void startChatServer () {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер начал работу");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            new ConnectionAndSend(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
