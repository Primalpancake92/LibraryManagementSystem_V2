package org.lbs.Database.Test;

import org.lbs.Database.DAL.DatabaseConn;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUsers {

    public static void insertUsers() {
        String stmt = "INSERT OR IGNORE INTO User (" +
                "first_name, last_name, age, " +
                "email, password, residential_address, phone_number) VALUES " +
                "('John', 'Wick', 35, 'john.wick@email.com', 'something', '12 George Street, Parramatta NSW 2150, Australia', '0412345678')," +
                "('John', 'Doe', 21, 'john.doe@email.com', 'pass123', '45 King Street, Sydney NSW 2000, Australia', '0423456789')," +
                "('Sarah', 'Lee', 19, 'sarah.lee@email.com', 'secure456', '8 Victoria Road, Chatswood NSW 2067, Australia', '0434567890')," +
                "('Michael', 'Smith', 25, 'michael.smith@email.com', 'mypassword', '27 High Street, Blacktown NSW 2148, Australia', '0445678901')," +
                "('Emma', 'Brown', 30, 'emma.brown@email.com', 'adminpass', '63 Oxford Street, Bondi Junction NSW 2022, Australia', '0456789012')";
        try {
            Connection conn = DatabaseConn.getConnection();
            var valueStmt = conn.createStatement();
            valueStmt.execute(stmt);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
