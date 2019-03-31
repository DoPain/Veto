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
    private TextField cpClient;
    @FXML
    private ComboBox<VilleEntityObservable> villeClient;
    @FXML
    private TextField naissanceClient;
    @FXML
    private Button supprAnimalClient;
    @FXML
    private Button insertAnimalClient;
    @FXML
    private Button editAnimalClient;

    private final ObservableList<AnimalEntityObservable> animalsObservables = FXCollections.observableArrayList();
    private final List<VilleEntity> villes = Utils.VILLE_DAO.findAll();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        ObservableList<VilleEntityObservable> villesObservables = FXCollections.observableArrayList();
        cpClient.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                villesObservables.clear();
                villesObservables.clear();
                for (VilleEntity v : villes) {
                    if (v.getVilleCodePostal().contains(cpClient.getText())) {
                        villesObservables.add(new VilleEntityObservable(v));
                    }
                }
                villeClient.setItems(villesObservables);
            }
        });
        villeClient.setOnAction(e -> {
            cpClient.setText(villeClient.getValue().getCp());
        });

        firstNameClient.setText(Utils.currentClient.getPersonneById().getPrenom());
        nameClient.setText(Utils.currentClient.getPersonneById().getNom());
        if (null != Utils.currentClient.getPersonneById().getMail()) {
            mailClient.setText(Utils.currentClient.getPersonneById().getMail());
        }
        if (null != Utils.currentClient.getPersonneById().getTelephone()) {
            telClient.setText(Utils.currentClient.getPersonneById().getTelephone());
        }
        if (null != Utils.currentClient.getPersonneById().getAdresse()) {
            adresseClient.setText(Utils.currentClient.getPersonneById().getAdresse());
        }
        if (Utils.currentClient.getPersonneById().getDateNaissance() != null) {
            naissanceClient.setText(Utils.currentClient.getPersonneById().getDateNaissance().toString());
        }
        if (!Utils.currentClient.getPersonneById().getVilleByIdVille().getVilleCodePostal().equals("")) {
            cpClient.setText(Utils.currentClient.getPersonneById().getVilleByIdVille().getVilleCodePostal());
        }
        if (Utils.currentClient.getPersonneById().getVilleByIdVille() != null) {
            villeClient.setValue(new VilleEntityObservable(Utils.currentClient.getPersonneById().getVilleByIdVille()));
        }
        nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ageAnimal.setCellValueFactory(new PropertyValueFactory<>("age"));
        poidsAnimal.setCellValueFactory(new PropertyValueFactory<>("poids"));
        especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));

        chargerAnimaux();

        nomAnimalClientText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrer();
            }
        });
    }

    /**
     * Fonction filtrant les entrées dans le tableau en fonction du nom et/ou prénom recherché.
     */
    @FXML
    private void filtrer() {
        ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
        if (!nomAnimalClientText.getText().equals("")) {
            for (AnimalEntityObservable client : animalsObservables) {
                if (client.getNom().contains(nomAnimalClientText.getText())) {
                    observableTmpList.add(client);
                }
            }
            animals.setItems(observableTmpList);
        } else {
            animals.setItems(animalsObservables);
        }
    }

    /**
     * Fonction gérant le retour à la liste des clients.
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     */
    @FXML
    private void backToClientsBtn() throws IOException {
        Stage primaryStage = (Stage) backToClients.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheClient.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    /**
     * Fonction gérant la suppression du client.
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     */
    @FXML
    private void supprClient() throws IOException {
        Parent root1 = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();
        if (Utils.getConfirmation()) {
            Utils.createLog("Suppression Client : " + Utils.currentClient.getPersonneById().getNom() + " " + Utils.currentClient.getPersonneById().getPrenom());
            Utils.CLIENT_DAO.delete(Utils.currentClient);
            creatBtn("/fxml/rechercheClient.fxml", (Stage) backToClients.getScene().getWindow());
        }
    }

    /**
     * Fonction gérant la modification de l'entité et de l'update dans la base de donnée.
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     * @throws ParseException si la date parsée ne correspond pas au format demandé
     */
    @FXML
    private void validateModification() throws IOException, ParseException {
        Parent root1 = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();

        if (Utils.getConfirmation()) {
            applyChanges();
            Utils.CLIENT_DAO.saveOrUpdate(Utils.currentClient);
            Utils.PERSONNE_DAO.saveOrUpdate(Utils.currentClient.getPersonneById());
            backToClientsBtn();
            Utils.createLog("Modification Client : "
                    + Utils.currentClient.getPersonneById().getNom()
                    + " "
                    + Utils.currentClient.getPersonneById().getPrenom());
            super.creatBtn("/fxml/rechercheClient.fxml", (Stage) backToClients.getScene().getWindow());
        }
    }

    /**
     * Appliquer les changements des modifications sur l'entité.
     *
     * @throws ParseException si la date parsée ne correspond pas au format demandé
     */
    private void applyChanges() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!naissanceClient.getText().equals("")) {
            Utils.currentClient.getPersonneById().setDateNaissance(new java.sql.Date(dateFormat.parse(naissanceClient.getText()).getTime()));
        }
        if (Utils.currentClient.getPersonneById().getPrenom() != firstNameClient.getText()) {
            Utils.currentClient.getPersonneById().setPrenom(firstNameClient.getText());
        }
        if (Utils.currentClient.getPersonneById().getNom() != nameClient.getText()) {
            Utils.currentClient.getPersonneById().setNom(nameClient.getText());
        }
        if (!mailClient.getText().equals("")) {
            Utils.currentClient.getPersonneById().setMail(mailClient.getText());
        }
        if (!telClient.getText().equals("")) {
            Utils.currentClient.getPersonneById().setTelephone(telClient.getText());
        }
        if (!adresseClient.getText().equals("")) {
            Utils.currentClient.getPersonneById().setAdresse(adresseClient.getText());
        }
    }

    /**
     * Fonction supprimant l'animal sélectionné
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     */
    @FXML
    private void supprAnimal() throws IOException {
        List<AnimalEntity> animaux = Utils.ANIMAL_DAO.findAll();
        if (animals.getSelectionModel().getSelectedItem() != null) {
            AnimalEntity animalE = animals.getSelectionModel().getSelectedItem().getAnimalEntity();
            Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Confirmation");
            stage.showAndWait();
            if(Utils.getConfirmation()){
                Utils.ANIMAL_DAO.delete(animalE);
                this.animalsObservables.clear();
                chargerAnimaux();

            }
        }
    }

    /**
     * Fonction chargeant les animaux dans le tableau correspondant.
     */
    private void chargerAnimaux(){
        List<AnimalEntity> allAnimal = Utils.getAnimalFromClient(Utils.currentClient.getId());
        for (AnimalEntity a : allAnimal) {
            animalsObservables.add(new AnimalEntityObservable(a));
        }

        animals.setItems(animalsObservables);
    }

    /**
     * Fonction changeant la page de modification de l'animal séléctionné.
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     */
    @FXML
    private void modifAnimal() throws IOException {
        if(animals.getSelectionModel().getSelectedItem() != null) {
            Utils.setCurrentAnimal(animals.getSelectionModel().getSelectedItem().getAnimalEntity());
            Utils.setModifyAnimal(true);
            super.creatBtn("/fxml/inscriptionAnimal.fxml",(Stage) editAnimalClient.getScene().getWindow());
        }
    }

    /**
     * Fonction chargeant la page d'inscription d'un animal.
     *
     * @throws IOException si l'application ne trouve pas le fxml concerné
     */
    @FXML
    private void insererAnimal() throws IOException {
        super.creatBtn("/fxml/inscriptionAnimal.fxml", (Stage) insertAnimalClient.getScene().getWindow());
    }
}
