package net.savelichev.sockets.simpleSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {


    /**
     * ClientUDP app send message from arguments to the server and wait for answer.
     *
     * @param args message to send
     */
    public static void main(String[] args) {
        int port = 1234;
        String ip = "127.0.0.1";


        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            Socket socket = new Socket(inetAddress, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


            String message = args[0];


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
