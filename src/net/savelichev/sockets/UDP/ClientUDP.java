package net.savelichev.sockets.UDP;

import java.io.*;
import java.net.*;

public class ClientUDP {


    /**
     * ClientUDP app send message from arguments as DatagramPacket to the server and wait for answer.
     *
     * @param args message to send
     */
    public static void main(String[] args) {
        int port = 1234;
        String ip = "127.0.0.1";

        ByteArrayInputStream byteArrayInputStream = null;

        try {


            DatagramSocket s = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName(ip);

            String message;
            if (args[0] != null) {
                message = args[0];
            } else {
                message = "No_arguments";
            }

            byte[] data = message.getBytes();

            byteArrayInputStream = new ByteArrayInputStream(data);

            DatagramPacket pac;

            while (byteArrayInputStream.read(data) != -1) {

                pac = new DatagramPacket(data, data.length, inetAddress, port);

                s.send(pac);

            }

            System.out.println("Message was sent");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
