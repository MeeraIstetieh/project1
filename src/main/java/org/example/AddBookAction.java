package org.example;

import java.util.Scanner;

public class AddBookAction implements Runnable {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        if (BookService.books.stream().anyMatch(b -> b.getId() == id)) {
            System.out.println("Book with this ID already exists.");
            return;
        }

        System.out.println("Enter Title:");
        String title = scanner.nextLine();
        System.out.println("Enter Author:");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        BookService.books.add(book);
        BookService.saveBook(book);
        System.out.println("Book added.");
    }
}
