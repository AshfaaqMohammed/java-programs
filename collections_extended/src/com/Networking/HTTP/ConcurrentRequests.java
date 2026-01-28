package com.Networking.HTTP;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ConcurrentRequests {
    public static void main(String[] args) {
         Map<String,Integer> orderMap =
                 Map.of(
                         "apples",500,
                         "oranges",1000,
                         "bananas",750,
                         "carrots",2000,
                         "cantaloupes",100
                 );
         String urlparams = "product=%s&amount=%d";
         String urlBase = "http://localhost:8080";

//         List<URI> sites = new ArrayList<>();
//         orderMap.forEach((k,v)->sites.add(URI.create(
//                 urlBase + "?" + urlparams.formatted(k,v)
//         )));

        HttpClient client = HttpClient.newHttpClient();
//        sendGets(client,sites);
        sendPosts(client,urlBase,urlparams,orderMap);
    }

    private static void sendGets(HttpClient client, List<URI> uris){
        var futures = uris.stream()
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build)
                .map(request -> client.sendAsync(
                        request, HttpResponse.BodyHandlers.ofString()
                ))
                .toList();
        var allFutureRequests = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture<?>[0])
        );

        allFutureRequests.join();

        futures.forEach(f->{
            System.out.println(f.join().body());
        });
    }

    private static void sendPosts(HttpClient client, String baseUri, String params, Map<String, Integer> orderMap){
        List<HttpRequest> uris = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : orderMap.entrySet()){
            String completeParam = params.formatted(pair.getKey(),pair.getValue());
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(completeParam))
                        .uri(URI.create(baseUri))
                        .header("Content-Type","applicaiton/x-www-form-urlencoded")
                        .build();
                uris.add(request);
        }

        var futures = uris.stream()
                .map(request->
                        client.sendAsync(request,HttpResponse.BodyHandlers.ofString()))
                .toList();
        var allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();

        futures.forEach(f->{
            System.out.println(f.join().body());
        });
    }
}
