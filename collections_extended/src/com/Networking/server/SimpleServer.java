package com.Networking.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){ // when we are using try-with resources, SeverSocket will not automatically close connection it just stop accepting the connections.

            try(Socket socket = serverSocket.accept();) { // to auto close the socket we are again using try with resources on Socket class. this will close the connection.
                System.out.println("server accepts client connection");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

                while(true){
                    String echoString = input.readLine();
                    System.out.println("server got request data: " + echoString);
                    if (echoString.equals("exit")){
                        break;
                    }
                    output.println("Echo from server: " + echoString);
                }
            }

        }catch (IOException e){
            System.out.println("server exception - " + e.getMessage());
        }
    }
}
