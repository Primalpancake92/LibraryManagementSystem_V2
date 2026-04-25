package org.lbs.Database.DAL;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInit {
    public static void initializeDatabase(Connection conn) {

        String createUsersTable = "CREATE TABLE IF NOT EXISTS User ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "first_name TEXT NOT NULL,"
                + "last_name TEXT NOT NULL,"
                + "age INTEGER,"
                + "email TEXT UNIQUE,"
                + "password TEXT NOT NULL,"
                + "residential_address TEXT NOT NULL,"
                + "phone_number TEXT NOT NULL)";

        String createBooksTable = "CREATE TABLE IF NOT EXISTS Books ("
                + "Book_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "Title TEXT NOT NULL,"
                + "Author TEXT NOT NULL,"
                + "Genre TEXT NOT NULL )";

        try {
            var createStmt = conn.createStatement();
            createStmt.execute(createUsersTable);
            createStmt.execute(createBooksTable);
            System.out.println("Database was successfully initialized.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
