package org.lbs.Model.application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final ObjectProperty<Book> book;

    public User(int id, String firstName, String lastName, int age, String email, Book book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.book = new SimpleObjectProperty<>();
    }

    // getters here
    private int getId() {
        return id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private int getAge() {
        return this.age;
    }

    private String returnEmail() {
        return this.email;
    }

    // property setters and getters here
    public Book getBook() {
        return this.book.get();
    }

    public void setBook(Book borrowedBook) {
        this.book.set(borrowedBook);
    }

    public ObjectProperty<Book> BookProperty() {
        return this.book;
    }
}
