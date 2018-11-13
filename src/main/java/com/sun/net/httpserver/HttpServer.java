/*package com.sun.net.httpserver;

import java.net.*;

public class HttpServer {

    int port = 9000;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

    private static HttpServer create(InetSocketAddress inetSocketAddress, int i) {
    }
System.out.println("server started at " + port);
server.createContext("/", new RootHandler());
server.createContext("/echoHeader", new EchoHeaderHandler());
server.createContext("/echoGet", new EchoGetHandler());
server.createContext("/echoPost", new EchoPostHandler());
server.setExecutor(null);
server.start();
}
*/
