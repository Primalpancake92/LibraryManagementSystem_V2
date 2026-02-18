package org.lbs.Controller;

import org.lbs.dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.lbs.Model.User;

public class LoginController {
    public Label errorField;
    private User model;
    private Stage stage;
    private UserDAO userDAO;

    @FXML private TextField userTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button loginBtn;
    @FXML private Button registerBtn;
    @FXML private Label errorLabel;

    /*
        This method on the click of the button would send off an SQL query
        that queries the lbdb.sql file.

        If it matches then let the user load up the next page.
    */
    @FXML
    public void intialize() {

    }

    @FXML
    public void userLogin() {
        String username = userTf.getText();
        String password = passwordTf.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            int userId = Integer.parseInt(username);
            userReturnLogic(userDAO.authenticateUser(userId, password));
        } else {
            errorField.setText("You have not typed anything.");
        }
    }

    public void userReturnLogic(User userLogged) {
        if (userLogged == null) {
            errorField.setText("User was not found.");
        }
    }
}
