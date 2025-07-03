package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String filename="books.csv";
    static List<Book> books=new ArrayList<>();
    static boolean valid=true;
    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line=br.readLine())!=null){
                String[] tokens=line.split(",",3);
                if(tokens.length==3){
                    books.add(new Book(Integer.parseInt(tokens[0]),tokens[1],tokens[2]));
                }
            }
        }catch(IOException e){
            System.out.println("Error reading file");
        }
        Scanner scanner=new Scanner(System.in);
        boolean running=true;
        while(running){
            System.out.println("1.get books by filter");
            System.out.println("2.add a new book");
            System.out.println("3.delete books by filter");
            System.out.println("4.delete all books");
            System.out.println("5.exit");

            String choice=scanner.nextLine();
            switch(choice) {
                case "1":


                        System.out.println("Enter the category you wish to search by");
                        System.out.println("1.Book ID");
                        System.out.println("2.Book Title");
                        System.out.println("3.Book Author");
                        int type = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter the Value");
                        String value = scanner.nextLine();

                    List<Book> Filtered = filterBooks(type, value);
                    if(Filtered.isEmpty()){
                        System.out.println("No books found");
                    }
                    for (Book book : Filtered) {
                        System.out.println(book);
                    }

                    break;
                case "2":
                    AddBook(scanner);
                    break;
                case "3":


                        System.out.println("Enter the category you wish to delete by");
                        System.out.println("1.Book ID");
                        System.out.println("2.Book Title");
                        System.out.println("3.Book Author");
                       int typeToDelete = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter the Value");
                        String valueToDelete = scanner.nextLine();

                    List<Book> deleted = filterBooks(typeToDelete, valueToDelete);
                    System.out.println("Theres " + deleted.size() + " books to be deleted do you want to continue?(Y/N)");
                    String confirm=scanner.nextLine();
                    if(confirm.equals("Y")){
                       books.removeAll(deleted);
                        try(PrintWriter pw=new PrintWriter(new FileWriter(filename))){
                            for(Book book:books) {
                                pw.println(book);
                            }
                        }catch (IOException e){
                            System.out.println("Error writing file");
                        }
                    }
                    break;
                case "4":
                    DeleteAllBooks();
                    break;
                case "5":
                    running = false;
                    System.out.println("exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice please try again");
            }
        }

    }
    static void AddBook(Scanner scanner){
        System.out.println("Enter id");
        int id=Integer.parseInt(scanner.nextLine());
        if (books.stream().anyMatch(b -> b.getId()==id)) {
            System.out.println("A book with this ID already exists.");
            return;
        }
        System.out.println("Enter title");
        String title=scanner.nextLine();
        System.out.println("Enter author");
        String author=scanner.nextLine();

        Book book=new Book(id,title,author);
        books.add(book);

        try(PrintWriter pw=new PrintWriter(new FileWriter(filename,true))){
            pw.println(book);
        }catch (IOException e){
            System.out.println("Error writing file");
        }
        System.out.println("Book added");
    }
    static void DeleteAllBooks(){
        books.clear();
        try(PrintWriter pw=new PrintWriter(new FileWriter(filename))){
        }catch (IOException e){
            System.out.println("Error writing file");
        }
    }
    static List<Book> filterBooks(int type,String value){
        List<Book> filteredBooks=new ArrayList<>();

        for(Book b:books){
            if (type==1){
                if(Integer.parseInt(value)==b.getId()){
                    filteredBooks.add(b);
                }
                valid=false;

            }
            else if(type==2){
                if(b.getTitle().equalsIgnoreCase(value)){
                    filteredBooks.add(b);
                }
                valid=false;

            }
            else if(type==3){
                if(b.getAuthor().equalsIgnoreCase(value)){
                    filteredBooks.add(b);
                }
                valid=false;

            }
            else {
                System.out.println("Invalid choice please try again");

            }

        }

return filteredBooks;
    }

}