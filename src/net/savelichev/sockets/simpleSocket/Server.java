package net.savelichev.sockets.simpleSocket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server app simple socket implementation.
 */
public class Server implements Runnable {


    /**
     * Waiting for connection from clients. Take the message and sending echo back.
     */
    private void startUp() {

        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server: ServerSocket created...");

            while (true){
                Socket socket = serverSocket.accept();

                System.out.println("Server: Got a client!");


                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                DataInputStream dataInputStream = new DataInputStream(inputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                String message = null;

                while (true) {

                    message = dataInputStream.readUTF();
                    if (message.equals("buy")) {
                        socket.close();
                        System.out.println("Server: disconnected.");
                        break;
                    }
                    System.out.println("Server: Got a message: " + message);

                    System.out.println("Server: Sending echo...");

                    dataOutputStream.writeUTF("Server: echo... " + message);
                    dataOutputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        startUp();
    }
}
