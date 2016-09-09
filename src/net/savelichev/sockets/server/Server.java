package net.savelichev.sockets.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    /**
     * Waiting for connection from clients. Take the message and sending echo back.
     * @param args
     */
    public static void main(String[] args) {

        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Socket created...");

            Socket socket = serverSocket.accept();

            System.out.println("Got a connection!");


            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String message = null;


                message = dataInputStream.readUTF();
                System.out.println("Got a message: " + message);

                System.out.println("Sending echo...");

                dataOutputStream.writeUTF("echo... " + message);
                dataOutputStream.flush();

                System.out.println("echo sent.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
