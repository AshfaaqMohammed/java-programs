package com.Networking.HTTP.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static java.net.HttpURLConnection.HTTP_OK;

public class SimpleHttpServer {
    private static long visitorCounter = 0;
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
            server.createContext("/",exchange -> {
                String requestMethod = exchange.getRequestMethod();
                System.out.println("Request Method: " + requestMethod);

                String data = new String(exchange.getRequestBody().readAllBytes());
                Map<String, String> body = parseParameters(data);
                System.out.println("Body data(no parsing): "+data);
                System.out.println("Body Data: "+ body);

                exchange.getRequestHeaders().entrySet().forEach(System.out::println);
                if (requestMethod.equals("POST")){
                    visitorCounter++;
                }

                String firstName = body.get("first");
                String lastName = body.get("last");

                String response = """
                        <html>
                            <body>
                                <h1> Hello world from my http server </h1>
                                <p>Number of visitors who signed up = %d</p>
                                <form method="post">
                                    <label for="first">First Name: </label>
                                    <input type="text" id="first" name="first" value="%s">
                                    <br>
                                    <label for="last">Last Name: </label>
                                    <input type="text" id="last" name="last" value="%s">
                                    <br>
                                    <input type="submit" value="Submit">
                                </form>
                            <body>
                        <html>
                        """.formatted(visitorCounter,firstName==null ? "" : firstName,lastName==null ? "" : lastName);

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                var bytes = response.getBytes();
                exchange.sendResponseHeaders(HTTP_OK, bytes.length);
                exchange.getResponseBody().write(bytes);
                exchange.close();
            });

            server.start();
            System.out.println("Server is listening on port " + server.getAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> parseParameters(String requestBody){
        Map<String, String> parameters = new HashMap<>();
        String[] paris = requestBody.split("&");
        for (String pair:paris){
            String[] keyValue = pair.split("=");
            if(keyValue.length == 2){
                parameters.put(keyValue[0],keyValue[1]);
            }
        }
        return parameters;
    }
}
