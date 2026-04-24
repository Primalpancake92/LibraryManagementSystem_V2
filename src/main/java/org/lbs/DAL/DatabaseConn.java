package org.lbs.DAL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    private static Connection connection = null;

    private DatabaseConn() {};

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Path path = Paths.get("Library.db");
                String URL = "jdbc:sqlite:" + path.toString();
                connection = DriverManager.getConnection(URL);

                System.out.println("Database successfully connected");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return connection;
    }
}