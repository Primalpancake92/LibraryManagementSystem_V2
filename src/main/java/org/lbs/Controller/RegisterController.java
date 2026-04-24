package org.lbs.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.lbs.Database.DAL.UserCrud;
import org.lbs.Model.User;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class RegisterController {
    private Stage stage;
    private User user;

    @FXML private Button backBtn;
    @FXML private Button registerBtn;
    @FXML private TextField ageTf;
    @FXML private TextField firstNameTf;
    @FXML private TextField lastNameTf;
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordTf;

    public void backHome(Button someBtn) throws NullPointerException {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/org/lbs/view/loginView.fxml"));
            Parent parent = fxml.load();
            someBtn.getScene().setRoot(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            System.out.println("wrong place");
        }
    }

    public void backBtnNav() throws NullPointerException {
        backHome(backBtn);
    }

    public void registerUser() throws NullPointerException {
        if (firstNameTf.getText().isEmpty() || lastNameTf.getText().isEmpty()
            || emailTf.getText().isEmpty() || passwordTf.getText().isEmpty()) {

            System.out.println("One of the essential fields are empty.");
        } else if (!ageTf.getText().isEmpty()) {
            UserCrud.registerUser(firstNameTf.getText(), lastNameTf.getText(),
                    emailTf.getText(), passwordTf.getText(), Integer.parseInt(ageTf.getText()));
        } else {
            UserCrud.registerUser(firstNameTf.getText(), lastNameTf.getText(),
                    emailTf.getText(), passwordTf.getText(), 0);
            backHome(registerBtn);
        }

        firstNameTf.clear();
        lastNameTf.clear();
        emailTf.clear();
        passwordTf.clear();

        if (!ageTf.getText().trim().isEmpty()) {
            ageTf.clear();
        }
    }
}
