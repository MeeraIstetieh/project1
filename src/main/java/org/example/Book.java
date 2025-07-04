package org.example;

public class Book implements CSVable{
    private String title;
    private String author;
    private int id;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    private String safeString(String str) {
        if (str == null)
            return "\"\"";

        return "\"" +
                str.replace("\"", "\"\"")
                + "\"";
    }

    @Override
    public String toCsv() {
        return safeString(id + "") +
                "," +
                safeString(title) +
                "," +
                safeString(author);
    }
}
