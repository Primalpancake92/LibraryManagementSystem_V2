package org.lbs;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import org.lbs.dao.UserDatabase;
import org.lbs.database.DatabaseConnection;

import java.sql.Connection;


public class LibraryApplication extends Application{
    public static void main(String[] args) {
        DatabaseConnection.connect();

        Connection db = DatabaseConnection.getConnection();

        if (db != null) {
            UserDatabase userDb = new UserDatabase();
            userDb.createUsersTable();
            launch(args);
        } else {
            System.exit(1);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/lbs/view/loginView.fxml"));
            primaryStage.setTitle("FXML Starter App");
            primaryStage.setScene(new Scene(root, 1366, 768));
            primaryStage.show();
        } catch (NullPointerException e) {
            System.out.println(e + ": File not found");
            System.exit(1);
        }
    }
}