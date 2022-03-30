package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;

class Launcher_coverage {
    @org.junit.jupiter.api.Test
    void launcherArgsOk() {
        String[] a = {"99"};
        Assertions.assertDoesNotThrow(() -> Launcher.main(a));
    }

    @org.junit.jupiter.api.Test
    void launcherArgsFails() {
        String[] a = {};
        Assertions.assertThrows(
                NullPointerException.class,
                () -> Launcher.main(a), "You need to specify a port in parameter"
        );
    }


    @org.junit.jupiter.api.Test
    void launcherArgsFailsLetter() {
        String[] a = {"JUCK_FAJA"};

        Assertions.assertThrows(
                NumberFormatException.class,
                () -> Launcher.main(a)
        );}
    @org.junit.jupiter.api.Test
    void launcherArgsFailsManyArg() {
        String[] a = {"1010","http://localhost:1010"};

        Assertions.assertDoesNotThrow(() -> Launcher.main(a));
    }
}