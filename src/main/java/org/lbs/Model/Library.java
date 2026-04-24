package org.lbs.Model;


/*
   This is te associative entity that links between the
   book class and the User class.
*/
public class Library {
    private Library instance;
    private User loggedInUser;

    public Library(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Library returnLibrary() {
        if (instance == null) {
            throw new IllegalStateException("There is no library object");
        }
        return instance;
    }

    public User returnLoggedUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggingUser) {
        this.loggedInUser = loggingUser;
    }
}
