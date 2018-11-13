package no.kristiania.pgr200.database;

import java.net.*;
import java.io.*;

public class Server {

    public static void connectToServer(){
        try {
            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();

            System.out.println("Connected");

        } catch(IOException e){}
    }

    public static void main(String[] args){
        connectToServer();
    }
}
