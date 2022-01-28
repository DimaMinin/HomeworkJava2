package Homework6.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionAndSend {

    public ConnectionAndSend(Socket socket) {

        try (Scanner scan = new Scanner(System.in);
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()))
        {

            String message;
            Process process = new Process(scan, outputStream);
            Thread thread = new Thread(process);
            thread.start();

            while (true) {
                message = inputStream.readUTF();
                if (message.equals("end")) {
                    break;
                }
                System.out.println("Получено сообщение: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
