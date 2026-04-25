package org.lbs.Controller;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.FontSmoothingType;
import org.lbs.Model.User;
import org.lbs.Session.UserSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AccountController {

    @FXML private Label nameLbl;
    @FXML private Label emailLbl;
    @FXML private Label addressLbl;
    @FXML private Label phoneLbl;
    @FXML private Button logoutBtn;

    @FXML
    public void initialize() {
        User loggedInUser = UserSession.getLoggedInUser();
        System.out.println(loggedInUser);
        System.out.println(loggedInUser.getFirstName());
        nameLbl.setText("Name: " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
        emailLbl.setText("Email: " + loggedInUser.getEmail());
        phoneLbl.setText("Phone number: " + loggedInUser.getPhoneNumber());
        addressLbl.setText("Residential address: " + loggedInUser.getResidentialAddress());
    }

    public void logout() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/lbs/view/loginView.fxml"));
            Parent root = loader.load();
            UserSession.userLogout();
            logoutBtn.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println("View cannot be found");
        }
    }
}
