package org.lbs;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import org.lbs.DAL.DatabaseConn;
import org.lbs.DAL.DatabaseInit;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;


public class LibraryApplication extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Connection conn = DatabaseConn.getConnection();// This creates the database file, if it is not there.
            DatabaseInit.initializeDatabase(conn);
            Parent root = FXMLLoader.load(getClass().getResource("/org/lbs/view/loginView.fxml"));
            primaryStage.setTitle("OpenShelf");
            primaryStage.setScene(new Scene(root, 1366, 768));
            primaryStage.show();
        } catch (NullPointerException e) {
            System.out.println(e + ": File not found");
            System.exit(1);
        }
    }
}