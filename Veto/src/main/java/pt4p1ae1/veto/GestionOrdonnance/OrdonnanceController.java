package pt4p1ae1.veto.GestionOrdonnance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrdonnanceController extends ControllerSample implements Initializable {
    public TableColumn<ClientEntityObservable, String> nextMeetingClient;
    public TableColumn<ClientEntityObservable, String> firstNameClient;
    public TableColumn<ClientEntityObservable, String> nameClient;
    public TableView<ClientEntityObservable> tableViewClient;
    public TableView tableViewAnimal;
    public TableColumn<AnimalEntityObservable, Object> nameAnimal;
    public TableColumn<AnimalEntityObservable, Object> especeAnimal;
    public TableColumn<AnimalEntityObservable, Object> raceAnimal;
    public TableColumn<AnimalEntityObservable, Object> nextMeetingAnimal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        this.nameClient.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        this.firstNameClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.nextMeetingClient.setCellValueFactory(new PropertyValueFactory<>("nextRDV"));

        ObservableList<ClientEntityObservable> observables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.clientDao.findAll();

        for (ClientEntity client : clients) observables.add(new ClientEntityObservable(client));

        tableViewClient.setItems(observables);

        this.nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        this.raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));
        this.nextMeetingAnimal.setCellValueFactory(new PropertyValueFactory<>("prochainRDV"));
    }
}
