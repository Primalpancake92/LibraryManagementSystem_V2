package org.lbs.Database.DAL;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

import org.lbs.Model.User;

public class UserCrud {
    private static Path dbPath = Paths.get("Library.db");
    private static String URL = "jdbc:sqlite:" + dbPath.toString();

    public static void registerUser(String firstName, String lastName, String email,
                                    String password, int age) {
        String registerUser = "INSERT INTO User (" +
                "first_name, last_name, email, password, age)" +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL)) {
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
        String findUser = "SELECT user_id, first_name, last_name, age, email, password, residential_address, "
                + "phone_number "
                + "FROM User "
                + "WHERE email = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL);
            var preparedStmt = conn.prepareStatement(findUser)) {
            preparedStmt.setString(1, enteredEmail);
            preparedStmt.setString(2, enteredPassword);

            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String residentialAddress = rs.getString("residential_address");
                String phoneNumber = rs.getString("phone_number");

                User user = new User(id, firstName, lastName, age, email, password,
                        residentialAddress, phoneNumber);
                System.out.println(user + " " + user.firstNameProperty());
                return user;// returns mapped User
            }
        } catch (SQLException e) {
            System.out.println("The user " + enteredEmail + " was not found.");
        }
        return null;
    }
}
