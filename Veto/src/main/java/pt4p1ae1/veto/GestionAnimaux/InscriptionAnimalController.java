package pt4p1ae1.veto.GestionAnimaux;

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
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.EspeceEntity;
import pt4p1ae1.veto.Entity.RaceEntity;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InscriptionAnimalController extends ControllerSample implements Initializable {

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

    EntityDao<AnimalEntity> daoAnimal;
    EntityDao<EspeceEntity> daoSpecie;
    EntityDao<RaceEntity> daoRace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        daoAnimal = DaoFactory.getDaoFor(AnimalEntity.class);
        daoSpecie = DaoFactory.getDaoFor(EspeceEntity.class);
        daoRace = DaoFactory.getDaoFor(RaceEntity.class);

        //Remplir ComboBox des espèces
        ArrayList<String> speciesList = new ArrayList<>();
        daoSpecie.findAll().forEach(espece -> speciesList.add(espece.getNom()));
        speciesComboBox.setItems((ObservableList<String>)speciesList);
    }

    @FXML
    private void onActionSpeciesComboBox() {
        //TODO Remplir RaceComboBox en fonction du EspeceComboBox sélectionné
        ArrayList<String> racesList = new ArrayList<>();
        daoRace.findAll().forEach(race -> racesList.add(race.getNom()));
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

        AnimalEntity newAnimal = new AnimalEntity();
        newAnimal.setNom(nameTextField.getText());
        newAnimal.setIdRace(((Long) raceComboBox.getValue()));
        newAnimal.setSexe(male?"male":"femelle");
        newAnimal.setDateNaissance((Timestamp.valueOf(birthDateTextField.getText())));
        newAnimal.setPoids(Double.parseDouble(weightTextField.getText()));
        newAnimal.setAutresInfromations(furtherInformationsTextField.getText());
        daoAnimal.saveOrUpdate(newAnimal);

        //Rediriger vers la liste animaux
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }
}
