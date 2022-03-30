package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Handler {
    public static void Ping(HttpExchange exchange) throws IOException {
        String message = "OK";
        exchange.sendResponseHeaders(200, message.length());
        try (OutputStream os = exchange.getResponseBody())
        {
            os.write(message.getBytes());
        }
        exchange.close();
    }
}
