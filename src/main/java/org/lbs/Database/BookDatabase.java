package org.lbs.Database;

public class BookDatabase {
    public final static String URL = "jdbc:sqlite:lb.db";

    public static void initialiseBooks() {
        String createBookDatabase = "CREATE TABLE IF NOT EXISTS Books ("
                + "Book_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"
                + "Title TEXT NOT NULL"
                + "Author TEXT NOT NULL";
    }
}
