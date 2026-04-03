package org.lbs.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class InitDatabase {
    public static void initializeDatabase(Connection conn) {

        String createUsersTable = "CREATE TABLE IF NOT EXISTS User ("
                + "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "password TEXT NOT NULL,"
                + "first_name TEXT NOT NULL,"
                + "last_name TEXT NOT NULL,"
                + "age INTEGER,"
                + "email STRING NOT NULL,"
                + "book_borrowed STRING )";

        String createBooksTable = "CREATE TABLE IF NOT EXISTS Books ("
                + "Book_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "Title TEXT NOT NULL,"
                + "Author TEXT NOT NULL)";

        try {
            var createStmt = conn.createStatement();
            createStmt.execute(createUsersTable);
            createStmt.execute(createBooksTable);
            System.out.println("Database was successfully initialized.");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e + " is the exception.");
            System.out.println("There were no database found.");
        }
    }
}
