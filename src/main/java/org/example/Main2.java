package org.example;

import org.example.CliApp.CliApp;

public class Main2 {
    public static void main(String[] args) {
        new CliApp(new FirstMenu())
                .run();
    }
}
