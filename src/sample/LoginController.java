package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    public Label loginSchermLabel;
    public Label loginLabel;
    public ComboBox loginComboBox;
    public Button loginButton;

    public void initialize() {
        loginComboBox.getItems().clear();
        loginComboBox.getItems().add("Student");
        loginComboBox.getItems().add("Docent");
    }

    public void login(javafx.event.ActionEvent actionEvent) throws Exception {
        String inlogger = (String) loginComboBox.getValue();
        if (inlogger == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Keuze mist!");
            alert.setHeaderText(null);
            alert.setContentText("Maak een keuze!");

            alert.showAndWait();
        }
        if (inlogger.equals("Docent")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("docentRooster.fxml"));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Docenten Rooster");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.show();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }
        if (inlogger.equals("Student")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("studentRooster.fxml"));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Studenten Rooster");
            newStage.setScene(new Scene(root));
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.show();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }
    }
}
