package org.lbs.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.lbs.Model.User;
import org.lbs.Database.UserDatabase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Label errorField;
    private User model;
    private Stage stage;
    private final UserDatabase userDb = new UserDatabase();

    @FXML private TextField userTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button loginBtn;
    @FXML private Button registerBtn;
    @FXML private Label errorLabel;

    @FXML
    public void userLogin() {
        String email = String.valueOf(userTf.textProperty().getValue());
        String password = String.valueOf(passwordTf.textProperty().getValue());

        if (!email.isEmpty() && !password.isEmpty()) {
            userReturnLogic(email, password);
        } else {
            errorField.setText("You have not typed anything.");
        }
    }

    public void userReturnLogic(String enteredEmail, String enteredPassword) {
        System.out.println(userDb.authenticateUser(enteredEmail, enteredPassword));
        if (userDb.authenticateUser(enteredEmail, enteredPassword) == null) {
            errorField.setText("User was not found.");
        }
        userDb.authenticateUser(enteredEmail, enteredPassword);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userDb.getConnection();
    }
}
