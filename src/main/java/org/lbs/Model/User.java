package org.lbs.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final int id;
    private String password; // remember to make this into a property
    private final StringProperty firstName; // remember to make this into a property
    private final StringProperty lastName; // remember to make this into a property
    private final int age;
    private final String email;
    private final ObjectProperty<Book> book;

    public User(int id, String password, String firstName, String lastName, int age, String email, Book book) {
        this.id = id;
        this.password = password;
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.age = age;
        this.email = email;
        this.book = new SimpleObjectProperty<>();
    }

    private int getId() {
        return id;
    }

    private String getPassword() {
        return password;
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstNameProperty(String newName) {
        firstName.set(newName);
    }

    public final StringProperty firstNameProperty() {
        return firstName;
    }

    public final String getLastName() {
        return lastName.get();
    }
    private int getAge() {
        return this.age;
    }

    private String returnEmail() {
        return this.email;
    }

    private void setPassword (String password) {
        this.password = password;
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
