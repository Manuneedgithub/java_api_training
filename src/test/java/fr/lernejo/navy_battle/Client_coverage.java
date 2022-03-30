package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;

public class Client_coverage {
    void client_succes() {
        int a = 1010;
        String b = "http://localhost:1010";

        Assertions.assertDoesNotThrow(() -> Client.Client_start(a,b));
    }
}
