package org.example;

import java.util.List;

public class GetBooksAction implements Runnable {
    @Override
    public void run(){
        SecondMenu filterMenu = new SecondMenu();
        filterMenu.run(); // user chooses filter and enters value

        List<Book> results = filterMenu.getFilteredBooks();
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            results.forEach(System.out::println);
        }
    }

}
