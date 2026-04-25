package org.lbs.Utility;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.lbs.Controller.ModalController;

import java.io.IOException;

public class StageSwitcher {
    public static void switchStage(Button someBtn, String page) throws NullPointerException {
        try {
            FXMLLoader fxml = new FXMLLoader(StageSwitcher.class.getResource(page));
            Parent parent = fxml.load();
            someBtn.getScene().setRoot(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            System.out.println("This is the wrong page.");
        }
    }

    public static void switchToLogin(Stage stage, Button someBtn) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    StageSwitcher.class.getResource("/org/lbs/view/loginView.fxml")
            );

            Parent root = loader.load();

            Stage newStage = (Stage) someBtn.getScene().getWindow();
            double width = stage.getWidth();
            double height = stage.getHeight();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.setWidth(width);
            stage.setHeight(height);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerModal(Stage ownerStage) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    StageSwitcher.class.getResource("/org/lbs/view/successModal.fxml")
            );

            Parent root = loader.load();

            ModalController controller = loader.getController();

            Stage modalStage = new Stage();
            modalStage.setTitle("Success");
            modalStage.setScene(new Scene(root));

            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(ownerStage);

            controller.setParentStage(ownerStage);
            controller.setModalStage(modalStage);

            modalStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
