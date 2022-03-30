package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import fr.lernejo.navy_battle.Server_infos;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.Executors;

public class Launcher {
    private final Server_infos localServer;

    public Launcher(int port) {
        localServer = new Server_infos(
                UUID.randomUUID().toString(),
                "http://localhost:" + port,
                "Server is up"
        );
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new NullPointerException("You need to specify a port in parameter");
            }

            int port = Integer.parseInt(args[0]);
            new Launcher(port).Server_start(port, args.length > 1 ? args[1] : null);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Server_start(int port, String url) throws IOException, InterruptedException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.createContext("/ping", Launcher::Ping);
        server.start();
        Client client = new Client();
        client.Client_start(port, url);
    }

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
