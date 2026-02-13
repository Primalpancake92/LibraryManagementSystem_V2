package org.lbs.Model.application;

import javafx.beans.property.*;

public class Book {
    private final String title;
    private final String author;
    private final int id;
    private final BooleanProperty borrowed;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.borrowed = new SimpleBooleanProperty(false);
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getId() {
        return this.id;
    }

    public void borrowBook() {
        if (getBorrowed()) {
            throw new IllegalStateException("Book is already borrowed"); // note please throw a custom error window
        } else {
            setBorrowed(true);
        }
    }

    public void returnBook() {
        if (!getBorrowed()) {
            throw new IllegalStateException("This book has already been returned"); // also the same here
        } else {
            setBorrowed(false);
        }
    }

    public boolean getBorrowed() {
        return this.borrowed.get();
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed.set(borrowed);
    }

    public BooleanProperty borrowedProperty() {
        return this.borrowed;
    }

    @Override
    public String toString() {
        String summary = "Book: %s\nId: %d\nAuthor: %s";

        return String.format(summary, this.title, this.id, this.author);
    }

    /*public static void main (String[] args) {
        Book book1 = new Book("Book 1", "Author 1", 1);
        Book book2 = new Book("Book 2", "Author 2", 2);
        Book book3 = new Book("Book 3", "Author 3", 3);

        book1.borrowBook();
        System.out.println(book1);
        System.out.println(book1.getBorrowed());
    }*/
}
