package org.lbs.Database.Test;

import org.lbs.Database.DAL.DatabaseConn;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUsers {

    public static void insertUsers() {
        String stmt = "INSERT OR IGNORE INTO User (" +
                "password, first_name, last_name, age, " +
                "email) VALUES ('something','John', 'Wick', 35, 'john.wick@email.com')," +
                "('pass123', 'John', 'Doe', 21, 'john.doe@email.com')," +
                "('secure456', 'Sarah', 'Lee', 19, 'sarah.lee@email.com')," +
                "('mypassword', 'Michael', 'Smith', 25, 'michael.smith@email.com')," +
                "('adminpass', 'Emma', 'Brown', 30, 'emma.brown@email.com')";
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
