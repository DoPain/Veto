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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class AjoutMaladieController extends ControllerSample implements Initializable {

    @FXML
    private Label animalNameLab;
    @FXML
    private Label error;
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
        beginDateText.setPromptText("aaaa-mm-jj");
        endDateText.setPromptText("aaaa-mm-jj");

        if(Utils.isModifyDisease()){
            validateBtn.setText("Enregistrer les modifications");
            diseaseText.setText(Utils.getCurrentTraitement().getMaladie());
            careText.setText(Utils.getCurrentTraitement().getSoin());
            beginDateText.setText(Utils.getCurrentTraitement().getDateDebut().toString());
            endDateText.setText(Utils.getCurrentTraitement().getDateFin().toString());
        }
    }


    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void validateBtnOnAction(ActionEvent actionEvent) throws IOException {
        if(!diseaseText.getText().equals("") && !careText.getText().equals("") &&
                !beginDateText.getText().equals("") && !endDateText.getText().equals("")) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
            java.util.Date dateD = null;
            java.util.Date dateF = null;
            try {
                dateD = formatter.parse(beginDateText.getText());
                dateF = formatter.parse(endDateText.getText());
            } catch (ParseException e) {
                error.setStyle("-fx-text-fill: red");
                error.setText("Date(s) invalide(s)");
            }
            java.sql.Date sqlDateD = new java.sql.Date(dateD.getTime());
            java.sql.Date sqlDateF = new java.sql.Date(dateF.getTime());

            if (!Utils.isModifyDisease()) {
                TraitementEntity newTraitement = new TraitementEntity();
                newTraitement.setIdAnimal(Utils.getCurrentAnimal().getId());
                newTraitement.setMaladie(diseaseText.getText());
                newTraitement.setSoin(careText.getText());
                newTraitement.setDateDebut(sqlDateD);
                newTraitement.setDateFin(sqlDateF);
                Utils.TRAITEMENT_DAO.saveOrUpdate(newTraitement);
                Utils.createLog("Ajout traitement : Maladie traitée " + diseaseText.getText() +
                        " sur l'animal " + Utils.getCurrentAnimal().getNom() + " appartenant à " +
                        Utils.getCurrentAnimal().getClientByIdClient().getPersonneById().getNom());
            } else {
                traitement.setIdAnimal(Utils.getCurrentAnimal().getId());
                traitement.setMaladie(diseaseText.getText());
                traitement.setSoin(careText.getText());
                traitement.setDateDebut(sqlDateD);
                traitement.setDateFin(sqlDateF);
                Utils.TRAITEMENT_DAO.saveOrUpdate(traitement);
                Utils.createLog("Modification traitement : Maladie traitée " + diseaseText.getText() +
                        " sur l'animal " + Utils.getCurrentAnimal().getNom() + " appartenant à " +
                        Utils.getCurrentAnimal().getClientByIdClient().getPersonneById().getNom());
            }
            Utils.setModifyDisease(false);
            //Rediriger vers le dossier animal
            Stage primaryStage = (Stage) validateBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Veuillez remplir tous les champs");
        }
    }
}
