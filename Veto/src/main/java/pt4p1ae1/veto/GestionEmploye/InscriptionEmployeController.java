package pt4p1ae1.veto.GestionEmploye;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InscriptionEmployeController extends ControllerSample implements Initializable {

    public Button backToEmp;

    public void retourEmploye(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backToEmp.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheEmployes.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }
}
