package org.lbs;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;


public class LibraryApplication extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
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