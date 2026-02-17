package org.lbs.dao;

public class BookDatabase {
    public final static String URL = "jdbc:sqlite:lbdb.db";

    public static void initialiseBooks() {
        String createBookDatabase = "CREATE TABLE IF NOT EXISTS Books ("
                + "Book-ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"
                + "Title TEXT NOT NULL"
                + "Author TEXT NOT NULL";
    }
}
