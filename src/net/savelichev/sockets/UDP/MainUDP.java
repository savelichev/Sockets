package net.savelichev.sockets.UDP;


public class MainUDP {


    public static void main(String[] args) {


        Thread serverUDP = new Thread(new ServerUDP());
        serverUDP.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ClientUDP clientUDP = new ClientUDP();
        clientUDP.send(args[0]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clientUDP.send("buy");
    }
}
