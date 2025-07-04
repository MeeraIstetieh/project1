package org.example.CliApp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class CliApp {
    @Getter
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Menu menu;

    public void run() {
        menu.run();
    }
}
