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
    private Label animalNameLab;
    @FXML
    private Label resumeAnimalLabel;
    @FXML
    private Label diseaseHistoryTitle;

    @FXML
    private Label error;
    @FXML
    private Label resumeAnimalTitle;

    //les boutons du bas
    @FXML
    private Button animalModify;
    @FXML
    private Button animalDelete;

    //liste des maladies
    @FXML
    private TableView <TraitementEntityObservable> diseaseHistory;
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
    private AnimalEntity animal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        animal = Utils.getCurrentAnimal();
        AnimalEntityObservable animalObservable = new AnimalEntityObservable(animal);

        //Mettre le nom de l'animal dans animalNameLabel
        animalNameLab.setText(animal.getNom());
        error.setText("");
        animalNameLab.setStyle("-fx-font-weight: bold");
        resumeAnimalTitle.setStyle("-fx-font-weight: bold");
        diseaseHistoryTitle.setStyle("-fx-font-weight: bold");

        //Afficher résumé de l'animal dans resumeAnimalLabel
        resumeAnimalLabel.setText(
                "Propriétaire : " + animalObservable.getProprietaire()
                        + "\n\nNom : " + animalObservable.getNom()
                        + "\n\nEspèce : " + animalObservable.getEspece()
                        + "\n\nRace : " + animalObservable.getRace()
                        + "\n\nDate de naissance : " + animalObservable.getDateDeNaissance()
                        + "\n\nPoids : " + animalObservable.getPoids()
                        + "\n\nAutres informations : " + animalObservable.getAutresInformations()
        );


        //Afficher historique des maladies dans diseaseHistoryList
        diseaseCol.setCellValueFactory(new PropertyValueFactory<>("maladie"));
        careCol.setCellValueFactory(new PropertyValueFactory<>("soin"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("dateFin"));

        loadTraitements();
    }

    //boutons du bas

    @FXML
    private void onActionAnimalModifyBtn() throws IOException {
        Utils.setModifyAnimal(true);
        Stage primaryStage = (Stage) animalModify.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void onActionAnimalDeleteBtn() throws IOException {
        //TODO Supprimer l'animal (afficher fenêtre de confirmation)
        Utils.createLog("Suppression Animal : " + animal.getNom() +
                " appartenant à " + animal.getClientByIdClient().getPersonneById().getNom());
        Utils.ANIMAL_DAO.delete(animal);
        Stage primaryStage = (Stage) animalDelete.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void onActionInsertCareBtn() throws IOException {
        //TODO Afficher la fenêtre d'insertion d'un soin
        Utils.setModifyDisease(false);
        Stage primaryStage = (Stage) insertDiseaseBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ajoutMaladie.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void onActionEditCareBtn() throws IOException {
        if (diseaseHistory.getSelectionModel().getSelectedItem() != null) {
            error.setText("");
            TraitementEntityObservable traitementObservable = diseaseHistory.getSelectionModel().getSelectedItem();
            TraitementEntity traitement = traitementObservable.getTraitement();
            Utils.setCurrentTraitement(traitement);
            Utils.setModifyDisease(true);
            Stage primaryStage = (Stage) editDiseaseBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ajoutMaladie.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucune maladie selectionnée");
        }
    }

    @FXML
    private void onActionDeleteCareBtn() {
        if (diseaseHistory.getSelectionModel().getSelectedItem() != null) {
            error.setText("");
            TraitementEntityObservable selectedTraitement = diseaseHistory.getSelectionModel().getSelectedItem();
            TraitementEntity traitement = selectedTraitement.getTraitement();
            Utils.createLog("Suppression Traitement : " + traitement.getMaladie() +
                    " à " + traitement.getAnimalByIdAnimal().getNom() +
                    " appartenant à " + traitement.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getNom());
            Utils.TRAITEMENT_DAO.delete(traitement);
            loadTraitements();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucune maladie selectionnée");
        }
    }

    public void onActionBackToAnimalsBtn(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backToAnimals.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    private void loadTraitements() {
        ObservableList<TraitementEntityObservable> observableList = FXCollections.observableArrayList();
        List<TraitementEntity> traitements = Utils.TRAITEMENT_DAO.findAll();
        for (TraitementEntity traitement : traitements) {
            if(traitement.getIdAnimal() == animal.getId()) {
                observableList.add(new TraitementEntityObservable(traitement));
            }
        }
        diseaseHistory.setItems(observableList);
    }
}