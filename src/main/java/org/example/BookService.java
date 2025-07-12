package org.example;



import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class BookService {
    public static final String filename="books.csv";
    public static final List<Book> books=new ArrayList<Book>();
    static {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",", 3);
                if (tokens.length == 3) {
                    books.add(new Book(Integer.parseInt(tokens[0]), tokens[1], tokens[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
    public static void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Book book : books) {
                pw.println(book);
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public static void saveBook(Book book) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(book);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public static List<Book> filterBooks(int type, String value) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book b : books) {
            switch (type) {
                case 1:
                    if (Integer.parseInt(value) == b.getId()) filteredBooks.add(b);
                    break;
                case 2:
                    if (b.getTitle().equalsIgnoreCase(value)) filteredBooks.add(b);
                    break;
                case 3:
                    if (b.getAuthor().equalsIgnoreCase(value)) filteredBooks.add(b);
                    break;
            }
        }
        return filteredBooks;
    }
}
