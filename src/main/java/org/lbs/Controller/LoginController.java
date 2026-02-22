package org.lbs.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.lbs.dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.lbs.Model.User;

import java.io.IOException;

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
    public void userLogin() {
        String email = userTf.getText();
        String password = passwordTf.getText();

        if (!email.isEmpty() && !password.isEmpty()) {
            userReturnLogic(userDAO.authenticateUser(email, password));
        } else {
            errorField.setText("You have not typed anything.");
        }
    }

    public void userReturnLogic(User userLogged) {
        if (userLogged == null) {
            errorField.setText("User was not found.");
        }
    }

    public void registerView () throws NullPointerException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/lbs/view/registerView.fxml"));
            Parent registerRoot = loader.load();
            registerBtn.getScene().setRoot(registerRoot);
        } catch (NullPointerException e) {
            System.out.println("The file being loaded 'registerView' does not exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
