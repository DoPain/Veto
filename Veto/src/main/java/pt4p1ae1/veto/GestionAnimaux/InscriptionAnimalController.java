package pt4p1ae1.veto.GestionAnimaux;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.RaceEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class InscriptionAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Button backToAnimalsBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private ComboBox<ClientEntity> ownerComboBox;
    @FXML
    private Button newCustomer;
    @FXML
    private javafx.scene.control.TextField nameText;
    @FXML
    private ComboBox speciesComboBox;
    @FXML
    private ComboBox raceComboBox;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private RadioButton femaleRadioBtn;
    @FXML
    private TextField birthDateText;
    @FXML
    private TextField weightText;
    @FXML
    private TextField furtherInformationsText;
    @FXML
    private Label error;

    AnimalEntity animal = Utils.getCurrentAnimal();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        List<String> speciesList = new ArrayList<>();
        Utils.ESPECE_DAO.findAll().forEach(espece -> speciesList.add(espece.getNom()));
        speciesComboBox.setItems(FXCollections.observableList(speciesList));

        ArrayList<ClientEntity> ownersList = new ArrayList<>();
        Utils.CLIENT_DAO.findAll().forEach(client -> ownersList.add(client));
        ownerComboBox.setItems(FXCollections.observableList(ownersList));

        birthDateText.setPromptText("aaaa-mm-jj");

        if(Utils.isModifyAnimal()) {
            AnimalEntityObservable animalObservable = new AnimalEntityObservable(animal);
            ownerComboBox.getSelectionModel().select(animal.getClientByIdClient());
            nameText.setText(animal.getNom());
            speciesComboBox.getSelectionModel().select(animalObservable.getEspece());
            raceComboBox.getSelectionModel().select(animalObservable.getRace());
            if(animalObservable.getSexe().equals("M"))
                maleRadioBtn.setSelected(true);
            if(animalObservable.getSexe().equals("F"))
                femaleRadioBtn.setSelected(true);
            birthDateText.setText(animalObservable.getDateDeNaissance().toString());
            weightText.setText(animalObservable.getPoids());
            furtherInformationsText.setText(animalObservable.getAutresInformations());

            registerBtn.setText("Enregistrer les modifications");
            titleLabel.setText("Modification de " + animalObservable.getNom());

            if(speciesComboBox.getValue() != null) {
                onActionSpeciesComboBox();
            }
        } else {
            furtherInformationsText.setText("Aucune autre information.");
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
        Parent root;
        if(Utils.isModifyAnimal())
            root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
        else
            root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();

    }

    @FXML
    private void onActionRegisterBtn() throws IOException {
        if(!ownerComboBox.getValue().equals("")
                && !nameText.getText().equals("")
                && !speciesComboBox.getValue().equals("")
                && !raceComboBox.getValue().equals("")
                && (maleRadioBtn.isSelected() || femaleRadioBtn.isSelected())
                && !birthDateText.getText().equals("")
                && !weightText.getText().equals("")
                && !furtherInformationsText.getText().equals("")) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
            java.util.Date dateB = null;
            try {
                dateB = formatter.parse(birthDateText.getText());
            } catch (ParseException e) {
                error.setStyle("-fx-text-fill: red");
                error.setText("Date invalide");
            }
            java.sql.Date sqlDateB = new java.sql.Date(dateB.getTime());
            if (!Utils.isModifyAnimal()) {
                AnimalEntity newAnimal = new AnimalEntity();
                newAnimal.setIdClient(ownerComboBox.getValue().getId());
                newAnimal.setNom(nameText.getText());
                long idRace = -1;
                for (RaceEntity race : Utils.RACE_DAO.findAll()) {
                    if (race.getNom().equals(raceComboBox.getValue().toString())) {
                        idRace = race.getId();
                    }
                }
                newAnimal.setIdRace(idRace);
                if (maleRadioBtn.isSelected()) newAnimal.setSexe("M");
                else newAnimal.setSexe("F");
                newAnimal.setDateNaissance(sqlDateB);
                newAnimal.setPoids(Double.parseDouble(weightText.getText()));
                newAnimal.setAutreInformations(furtherInformationsText.getText());
                Utils.ANIMAL_DAO.saveOrUpdate(newAnimal);
                Utils.createLog("Ajout animal : " + newAnimal.getNom());
            } else {
                animal.setIdClient(ownerComboBox.getValue().getId());
                animal.setNom(nameText.getText());
                long idRace = -1;
                for (RaceEntity race : Utils.RACE_DAO.findAll()) {
                    if (race.getNom().equals(raceComboBox.getValue().toString())) {
                        idRace = race.getId();
                    }
                }
                animal.setIdRace(idRace);
                if (maleRadioBtn.isSelected()) animal.setSexe("M");
                else animal.setSexe("F");
                animal.setDateNaissance(sqlDateB);
                animal.setPoids(Double.parseDouble(weightText.getText()));
                animal.setAutreInformations(furtherInformationsText.getText());
                Utils.ANIMAL_DAO.saveOrUpdate(animal);
                Utils.createLog("Modification animal : " + animal.getNom() + " appartenant à " +
                        animal.getClientByIdClient().getPersonneById().getNom());
            }

            Utils.setModifyAnimal(false);
            //Rediriger vers la liste animaux
            Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheAnimal.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Veuillez remplir tous les champs");
        }
    }

    public void newCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) newCustomer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionClient.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void maleRBOnAction(ActionEvent actionEvent) {
        if(maleRadioBtn.isSelected())
            femaleRadioBtn.setSelected(false);
    }

    public void femaleRBOnAction(ActionEvent actionEvent) {
        if(femaleRadioBtn.isSelected())
            maleRadioBtn.setSelected(false);
    }
}
