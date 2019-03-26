package pt4p1ae1.veto.GestionClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.VilleEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class DossierClientController extends ControllerSample implements Initializable {

    @FXML
    private TableColumn<AnimalEntityObservable, String> nameAnimal;
    @FXML
    private TableColumn<AnimalEntityObservable, String> ageAnimal;
    @FXML
    private TableColumn<AnimalEntityObservable, String> poidsAnimal;
    @FXML
    private TableColumn<AnimalEntityObservable, String> especeAnimal;
    @FXML
    private TableColumn<AnimalEntityObservable, String> raceAnimal;
    @FXML
    private TableView<AnimalEntityObservable> animals;

    @FXML
    private Button backToClients;

    @FXML
    private TextField nomAnimalClientText;
    @FXML
    private TextField firstNameClient;
    @FXML
    private TextField nameClient;
    @FXML
    private TextField mailClient;
    @FXML
    private TextField telClient;
    @FXML
    private TextField adresseClient;
    @FXML
    private TextField villeClient;
    @FXML
    private TextField naissanceClient;

    private final ObservableList<AnimalEntityObservable> observables = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        firstNameClient.setText(Utils.currentClient.getPersonneById().getPrenom());
        nameClient.setText(Utils.currentClient.getPersonneById().getNom());
        mailClient.setText(Utils.currentClient.getPersonneById().getMail());
        telClient.setText(Utils.currentClient.getPersonneById().getTelephone());
        adresseClient.setText(Utils.currentClient.getPersonneById().getAdresse());
        naissanceClient.setText(Utils.currentClient.getPersonneById().getDateNaissance().toString());
        villeClient.setText(Utils.currentClient.getPersonneById().getVilleByIdVille().getVilleNom());

        nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ageAnimal.setCellValueFactory(new PropertyValueFactory<>("age"));
        poidsAnimal.setCellValueFactory(new PropertyValueFactory<>("poids"));
        especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));

        List<AnimalEntity> allAnimal = Utils.getAnimalFromClient(Utils.currentClient.getId());
        for (AnimalEntity a : allAnimal) {
            observables.add(new AnimalEntityObservable(a));
        }

        animals.setItems(observables);

        nomAnimalClientText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrer();
            }
        });
    }

    @FXML
    private void filtrer() {
        ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
        if (!nomAnimalClientText.getText().equals("")) {
            for (AnimalEntityObservable client : observables) {
                if (client.getNom().contains(nomAnimalClientText.getText())) {
                    observableTmpList.add(client);
                }
            }
            animals.setItems(observableTmpList);
        } else {
            animals.setItems(observables);
        }
    }

    @FXML
    private void backToClientsBtn() throws IOException {
        Stage primaryStage = (Stage) backToClients.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheClient.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void supprClient() {
        System.out.println("oui");
    }

    @FXML
    private void validateModification() throws IOException, ParseException {
        applyChanges();
        System.out.println(Utils.currentClient.getPersonneById().getNom());
        Utils.CLIENT_DAO.saveOrUpdate(Utils.currentClient);
        backToClientsBtn();
        Utils.createLog("Modifier Client : "
                + Utils.currentClient.getPersonneById().getNom()
                + " "
                + Utils.currentClient.getPersonneById().getPrenom());
    }

    private void applyChanges() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (Utils.currentClient.getPersonneById().getDateNaissance().toString() != naissanceClient.getText()){
            Utils.currentClient.getPersonneById().setDateNaissance(new java.sql.Date(dateFormat.parse(naissanceClient.getText()).getTime()));
        }
        if (Utils.currentClient.getPersonneById().getPrenom() != firstNameClient.getText()) {
            Utils.currentClient.getPersonneById().setPrenom(firstNameClient.getText());
        }
        if (Utils.currentClient.getPersonneById().getNom() != nameClient.getText()) {
            Utils.currentClient.getPersonneById().setNom(nameClient.getText());
        }
        if (Utils.currentClient.getPersonneById().getMail() != mailClient.getText()) {
            Utils.currentClient.getPersonneById().setMail(mailClient.getText());
        }
        if (Utils.currentClient.getPersonneById().getTelephone() != telClient.getText()) {
            Utils.currentClient.getPersonneById().setTelephone(telClient.getText());
        }
        if (Utils.currentClient.getPersonneById().getAdresse() != adresseClient.getText()) {
            Utils.currentClient.getPersonneById().setAdresse(adresseClient.getText());
        }
    }
}
