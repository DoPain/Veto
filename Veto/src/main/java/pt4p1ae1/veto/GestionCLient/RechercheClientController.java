package pt4p1ae1.veto.GestionCLient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Utils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RechercheClientController extends ControllerSample implements Initializable {

    @FXML
    private TextField nameProprioField;
    @FXML
    private TextField nameAnimalField;
    @FXML
    private TextField speciesField;
    @FXML
    private TextField raceField;

    @FXML
    private Button filterButton;
    @FXML
    private Button firstButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button lastButton;
    @FXML
    private Button insertButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableView<ClientEntityObservable> tableView;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nextMeetingColumn.setCellValueFactory(new PropertyValueFactory<>("rdv"));

        ObservableList<ClientEntityObservable> observables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.clientDao.findAll();

        for (ClientEntity client : clients){
            observables.add(new ClientEntityObservable(client));
        }

        tableView.setItems(observables);
    }

    public void onActionInsertAnimal(ActionEvent actionEvent) {
    }

    public void onActionEditAnimal(ActionEvent actionEvent) {
    }

    public void onActionDeleteAnimal(ActionEvent actionEvent) {
    }
}

