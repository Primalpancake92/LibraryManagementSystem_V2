package org.lbs.dao;

import org.lbs.Model.User;
import org.lbs.database.DatabaseConnection;
import java.sql.Connection;

public class UserDAO {
    private final Connection databaseConnection = DatabaseConnection.connect();
    // This class is for user authentication when logging in.
    public User authenticateUser (String userId, String password) {
        /*
        Remember to obfuscate the sensitive information from the end user.
        This ensures security of user account storage.
        */


        String findUser = "SELECT";
    }
}