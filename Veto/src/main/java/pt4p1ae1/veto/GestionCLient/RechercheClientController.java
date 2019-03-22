package pt4p1ae1.veto.GestionCLient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RechercheClientController extends ControllerSample implements Initializable {

    @FXML
    private Label error;

    @FXML
    private TextField nameClientField;
    @FXML
    private TextField firstNameClientField;
    @FXML
    private TextField emailClientField;

    @FXML
    private Button insertButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<ClientEntityObservable, String> nameColumn;
    @FXML
    private TableColumn<ClientEntityObservable, String> firstNameColumn;
    @FXML
    private TableColumn<ClientEntityObservable, String> ageColumn;
    @FXML
    private TableColumn<ClientEntityObservable, String> phoneColumn;
    @FXML
    private TableColumn<ClientEntityObservable, String> emailColumn;
    @FXML
    private TableColumn<ClientEntityObservable, String> nextMeetingColumn;

    @FXML
    private TableView<ClientEntityObservable> tableViewClient;

    private final ObservableList<ClientEntityObservable> observables = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nextMeetingColumn.setCellValueFactory(new PropertyValueFactory<>("nextRDV"));

        loadClients();
    }

    private void loadClients() {
        this.observables.clear();
        List<ClientEntity> clients = Utils.CLIENT_DAO.findAll();
        for (ClientEntity client : clients) {
            ClientEntityObservable c = new ClientEntityObservable(client);
            observables.add(c);
        }
        tableViewClient.setItems(observables);
    }

    @FXML
    private void insererClient(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionClient.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void supprimerClient(ActionEvent actionEvent) {
        if (tableViewClient.getSelectionModel().getSelectedItem() != null) {
            ClientEntityObservable selectedClient = tableViewClient.getSelectionModel().getSelectedItem();
            ClientEntity client = selectedClient.toClientEntity();
            Utils.createLog("Remove Client : " + client.getPersonneById().getNom() + " " + client.getPersonneById().getPrenom());
            Utils.CLIENT_DAO.delete(client);
            loadClients();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun client selectionné");
        }
    }
}

