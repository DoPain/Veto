package pt4p1ae1.veto.GestionOrdonnance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
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
    public TableView<AnimalEntityObservable> tableViewAnimal;
    public TableColumn<AnimalEntityObservable, String> nameAnimal;
    public TableColumn<AnimalEntityObservable, String> especeAnimal;
    public TableColumn<AnimalEntityObservable, String> raceAnimal;
    public TableColumn<AnimalEntityObservable, String> nextMeetingAnimal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        this.nameClient.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        this.firstNameClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.nextMeetingClient.setCellValueFactory(new PropertyValueFactory<>("nextRDV"));

        ObservableList<ClientEntityObservable> clientEntityObservables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.clientDao.findAll();

        for (ClientEntity client : clients) clientEntityObservables.add(new ClientEntityObservable(client));

        tableViewClient.setItems(clientEntityObservables);

        this.nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        this.raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));
        this.nextMeetingAnimal.setCellValueFactory(new PropertyValueFactory<>("prochainRDV"));

        ObservableList<AnimalEntityObservable> animalEntityObservables = FXCollections.observableArrayList();

        List<AnimalEntity> animals;

        if (tableViewClient.getSelectionModel().isEmpty())
            animals = tableViewClient.getSelectionModel().getSelectedItem().to.getAnimalsById();
        else
            animals = Utils.animalDao.findAll();

        for (AnimalEntity animal : animals) animalEntityObservables.add(new AnimalEntityObservable(animal));
        tableViewAnimal.setItems(animalEntityObservables);
    }
}
