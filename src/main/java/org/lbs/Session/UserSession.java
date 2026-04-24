package org.lbs.Session;

import org.lbs.Model.User;

public class UserSession {
    private static User loggedInUser;

    public static void setLoggedInUser(User newUser) {
        loggedInUser = newUser;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void userLogout() {
        setLoggedInUser(null);
    }
}
