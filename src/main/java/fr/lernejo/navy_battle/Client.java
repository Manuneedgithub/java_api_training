package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class Client {
    public static void Client_start(int port, String URL) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .build();
        if(URL != null) {
            HttpRequest res = HttpRequest.newBuilder()
                    .uri(URI.create(URL + "/api/game/start"))
                    .setHeader("Accept", "application/json")
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"Salut\"}"))
                    .build();
            client.send(res, HttpResponse.BodyHandlers.ofString());
        }
    }
}