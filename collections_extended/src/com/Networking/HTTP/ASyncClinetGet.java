package com.Networking.HTTP;


/*
Future vs CompletableFuture

    - A Future is an interface, which the CompletableFuture class implements
    - The CompletableFuture specifically extends Future's capabilities to support asynchronous processing.
    - CompletableFuture is a Future that may be explicitly completed by setting its value and status.
    - and may be used as a completionStage, supporting dependent functions and actions that trigger upon completion.
    Think of completableFuture as:
        A container for a value that doesn’t exist yet
        Like a courier receipt:
        You don’t have the package
        But you’ll be notified when it arrives

Callback -
    - CallBack is a general programming concept, which describes passing function as an argument to another funciton
    - This gets called later, in the future, when a specific event occurs.
    - Same as Lambda Expressions dont get executed, if they are used as method arguments, until the method is invoked.
    - Similarly, callbacks dont get executed until certain stage, or triggering event occurs

Selector vs CompletableFuture
    - The selector is more low-level and is specifically designed for non-blocking i/o operations.
    - CompletableFuture, with its support for callback functions, is higher-level and not really
        specific to a single use case
        - its a general purpose class, designed for managing asynchronous computations.
thenAccept vs thenApply
    - thenAccept will not return any value so chaining is not possible
    - thenApply will return an value that helpfull for next method in chaining, so chaining is possible.
difference between send and asyncsend -
if we use -
        HttpResponse<Stream<String>> response =
        client.send(request, HttpResponse.BodyHandlers.ofLines());
    The main thread blocks
    Nothing else runs
    Your “10 jobs” never execute until HTTP finishes(in asynchandlerclientget code)

but in asyncsend -
        sendAsync() returns immediately.
        The response is handled later, on another thread.
            CompletableFuture<HttpResponse<Stream<String>>> responseFuture =
            client.sendAsync(request, HttpResponse.BodyHandlers.ofLines());
        HTTP request is sent on a background thread
        sendAsync() returns immediately
        responseFuture is just a promise
        “I’ll give you a response later”
        📌 No blocking here.

 */

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.net.HttpURLConnection.HTTP_OK;

public class ASyncClinetGet {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080");

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(url.toURI())
                    .header("User-Agent","Chrome")
                    .header("Accept","application/json, text/html")
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<Stream<String>> response;
            CompletableFuture<HttpResponse<Stream<String>>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofLines()); //send method on HTTP client is Synchronous and it blocks there.

            while(!responseFuture.isDone()){
                System.out.println("waiting...");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println();
            try {
                 response = responseFuture.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            handleResponse(response);
        }catch (IOException io){
            io.getMessage();
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleResponse(HttpResponse<Stream<String>> response){
        if (response.statusCode() == HTTP_OK){
            response.body()
                    .filter(s->s.contains("<h1>"))
                    .map(s->s.replaceAll("<[^>]*>","").strip())
                    .forEach(System.out::println);
        }else {
            System.out.println("Error reading web page " + response.uri());
        }
    }
}
