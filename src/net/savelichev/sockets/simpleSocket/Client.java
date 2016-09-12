package net.savelichev.sockets.simpleSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Client app for connection to the server, sim[le socket implementation.
 */
public class Client {


    /**
     * Client app send message to the server and wait for answer.
     *
     * @param message message to send
     */
    public void send(String message) {

        int port = 1234;
        String ip = "127.0.0.1";


        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            System.out.println("Client: try to connect server...");
            Socket socket = new Socket(inetAddress, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF(message);
            System.out.println("Client: Sending message: " + message);
            dataOutputStream.flush();

            String backMessage = dataInputStream.readUTF();
            System.out.println("Client: Got echo from server: " + backMessage);

            System.out.println("Client: try to disconnect...");
            dataOutputStream.writeUTF("buy");
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
