package org.lbs.Controller;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import org.lbs.Model.User;
import org.lbs.Session.UserSession;

public class AccountController {

    @FXML private Label nameLbl;
    @FXML private Label emailLbl;
    @FXML private Label addressLbl;

    @FXML
    public void initialize() {
        User loggedInUser = UserSession.getLoggedInUser();
        System.out.println(loggedInUser);
        System.out.println(loggedInUser.getFirstName());
        nameLbl.setText("Name: " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
        emailLbl.setText("Email: " + loggedInUser.getEmail());
    }
}
