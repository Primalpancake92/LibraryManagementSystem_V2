package org.lbs.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;
import org.lbs.Model.User;
import org.lbs.Database.DAL.UserCrud;
import org.lbs.Session.UserSession;

import java.io.IOException;

public class LoginController{
    public Label errorField;
    private User model;
    private Stage stage;

    @FXML private TextField userTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button loginBtn;
    @FXML private Button registerBtn;
    @FXML private Label errorLabel;

    public void userLogin() {
        String email = userTf.getText().trim();
        String password = passwordTf.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            errorField.setText("You have not typed anything.");
            return;
        }

        User user = UserCrud.authenticateUser(email, password);

        if (user == null) {
            errorField.setText("Invalid email or password.");
            return;
        }

        UserSession.setLoggedInUser(user);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/lbs/view/accountView.fxml"));
            Parent accountRoot = loader.load();
            loginBtn.getScene().setRoot(accountRoot);
        } catch (IOException e) {
            e.printStackTrace();
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
