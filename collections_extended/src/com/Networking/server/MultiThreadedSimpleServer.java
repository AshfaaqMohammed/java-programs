package com.Networking.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedSimpleServer {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        try(ServerSocket serverSocket = new ServerSocket(5000)){ // when we are using try-with resources, SeverSocket will not automatically close connection it just stop accepting the connections.
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("server accepts client connection");
                socket.setSoTimeout(900_000);
                executorService.submit(() -> handleClientRequest(socket));
            }
        }catch (IOException e){
            System.out.println("server exception - " + e.getMessage());
        }
    }

    private static void handleClientRequest(Socket socket){

        try(socket;
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        ){
            while(true){
                String echoString = input.readLine();
                System.out.println("server got request data: " + echoString);
                if (echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server: " + echoString);
            }
        }catch (IOException e){
            System.out.println("client socket shout down here.");
        }

    }
}
