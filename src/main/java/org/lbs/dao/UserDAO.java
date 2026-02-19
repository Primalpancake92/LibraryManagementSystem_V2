package org.lbs.dao;

import org.lbs.Model.User;
import org.lbs.Model.Book;
import org.lbs.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final Connection databaseConnection = DatabaseConnection.getConnection();
    // This class is for user authentication when logging in.
    public User authenticateUser (int enteredUserId, String enteredPassword) {
        /*
        Remember to obfuscate the sensitive information from the end user.
        This ensures security of user account storage.
        */
        String findUser = "SELECT user_id, password"
                        + "FROM User"
                        + "WHERE user_id = ? AND password = ?";

        try (PreparedStatement prepstatement = databaseConnection.prepareStatement(findUser)) {
            prepstatement.setInt(1, enteredUserId);
            prepstatement.setString(2, enteredPassword);

            ResultSet rs = prepstatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("user_id");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                Book bookBorrowed = (Book) rs.getObject("book_borrowed");

                return new User(id, password, firstName, lastName, age, email, bookBorrowed);
            }

        } catch (SQLException e) {
            System.out.println(e + " Query error");
        }
        return null;
    }
}