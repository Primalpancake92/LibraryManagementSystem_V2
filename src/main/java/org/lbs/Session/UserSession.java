package org.lbs.Session;

import org.lbs.Model.User;

public class UserSession {
    private static User loggedInUser;

    public static void setLoggedInUser(User newUser) {
        if (newUser == null) {
            throw new IllegalArgumentException("Cannot set null user as active session");
        }
        loggedInUser = newUser;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void userLogout() {
        loggedInUser = null;
    }
}
