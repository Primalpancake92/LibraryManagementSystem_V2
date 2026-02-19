package org.lbs.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection; // produces one database connection

    public static void connect() {
        try {
            String url = "jdbc:sqlite:lddb.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to database successful");
        } catch (SQLException e) {
            System.out.println(e + " - Database not found.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    // Everything works as intended when the db conection.
    /*
    public static void main(String[] args) {
        connect();
        System.out.println(getConnection() + " Connection");
    }
    */
}
