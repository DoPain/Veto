package pt4p1ae1.veto.GestionAnimaux;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RaceEntity;
import pt4p1ae1.veto.Utils;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class InscriptionAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Button backToAnimalsBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private ComboBox ownerComboBox;
    @FXML
    private Button newCustomer;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox speciesComboBox;
    @FXML
    private ComboBox raceComboBox;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private RadioButton femaleRadioBtn;
    @FXML
    private TextField birthDateTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField furtherInformationsTextField;

    AnimalEntity animal = Utils.getCurrentAnimal();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        //Remplir ComboBox des espèces
        List<String> speciesList = new ArrayList<>();
        Utils.ESPECE_DAO.findAll().forEach(espece -> speciesList.add(espece.getNom()));
        speciesComboBox.setItems(FXCollections.observableList(speciesList));

        ArrayList<String> ownersList = new ArrayList<>();
        Utils.CLIENT_DAO.findAll().forEach(client -> ownersList.add(client.getPersonneById().getNom()));
        ownerComboBox.setItems(FXCollections.observableList(ownersList));

        if(Utils.isModifyAnimal()) {
            AnimalEntityObservable animalObservable = new AnimalEntityObservable(animal);
            nameTextField.setText(animalObservable.getNom());
            //birthDateTextField.setText(animalObservable.getDateDeNaissance());
            weightTextField.setText(animalObservable.getPoids());
            furtherInformationsTextField.setText(animalObservable.getAutresInformations());

            registerBtn.setText("Enregistrer les modifications");

            titleLabel.setText("Modification de " + animalObservable.getNom());
        }
    }

    @FXML
    private void onActionSpeciesComboBox() {
        ArrayList<String> racesList = new ArrayList<>();
        for (RaceEntity race : Utils.RACE_DAO.findAll()) {
            if(race.getEspeceByIdEspece().getNom().equals(speciesComboBox.getValue().toString())){
                racesList.add(race.getNom());
            }
        }
        raceComboBox.setItems(FXCollections.observableList(racesList));
    }

    @FXML
    private void onActionBackToAnimalsBtn() throws IOException {
        Stage primaryStage = (Stage) backToAnimalsBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void onActionRegisterBtn() throws IOException {
        if(!Utils.isModifyAnimal()) {
            AnimalEntity newAnimal = new AnimalEntity();
            newAnimal.setNom(nameTextField.getText());
            long idRace = -1;
            for(RaceEntity race : Utils.RACE_DAO.findAll()) {
                if(race.getNom().equals(raceComboBox.getValue().toString())) {
                    idRace = race.getId();
                }
            }
            newAnimal.setIdRace(idRace);
            if(maleRadioBtn.isSelected()) newAnimal.setSexe('M');
            else newAnimal.setSexe('F');
            newAnimal.setDateNaissance((Date.valueOf(birthDateTextField.getText())));
            newAnimal.setPoids(Double.parseDouble(weightTextField.getText()));
            newAnimal.setAutreInformations(furtherInformationsTextField.getText());
            Utils.ANIMAL_DAO.saveOrUpdate(newAnimal);
        } else {
            animal.setNom(nameTextField.getText());
            long idRace = -1;
            for(RaceEntity race : Utils.RACE_DAO.findAll()) {
                if(race.getNom().equals(raceComboBox.getValue().toString())) {
                    idRace = race.getId();
                }
            }
            animal.setIdRace(idRace);
            if(maleRadioBtn.isSelected()) animal.setSexe('M');
            else animal.setSexe('F');
            animal.setDateNaissance((Date.valueOf(birthDateTextField.getText())));
            animal.setPoids(Double.parseDouble(weightTextField.getText()));
            animal.setAutreInformations(furtherInformationsTextField.getText());
            Utils.ANIMAL_DAO.saveOrUpdate(animal);
        }

        Utils.setModifyAnimal(false);
        //Rediriger vers la liste animaux
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void newCustomerOnAction(ActionEvent actionEvent) throws IOException {
        //TODO Modifier redirections de inscriptionClient en fonction de fromAddAnimal
        Utils.setFromAddAnimal(true);
        Stage primaryStage = (Stage) newCustomer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionClient.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }
}
