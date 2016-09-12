package net.savelichev.sockets.simpleSocket;


public class Main {

    public static void main(String[] args) {


        Thread server = new Thread(new Server());
        server.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Client client = new Client();
        String message = args[0];
        client.send(message);


    }
}
