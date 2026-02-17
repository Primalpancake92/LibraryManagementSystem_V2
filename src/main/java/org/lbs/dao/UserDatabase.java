package org.lbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserDatabase {
    private static final String URL= "jdbc:sqlite:lbdb.db";

    public static void initiateUsers() {
        String createUsersDatabase = "CREATE TABLE IF NOT EXISTS User ("
                + "user-id INTEGER PRIMARY KEY AUTOINCREMENT"
                + "password TEXT NOT NULL"
                + "first-name TEXT NOT NULL"
                + "last-name TEXT NOT NULL"
                + "age INTEGER NOT NULL"
                + "email STRING NOT NULL"
                + "book-borrowed STRING NOT NULL";
    }
}
