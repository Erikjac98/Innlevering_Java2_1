package no.kristiania.pgr200.database;

import java.io.IOException;
import java.net.*;

public class Client {

    public static void client(){

        try {

            Socket s = new Socket("127.0.0.1", 3000);

            } catch (Exception e){}

    }

    public static void main(String[] args){
       client();
    }
}
