package pt4p1ae1.veto.GestionAnimaux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjoutMaladieController extends ControllerSample implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button validateBtn;
    @FXML
    private TextField diseaseText;
    @FXML
    private TextField careText;
    @FXML
    private TextField beginDateText;
    @FXML
    private TextField endDateText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();


    }


    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void validateBtnOnAction(ActionEvent actionEvent) {
    }
}
