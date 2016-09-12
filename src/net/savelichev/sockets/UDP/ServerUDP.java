package net.savelichev.sockets.UDP;


import java.io.*;
import java.net.*;
import java.util.Arrays;

/**
 * Server app UDP implementation.
 */
public class ServerUDP implements Runnable {


    /**
     * Waiting for DatagramPacket  from clients. Take the message and print it into the console.
     */
    public void startUp() {

        int port = 1234;

        byte[] data;

        System.out.println("Server: Waiting for message...");

        try {
            DatagramSocket s = new DatagramSocket(port);

            while (true) {

                data = new byte[100];
                DatagramPacket pac = new DatagramPacket(data, data.length);
                s.receive(pac);

                String message = "";
                try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pac.getData())) {

                    int i;
                    while ((i = byteArrayInputStream.read()) != -1 && i > 0) {
                        message += (String.valueOf((char) (i)));
                    }
                }

                if (message.equals("buy")) {
                    System.out.println("Server: disconnected.");
                    s.close();
                    break;
                }

                System.out.println("Server: Got message: " + message);
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
