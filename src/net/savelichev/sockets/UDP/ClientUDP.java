package net.savelichev.sockets.UDP;

import java.io.*;
import java.net.*;

/**
 * Client app UDP implementation.
 */
public class ClientUDP {


    /**
     * ClientUDP app send message from arguments as DatagramPacket to the server and wait for answer.
     *
     * @param message message to send
     */
    public void send(String message) {
        int port = 1234;
        String ip = "127.0.0.1";

        ByteArrayInputStream byteArrayInputStream = null;

        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName(ip);

            byte[] data = message.getBytes();

            byteArrayInputStream = new ByteArrayInputStream(data);

            DatagramPacket pac;

            while (byteArrayInputStream.read(data) != -1) {

                pac = new DatagramPacket(data, data.length, inetAddress, port);

                System.out.println("Client: sending message... " + message);
                s.send(pac);
            }

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
