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
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.GestionEmploye.EmployeEntityObservable;
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

        tableViewClient.setRowFactory(tv -> {
            TableRow<ClientEntityObservable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    ClientEntityObservable client = row.getItem();
                    Utils.currentClient = client.toClientEntity();
                    try {
                        super.creatBtn("/fxml/dossierClient.fxml", (Stage) tableViewClient.getScene().getWindow());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

        loadClients();

        firstNameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrer();
            }
        });

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrer();
            }
        });
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
    private void insererClient() throws IOException {
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionClient.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void supprimerClient() {
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

    @FXML
    private void modifierClient() throws IOException {
        if (tableViewClient.getSelectionModel().getSelectedItem() != null) {
            Utils.currentClient = tableViewClient.getSelectionModel().getSelectedItem().toClientEntity();
            Stage primaryStage = (Stage) editButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierClient.fxml"));
            primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
            primaryStage.centerOnScreen();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun client selectionné");
        }
    }

    @FXML
    private void filtrer() {
        boolean filter = false;
        ObservableList<ClientEntityObservable> observableTmpList = FXCollections.observableArrayList();
        ObservableList<ClientEntityObservable> observableTmpListCopy = FXCollections.observableArrayList();
        if(!nameClientField.getText().equals("")){
            filter = true;
            for (ClientEntityObservable client : observables) {
                if (client.getNom().contains(nameClientField.getText())) {
                    observableTmpList.add(client);
                }
            }
            observableTmpListCopy.addAll(observableTmpList);
        }

        if(!firstNameClientField.getText().equals("")){
            if(!filter){
                filter = true;
                for (ClientEntityObservable client : observables) {
                    if (client.getPrenom().contains(firstNameClientField.getText())) {
                        observableTmpList.add(client);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(ClientEntityObservable client : observableTmpListCopy){
                    if(!client.getPrenom().contains(firstNameClientField.getText())){
                        observableTmpList.remove(client);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }
        if (!filter) {
            tableViewClient.setItems(observables);
        } else {
            tableViewClient.setItems(observableTmpList);
        }
    }
}

