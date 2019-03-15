package pt4p1ae1.veto.GestionAnimaux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.Utils;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

public class DossierAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Button backToAnimals;
    @FXML
    private Label animalNameLabel;
    @FXML
    private Label resumeAnimalLabel;

    //les boutons du bas
    @FXML
    private Button animalModifyBtn;
    @FXML
    private Button animalDeleteBtn;
    @FXML
    private Button prescriptionGenerateBtn;
    @FXML
    private Button billGenerateBtn;

    //liste des maladies
    @FXML
    private TableView diseaseHistory;
    @FXML
    private TableColumn numCol;
    @FXML
    private TableColumn diseaseCol;
    @FXML
    private TableColumn careCol;
    @FXML
    private TableColumn startDateCol;
    @FXML
    private TableColumn endDateCol;
    @FXML
    private Button insertDiseaseBtn;
    @FXML
    private Button editDiseaseBtn;
    @FXML
    private Button deleteDiseaseBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        //Mettre le nom de l'animal dans animalNameLabel
        animalNameLabel.setText(Utils.currentAnimal.getNom());

        //Afficher résumé de l'animal dans resumeAnimalLabel
        resumeAnimalLabel.setText(
                "Propriétaire : " + Utils.personneDao.findById(Utils.clientDao.findById(Utils.currentAnimal.getIdClient()).getId()).getNom()
                + "Nom : " + Utils.currentAnimal.getNom()
                + "Espèce : " + Utils.especeDao.findById(Utils.currentAnimal.getIdRace()).getNom()
                + "Race : " + Utils.raceDao.findById(Utils.currentAnimal.getIdRace()).getNom()
                + "Sexe : " + Utils.currentAnimal.getSexe()
                + "Date de naissance : " + Utils.currentAnimal.getDateNaissance().toString()
                + "Poids : " + Utils.currentAnimal.getPoids().toString()
                + "Autres informations : " + Utils.currentAnimal.getAutreInformations()
        );


        //TODO Afficher historique des maladies dans diseaseHistoryList
        List<TraitementEntity> traitementList = Utils.traitementDao.findAll();
        for (TraitementEntity traitement : traitementList) {
            if(traitement.getIdAnimal() == Utils.currentAnimal.getId()) {
                //ajouter dans diseaseHistory
            }
        }
    }

    @FXML
    private void onActionBackToAnimalBtn() throws IOException {
        //TODO Retour vers la liste des animaux
        Stage primaryStage = (Stage) backToAnimals.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    //boutons du bas

    @FXML
    private void onActionAnimalModifyBtn() {
        //TODO Afficher fenêtre de modification d'un animal
    }

    @FXML
    private void onActionAnimalDeleteBtn() {
        //TODO Supprimer l'animal (afficher fenêtre de confirmation)

    }

    @FXML
    private void onActionDiseaseAddBtn() {
        //TODO Afficher fenêtre d'ajout d'une maladie
    }

    @FXML
    private void onActionDiseaseModifyBtn() {
        //TODO Afficher fenêtre de modification d'une maladie
    }

    @FXML
    private void onActionPrescriptionGenerateBtn() {
        //TODO Générer l'ordonnance
    }

    @FXML
    private void onActionBillGenerateBtn() {
        //TODO Générer la facture
    }

    //boutons de navigation de la liste de soins

    @FXML
    private void onActionFirstAnimalBtn() {
        //TODO Afficher le premier animal de la liste
    }

    @FXML
    private void onActionPreviousAnimalBtn() {
        //TODO Afficher l'animal précédent
    }

    @FXML
    private void onActionNextAnimalBtn() {
        //TODO Afficher l'animal suivant de la liste
    }

    @FXML
    private void onActionLastAnimalBtn() {
        //TODO Afficher le dernier animal de la liste
    }

    @FXML
    private void onActionInsertCareBtn() {
        //TODO Afficher la fenêtre d'insertion d'un soin
    }

    @FXML
    private void onActionEditCareBtn() {
        //TODO Afficher la fenêtre d'édition d'un soin (du soin sélectionné ?)
    }

    @FXML
    private void onActionDeleteCareBtn() {
        //TODO Afficher la fenêtre de suppression d'un soin (du soin sélectionné ?)
    }

    @FXML
    private void onActionRefreshCareBtn() {
        //TODO Rafraîchir les soins
    }

    public void onActionBackToAnimalsBtn(ActionEvent actionEvent) {
    }

    public void onActionfirstAnimalBtn(ActionEvent actionEvent) {
    }

    public void onActionRefreshDiseaseBtn(ActionEvent actionEvent) {
    }
}
