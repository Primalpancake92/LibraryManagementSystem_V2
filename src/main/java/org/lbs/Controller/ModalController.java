package org.lbs.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.lbs.Utility.StageSwitcher;

public class ModalController {
    private Stage parentStage;
    private Stage modalStage;

    @FXML
    private Button continueBtn;

    public void setParentStage(Stage stage) {
        this.parentStage = stage;
    }

    public void setModalStage(Stage stage) {
        this.modalStage = stage;
    }

    public void backToLogin() {
        modalStage.close();
        StageSwitcher.switchToLogin(parentStage, continueBtn);
    }

}
