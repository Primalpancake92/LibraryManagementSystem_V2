package org.lbs.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final int userId;// remember to make this into a property
    private final StringProperty firstName; // remember to make this into a property
    private final StringProperty lastName; // remember to make this into a property
    private final int age;
    private final StringProperty email;
    private String password;
    private final StringProperty residentialAddress;
    private final StringProperty phoneNumber;

    public User(int userId, String firstName, String lastName, int age, String email, String password,
                String residentialAddress, String phoneNumber) {
        this.userId = userId;
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = age;
        this.email = new SimpleStringProperty(email);
        this.password = password;
        this.residentialAddress = new SimpleStringProperty(residentialAddress);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    private int getUserId() {
        return userId;
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

    public final StringProperty getLastNameProperty() { return lastName; }

    private int getAge() { return age; }

    public final String getEmail() {
        return email.get();
    }

    public final void setEmailProperty(String newEmail) {
        email.set(newEmail);
    }

    public final StringProperty getEmailProperty() {
        return email;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword (String password) {
        this.password = password;
    }

    public final String getResidentialAddress() { return residentialAddress.get(); }

    public final void setResidentialAddress(String newResidentialAddress) {
        residentialAddress.set(newResidentialAddress);
    }

    public final StringProperty getResidentialAddressProp() { return residentialAddress; }

    public final String getPhoneNumber() { return phoneNumber.get(); }

    public final void setPhoneNumber(String newPhoneNumber) { phoneNumber.set(newPhoneNumber); }

    public final StringProperty getPhoneNumberProperty() { return phoneNumber; }
}
