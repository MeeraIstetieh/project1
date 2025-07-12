package org.example;

public class DeleteAllBooksAction implements Runnable {
    @Override
    public void run() {
        BookService.books.clear();
        BookService.saveBooks();
        System.out.println("All books deleted.");
    }
}
