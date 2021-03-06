package com.Minin.server.chat;


import com.Minin.clientserver.Command;
import com.Minin.clientserver.CommandType;
import com.Minin.clientserver.commands.AuthCommandData;
import com.Minin.clientserver.commands.PrivateMessageCommandData;
import com.Minin.clientserver.commands.PublicMessageCommandData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private final MyServer server;
    private final Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private String userName;
    private static final Logger LOGGER = LogManager.getLogger(ClientHandler.class);

    public ClientHandler(MyServer server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        inputStream = new ObjectInputStream(clientSocket.getInputStream());
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        server.getExecutorService().execute(() -> {
            try {
                authenticate();
                readMessages();
            } catch (IOException e) {
                LOGGER.error("Failed to process message from client");
                e.printStackTrace();
            } finally {
                try {
                    closeConnection();
                } catch (IOException e) {
                    LOGGER.error("Failed to close connection");
                }
            }
        });

    }

    private void authenticate() throws IOException {
        while (true) {
            Command command = readCommand();
            if (command == null) {
                continue;
            }

            if (command.getType() == CommandType.AUTH) {
                AuthCommandData data = (AuthCommandData) command.getData();
                String login = data.getLogin();
                String password = data.getPassword();
                String userName = server.getAuthService().getUserNameByLoginAndPassword(login, password);
                if (userName == null) {
                    sendCommand(Command.errorCommand("???????????????????????? ?????????? ?? ????????????"));
                } else if (server.isUsernameBusy(userName)) {
                    sendCommand(Command.errorCommand("?????????? ???????????????????????? ?????? ????????????????????!"));
                } else {
                    this.userName = userName;
                    sendCommand(Command.authOkCommand(userName));
                    server.subscribe(this);
                    return;
                }
            }
        }
    }

    private Command readCommand() throws IOException {
        Command command = null;
        try {
            command = (Command) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            LOGGER.error("Failed to read Command class");
        }

        return command;
    }

    private void closeConnection() throws IOException {
        server.unsubscribe(this);
        clientSocket.close();
    }

    private void readMessages() throws IOException {
        while (true) {
            Command command = readCommand();
            if (command == null) {
                continue;
            }

            switch (command.getType()) {
                case END:
                    return;
                case PRIVATE_MESSAGE: {
                    PrivateMessageCommandData data = (PrivateMessageCommandData) command.getData();
                    String recipient = data.getReceiver();
                    String privateMessage = data.getMessage();
                    server.sendPrivateMessage(this, recipient, privateMessage);
                    break;
                }
                case PUBLIC_MESSAGE: {
                    PublicMessageCommandData data = (PublicMessageCommandData) command.getData();
                    processMessage(data.getMessage());
                }
            }
        }
    }

    private void processMessage(String message) throws IOException {
        this.server.broadcastMessage(message, this);
    }

    public void sendCommand(Command command) throws IOException {
        outputStream.writeObject(command);
    }

    public String getUserName() {
        return userName;
    }
}