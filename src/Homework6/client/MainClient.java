package Homework6.client;

import Homework6.helper.ConnectionAndSend;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;

    private int port;
    private String host;

    public static void main(String[] args) {
        new MainClient().startChatClient();
    }

    public MainClient() {
        this.port = SERVER_PORT;
        this.host = SERVER_HOST;
    }

    public MainClient(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void startChatClient() {
        try (Socket socket = new Socket(host, port)){

            new ConnectionAndSend(socket);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
