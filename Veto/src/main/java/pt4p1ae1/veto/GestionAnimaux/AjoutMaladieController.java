package pt4p1ae1.veto.GestionAnimaux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.TraitementEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AjoutMaladieController extends ControllerSample implements Initializable {

    @FXML
    private Label animalNameLab;
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

    private TraitementEntity traitement;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        traitement = Utils.getCurrentTraitement();

        animalNameLab.setText(Utils.getCurrentAnimal().getNom());
    }


    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void validateBtnOnAction(ActionEvent actionEvent) throws IOException {
        if(!Utils.isModifyDisease()) {
            TraitementEntity newTraitement = new TraitementEntity();
            newTraitement.setMaladie(diseaseText.getText());
            newTraitement.setSoin(careText.getText());
            newTraitement.setDateDebut((Date.valueOf(beginDateText.getText())));
            newTraitement.setDateFin(Date.valueOf(endDateText.getText()));
            Utils.TRAITEMENT_DAO.saveOrUpdate(newTraitement);
        } else {
            traitement.setMaladie(diseaseText.getText());
            traitement.setSoin(careText.getText());
            traitement.setDateDebut((Date.valueOf(beginDateText.getText())));
            traitement.setDateFin(Date.valueOf(endDateText.getText()));
            Utils.TRAITEMENT_DAO.saveOrUpdate(traitement);
        }

        Utils.setModifyDisease(false);
        //Rediriger vers le dossier animal
        Stage primaryStage = (Stage) validateBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }
}
