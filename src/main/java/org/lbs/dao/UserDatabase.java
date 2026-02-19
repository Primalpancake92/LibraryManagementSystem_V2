package org.lbs.dao;

import org.lbs.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDatabase {
    private final String URL= "jdbc:sqlite:lbdb.db";
    private final Connection db = DatabaseConnection.getConnection();

    public void createUsersTable() {
        String createUsersDatabase = "CREATE TABLE IF NOT EXISTS User ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "password TEXT NOT NULL,"
                + "first_name TEXT NOT NULL,"
                + "last_name TEXT NOT NULL,"
                + "age INTEGER NOT NULL,"
                + "email STRING NOT NULL,"
                + "book_borrowed STRING NOT NULL)";
        try {
            var createStmt = db.createStatement();
            createStmt.execute(createUsersDatabase);
        } catch (SQLException e) {
            System.out.println("There were no database found.");
        }
    }

    public void initiateUsers() {


        try {

        } catch (SQLException e) {
            System.out.println("pass");
        }

    }
}
