package org.lbs.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.lbs.Model.application.User;

public class LoginController {
    private User model;
    private Stage stage;
    @FXML private TextField userTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button loginBtn;
    @FXML private Button registerBtn;

    /*
        This method on the click of the button would send off an SQL query
        that queries the lbdb.sql file.

        If it matches then let the user load up the next page.
    */
    @FXML
    public void intialize() {
        loginBtn.setOnAction(actionEvent -> {

        });
    }
}
