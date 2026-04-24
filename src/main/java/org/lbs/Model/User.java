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
    private final StringProperty email;

    public User(int id, String password, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.password = password;
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = age;
        this.email = new SimpleStringProperty(email);
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

    public final void setFirstNameProperty(String newFirstName) {
        firstName.set(newFirstName);
    }

    public final StringProperty firstNameProperty() {
        return firstName;
    }

    public final String getLastName() {
        return lastName.get();
    }

    public final void setLastNameProperty(String newLastName) {
        lastName.set(newLastName);
    }

    public final StringProperty getLastNameProperty() {
        return lastName;
    }

    public final String getEmail() {
        return email.get();
    }

    public final void setEmailProperty(String newEmail) {
        email.set(newEmail);
    }

    public final StringProperty getEmailProperty() {
        return email;
    }

    private int getAge() {
        return this.age;
    }

    private void setPassword (String password) {
        this.password = password;
    }
}
