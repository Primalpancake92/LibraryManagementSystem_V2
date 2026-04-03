package org.lbs.Database;

import java.sql.*;

import org.lbs.Model.User;

public class UserCrud {
    final protected static Database dbInstance = Database.getInstance();

    public static void registerUser(String firstName, String lastName, String email,
                                    String password, int age) {
        String registerUser = "INSERT INTO User (" +
                "first_name, last_name, email, password, age)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db")) {
            var prepStmt = conn.prepareStatement(registerUser);

            prepStmt.setString(1, firstName);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, password);
            prepStmt.setInt(5, age);

            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static User authenticateUser (String enteredEmail, String enteredPassword) {
        /*
        Remember to obfuscate the sensitive information from the end user.
        This ensures security of user account storage.
        */
        System.out.println(enteredEmail);
        System.out.println(enteredPassword);
        String findUser = "SELECT user_id, password, first_name, last_name, age, email, book_borrowed "
                + "FROM User "
                + "WHERE email = ? AND password = ?";

        System.out.println(dbInstance); //connection is returned

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Library.db");
            var preparedStmt = conn.prepareStatement(findUser)) {
            preparedStmt.setString(1, enteredEmail);
            preparedStmt.setString(2, enteredPassword);

            ResultSet rs = preparedStmt.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                return new User(id, password, firstName, lastName, age, email, null); // returns mapped User
            }
        } catch (SQLException e) {
            System.out.println("The user " + enteredEmail + " was not found.");
        }
        return null;
    }
}
