package org.example;

import org.example.CliApp.Menu;
import org.example.CliApp.Option;

public class SecondMenu extends Menu {
    public SecondMenu() {
        super("Title",
                new Option("option1",
                        () -> System.out.println("hi"))
        );
    }
}
