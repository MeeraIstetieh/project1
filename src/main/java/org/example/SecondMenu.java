package org.example;

import org.example.CliApp.Menu;
import org.example.CliApp.Option;

import java.util.List;
import java.util.Scanner;

public class SecondMenu extends Menu {
    private List<Book> filteredBooks;
    public SecondMenu() {
        super("Choose filter category");
                addOptions();
    }
    private void addOptions() {
        getOptions().add(new Option("ID", () -> filterBy(1)));
        getOptions().add(new Option("Title", () -> filterBy(2)));
        getOptions().add(new Option("Author", () -> filterBy(3)));
    }
    private void filterBy(int type){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter value:");
        String value=scanner.nextLine();
        this.filteredBooks=BookService.filterBooks(type,value);
    }
    public List<Book> getFilteredBooks() {
        return filteredBooks!=null?filteredBooks:List.of();
    }
}
