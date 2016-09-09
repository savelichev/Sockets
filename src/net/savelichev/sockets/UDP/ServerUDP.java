package net.savelichev.sockets.UDP;


import java.io.*;
import java.net.*;
import java.util.Arrays;

public class ServerUDP {


    /**
     * Waiting for DatagramPacket  from clients. Take the message and print it into the console.
     *
     * @param args no args
     */
    public static void main(String[] args) {

        int port = 1234;


        byte[] data = new byte[100];

        System.out.println("Waiting for message...");


        DatagramPacket pac = new DatagramPacket(data, data.length);

        try {

            DatagramSocket s = new DatagramSocket(port);


            while (true) {

                s.receive(pac);

                String message;
                try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pac.getData())) {
                    int i = 0;
                    message = "";
                    while ((i = byteArrayInputStream.read()) != -1 && i > 0) {
                        message += (String.valueOf((char) (i)));
                    }
                }

                System.out.println("Got message: " + message);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
