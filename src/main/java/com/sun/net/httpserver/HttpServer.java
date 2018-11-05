package com.sun.net.httpserver;
package com.sun.net.httpserver;

public class HttpServer {

    int port = 9000;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
System.out.println("server started at " + port);
server.createContext("/", new RootHandler());
server.createContext("/echoHeader", new EchoHeaderHandler());
server.createContext("/echoGet", new EchoGetHandler());
server.createContext("/echoPost", new EchoPostHandler());
server.setExecutor(null);
server.start();
}
