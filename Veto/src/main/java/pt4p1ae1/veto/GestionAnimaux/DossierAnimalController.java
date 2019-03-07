package pt4p1ae1.veto.GestionAnimaux;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import pt4p1ae1.veto.ControllerSample;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DossierAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Button backToAnimalsBtn;
    @FXML
    private Label animalNameLabel;
    @FXML
    private VBox resumeAnimalVBox;

    //les boutons du bas
    @FXML
    private Button animalModifyBtn;
    @FXML
    private Button animalDeleteBtn;
    @FXML
    private Button diseaseAddBtn;
    @FXML
    private Button diseaseModifyBtn;
    @FXML
    private Button prescriptionGenerateBtn;
    @FXML
    private Button billGenerateBtn;

    //la liste des soins et ses boutons de navigation
    @FXML
    private TableView careList;
    @FXML
    private TableColumn numCareColumn;
    @FXML
    private TableColumn descriptionCareColumn;
    @FXML
    private Button firstAnmialBtn;
    @FXML
    private Button previousAnimalBtn;
    @FXML
    private Button nextAnimalBtn;
    @FXML
    private Button lastAnimalBtn;
    @FXML
    private Button insertCareBtn;
    @FXML
    private Button editCareBtn;
    @FXML
    private Button deleteCareBtn;
    @FXML
    private Button refreshCareBtn;

    //historique des maladies
    @FXML
    private TableView diseaseHistoryList;
    @FXML
    private TableColumn reasonDiseaseColumn;
    @FXML
    private TableColumn dateDiseaseColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
    }
    //TODO Mettre le nom de l'animal dans animalNameLabel
    //TODO Afficher historique des maladies dans diseaseHistoryList
    //TODO Afficher liste des soins dans careList

    @FXML
    private void onActionBackToAnimalBtn() {
        //TODO Retour vers la liste des animaux
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