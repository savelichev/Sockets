package net.savelichev.sockets.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {


    /**
     * Client app send message from arguments to the server and wait for answer.
     *
     * @param args message to send
     */
    public static void main(String[] args) {
        int port = 1234;
        String ip = "127.0.0.1";


        try {
            InetAddress inet4Address = InetAddress.getByName(ip);
            Socket socket = new Socket(inet4Address, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


            String message = null;

            if (args != null) {
                message = args[0];
            } else {
                message = "no arguments";
            }


            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            System.out.println("Sent message: " + message);

            String backMessage = dataInputStream.readUTF();
            System.out.println("Got back message: " + backMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
