package org.lbs.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.lbs.Model.User;
import javafx.stage.Stage;
import org.lbs.dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class RegisterController {
    private Stage stage;
    private User user;
    private UserDAO userDAO;

    @FXML private Button backBtn;


    public void backToHome () throws NullPointerException {

        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/org/lbs/view/loginView.fxml"));
            Parent parent = fxml.load();
            backBtn.getScene().setRoot(parent);
            System.out.println("Scene successfully set.");
        } catch (NullPointerException e) {
            System.out.println("The page that you are going to does not exist.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
