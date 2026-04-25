package org.lbs.Controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.lbs.Database.DAL.UserCrud;
import org.lbs.Model.User;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import org.lbs.Utility.StageSwitcher;

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
    @FXML private TextField addressTf;
    @FXML private TextField phoneTf;
    @FXML private Text regErrorText;

    public void backBtnNav() throws NullPointerException {
        String resourceVal = "/org/lbs/view/loginView.fxml";
        StageSwitcher.switchStage(backBtn, resourceVal);
    }

    public void registerUser() throws NullPointerException {
        if (firstNameTf.getText().isEmpty() || lastNameTf.getText().isEmpty() || emailTf.getText().isEmpty()
        || passwordTf.getText().isEmpty() || addressTf.getText().isEmpty()) {
            regErrorText.setText("Please ensure that all required fields are filled out.");
            return;
        }
        UserCrud.registerUser(firstNameTf.getText(), lastNameTf.getText(), emailTf.getText(),
                passwordTf.getText(), Integer.parseInt(ageTf.getText()),addressTf.getText(), phoneTf.getText());
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        StageSwitcher.registerModal(stage);
    }
}
