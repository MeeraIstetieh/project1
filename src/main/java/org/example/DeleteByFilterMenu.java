package org.example;

import java.util.List;
import java.util.Scanner;

public class DeleteByFilterMenu implements Runnable {
    @Override
    public void run() {
        SecondMenu filterMenu = new SecondMenu();
        filterMenu.run();

        List<Book> toDelete = filterMenu.getFilteredBooks();
        if (toDelete.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        System.out.println("Found " + toDelete.size() + " book(s). Proceed with deletion? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            BookService.books.removeAll(toDelete);
            BookService.saveBooks();
            System.out.println("Books deleted.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}
