package com.sun.net.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.*;
import java.util.zip.GZIPInputStream;

import static com.sun.net.httpserver.EchoPostHandler.parseQuery;

public class EchoGetHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange he) throws IOException {
        // parse request
        Map<String, Object> parameters = new HashMap<String, Object>();
        URI requestedUri = he.getRequestURI();
        String query = requestedUri.getRawQuery();
        parseQuery(query, parameters);

        // send response
        String response = "";
        for (String key : parameters.keySet())
            response += key + " = " + parameters.get(key) + "\n";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());

        s.close();
    }
}
