package pt4p1ae1.veto.GestionCLient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    public TextField nameClientField;
    public TextField firstNameClientField;
    public TextField emailClientField;

    public VBox vbox;

    public BorderPane borderPane;

    public Button filterButton;
    public Button firstButton;
    public Button previousButton;
    public Button nextButton;
    public Button lastButton;
    public Button insertButton;
    public Button editButton;
    public Button deleteButton;

    public TableColumn<ClientEntityObservable, String> nameColumn;
    public TableColumn<ClientEntityObservable, String> firstNameColumn;
    public TableColumn<ClientEntityObservable, String> ageColumn;
    public TableColumn<ClientEntityObservable, String> phoneColumn;
    public TableColumn<ClientEntityObservable, String> emailColumn;
    public TableColumn<ClientEntityObservable, String> nextMeetingColumn;

    public TableView<ClientEntityObservable> tableViewClient;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nextMeetingColumn.setCellValueFactory(new PropertyValueFactory<>("nextRDV"));

        ObservableList<ClientEntityObservable> observables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.CLIENT_DAO.findAll();

        for (ClientEntity client : clients) {
            ClientEntityObservable c = new ClientEntityObservable(client);
            observables.add(c);
        }

        tableViewClient.setItems(observables);
    }

    public void insererClient(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionClient.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    public void supprimerClient(ActionEvent actionEvent) {
        ClientEntityObservable selectedClient = tableViewClient.getSelectionModel().getSelectedItem();
        ClientEntity client = selectedClient.toClientEntity();
        System.out.println("Selected : " + client.getPersonneById().getNom() + " " + client.getPersonneById().getPrenom());
        Utils.CLIENT_DAO.remove(client);
    }
}

