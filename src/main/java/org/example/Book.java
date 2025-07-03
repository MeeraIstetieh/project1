package org.example;

public class Book {
    private String title;
    private String author;
    private int id;
    public Book(int id, String title, String author){
        this.id=id;
        this.title=title;
        this.author=author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return id + "," + title + "," + author;
    }
}
