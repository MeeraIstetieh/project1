package org.example;

import org.example.CliApp.Menu;
import org.example.CliApp.Option;

public class FirstMenu extends Menu {
    public FirstMenu() {
        super("Choose From the Options",

                new Option("Set books by filter",
                        BooksQuery::queryBooks
                ),
                new Option("Get books by filter",
                        BooksQuery::queryBooks
                ),


                new Option("Delete books by filter",
                        new SecondMenu()::run
                ),

                new Option("Add books by filter",
                        BooksQuery::queryBooks
                )
        );
    }
}
