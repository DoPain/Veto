package pt4p1ae1.veto.GestionAnimaux;

import javafx.collections.ObservableList;
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
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.EspeceEntity;
import pt4p1ae1.veto.Entity.RaceEntity;
import pt4p1ae1.veto.Utils;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InscriptionAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Button backToAnimalsBtn;
    @FXML
    private Button registerBtn;
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
        ArrayList<String> speciesList = new ArrayList<>();
        Utils.ESPECE_DAO.findAll().forEach(espece -> speciesList.add(espece.getNom()));
        speciesComboBox.setItems((ObservableList<String>)speciesList);

        if(Utils.isModifyAnimal()) {
            AnimalEntityObservable animalObservable = new AnimalEntityObservable(animal);
            nameTextField.setText(animalObservable.getNom());
            if(animalObservable.getSexe()=="femelle") {
                femaleRadioBtn.setSelected(true);
            } else {
                maleRadioBtn.setSelected(true);
            }
            birthDateTextField.setText(animalObservable.getDateDeNaissance());
            weightTextField.setText(animalObservable.getPoids());
            furtherInformationsTextField.setText(animalObservable.getAutresInformations());

            registerBtn.setText("Enregistrer les modifications");

            titleLabel.setText("Modification de " + animalObservable.getNom());
        }
    }

    @FXML
    private void onActionSpeciesComboBox() {
        ArrayList<String> racesList = new ArrayList<>();
        Utils.RACE_DAO.findAll().forEach(race -> racesList.add(race.getNom()));
        raceComboBox.setItems((ObservableList<String>)racesList);
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

        //Insérer le nouvel animal dans la base
        boolean male = true;
        if(femaleRadioBtn.isSelected()){
            male=false;
        }

        if(!Utils.isModifyAnimal()) {
            AnimalEntity newAnimal = new AnimalEntity();
            newAnimal.setNom(nameTextField.getText());
            newAnimal.setIdRace(((Long) raceComboBox.getValue()));
            newAnimal.setSexe(male ? "male" : "femelle");
            newAnimal.setDateNaissance((Timestamp.valueOf(birthDateTextField.getText())));
            newAnimal.setPoids(Double.parseDouble(weightTextField.getText()));
            newAnimal.setAutreInformations(furtherInformationsTextField.getText());
            Utils.ANIMAL_DAO.saveOrUpdate(newAnimal);
        } else {
            animal.setNom(nameTextField.getText());
            animal.setIdRace(((Long) raceComboBox.getValue()));
            animal.setSexe(male ? "male" : "femelle");
            animal.setDateNaissance((Timestamp.valueOf(birthDateTextField.getText())));
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
}
