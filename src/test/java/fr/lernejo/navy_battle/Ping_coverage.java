package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Launcher;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ping_coverage {
    @org.junit.jupiter.api.Test
    void test_ping() throws IOException {
        String[] a = {"9876"};
        Launcher.main(a);

        URL url = new URL("http://localhost:9876/ping");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        Assertions.assertEquals(status, 200, "Status different de 200");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        StringBuilder r = new StringBuilder();
        String var;
        while ((var = br.readLine()) != null) {
            r.append(var);
        }
        br.close();
        Assertions.assertEquals(r.toString(), "OK", "le message est invalide");
    }
}
