package pt4p1ae1.veto.GestionAnimaux;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.Utils;

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
    private TableView <TraitementEntityObservable> diseaseHistory;
    @FXML
    private TableColumn<TraitementEntityObservable, String> numCol;
    @FXML
    private TableColumn<TraitementEntityObservable, String> diseaseCol;
    @FXML
    private TableColumn<TraitementEntityObservable, String> careCol;
    @FXML
    private TableColumn<TraitementEntityObservable, String> startDateCol;
    @FXML
    private TableColumn<TraitementEntityObservable, String> endDateCol;
    @FXML
    private Button insertDiseaseBtn;
    @FXML
    private Button editDiseaseBtn;
    @FXML
    private Button deleteDiseaseBtn;

    @FXML
    private AnimalEntity animal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        animal = Utils.getCurrentAnimal();
        AnimalEntityObservable animalObservable = new AnimalEntityObservable(animal);

        //Mettre le nom de l'animal dans animalNameLabel
        animalNameLabel.setText(animal.getNom());

        //Afficher résumé de l'animal dans resumeAnimalLabel
        resumeAnimalLabel.setText(
                "Propriétaire : " + animalObservable.getProprietaire()
                        + "Nom : " + animalObservable.getNom()
                        + "Espèce : " + animalObservable.getEspece()
                        + "Race : " + animalObservable.getRace()
                        + "Sexe : " + animalObservable.getSexe()
                        + "Date de naissance : " + animalObservable.getDateDeNaissance()
                        + "Poids : " + animalObservable.getPoids()
                        + "Autres informations : " + animalObservable.getAutresInformations()
        );


        //Afficher historique des maladies dans diseaseHistoryList
        numCol.setCellValueFactory(new PropertyValueFactory<>("N°"));
        diseaseCol.setCellValueFactory(new PropertyValueFactory<>("Maladie"));
        careCol.setCellValueFactory(new PropertyValueFactory<>("Soin"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("Date de début"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("Date de fin"));

        ObservableList<TraitementEntityObservable> observableList = FXCollections.observableArrayList();

        List<TraitementEntity> traitements = Utils.TRAITEMENT_DAO.findAll();

        for (TraitementEntity traitement : traitements) {
            if(traitement.getIdAnimal() == animal.getId()) {
                observableList.add(new TraitementEntityObservable(traitement));
            }
        }

        diseaseHistory.setItems(observableList);
    }

    //boutons du bas

    @FXML
    private void onActionAnimalModifyBtn() throws IOException {
        Utils.setModifyAnimal(true);
        Stage primaryStage = (Stage) animalModifyBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void onActionAnimalDeleteBtn() {
        //TODO Supprimer l'animal (afficher fenêtre de confirmation)
    }

    @FXML
    private void onActionPrescriptionGenerateBtn() {
        //TODO Générer l'ordonnance
    }

    @FXML
    private void onActionBillGenerateBtn() {
        //TODO Générer la facture
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

    public void onActionBackToAnimalsBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backToAnimals.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }
}