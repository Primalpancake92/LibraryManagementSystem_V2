package org.lbs.Database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private Connection dbConnection;
    private static Database dbInstance;

    private Database() {
        try {
            String URL = "jdbc:sqlite:Library.db";
            this.dbConnection = DriverManager.getConnection(URL);
            System.out.println("Connection to database successfully connected.");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection() {
        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                String URL = "jdbc:sqlite:Library.db";
                dbConnection = DriverManager.getConnection(URL);
                InitDatabase.initializeDatabase(dbConnection);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dbConnection;
    }

    public static synchronized Database getInstance() {
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }
}