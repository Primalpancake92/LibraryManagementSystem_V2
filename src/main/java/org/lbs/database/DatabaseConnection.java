package org.lbs.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null; // produces one database connection

    public static Connection connect() {
        try {
            String url = "jdbc:sqlite:lddb.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to database successful");
        } catch (SQLException e) {
            System.out.println(e + " - Database not found.");
        }

        return connection; // this returns the database connection
    }
}
