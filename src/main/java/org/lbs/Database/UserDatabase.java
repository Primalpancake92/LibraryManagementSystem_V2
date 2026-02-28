package org.lbs.Database;

import org.lbs.Model.Book;
import org.lbs.Model.User;

import java.sql.*;

public class UserDatabase {
    protected Connection dbConnection;

    public void getConnection() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                String URL = "jdbc:sqlite:Library.db";
                dbConnection = DriverManager.getConnection(URL);
                System.out.println("Connection to database successfully connected.");
                createUsersTable();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void createUsersTable() {
        String createUsersDatabase = "CREATE TABLE IF NOT EXISTS User ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "password TEXT NOT NULL,"
                + "first_name TEXT NOT NULL,"
                + "last_name TEXT NOT NULL,"
                + "age INTEGER NOT NULL,"
                + "email STRING NOT NULL,"
                + "book_borrowed STRING )";
        try {
            var createStmt = dbConnection.createStatement();
            createStmt.execute(createUsersDatabase);
        } catch (SQLException e) {
            System.out.println(e + " is the exception.");
            System.out.println("There were no database found.");
        }
    }

    private void closeConnection() throws SQLException {
        if (dbConnection != null || !dbConnection.isClosed()) {
            dbConnection.close();
            System.out.println("The database is closed.");
        }
    }

    public User authenticateUser (String enteredEmail, String enteredPassword) {
        /*
        Remember to obfuscate the sensitive information from the end user.
        This ensures security of user account storage.
        */
        String findUser = "SELECT email, password"
                + "FROM User"
                + "WHERE email = ? AND password = ?";

        try (PreparedStatement prepStatement = dbConnection.prepareStatement(findUser)) {
            prepStatement.setString(1, enteredEmail);
            prepStatement.setString(2, enteredPassword);

            ResultSet rs = prepStatement.executeQuery();

            String password = rs.getString("password");
            if (rs.next()) {
                int id = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                Book bookBorrowed = (Book) rs.getObject("book_borrowed");
                return new User(id, password, firstName, lastName, age, email, bookBorrowed);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("The user " + enteredEmail + " was not found.");
        }
        return null;
    }
}
