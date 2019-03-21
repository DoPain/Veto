package pt4p1ae1.veto.GestionOrdonnance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrdonnanceController extends ControllerSample implements Initializable {
    public TableColumn nextMeetingColumn;
    public TableColumn firstNameColumn;
    public TableColumn nameColumn;
    public TableView tableViewClient;
    public TableView tableViewAnimal;
    public TableColumn nomAnimalColumn;
    public TableColumn nomEspeceColumn;
    public TableColumn nomRaceColumn;
    public TableColumn nextMeeting;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nextMeetingColumn.setCellValueFactory(new PropertyValueFactory<>("nextRDV"));

        ObservableList<ClientEntityObservable> observables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.clientDao.findAll();

        for (ClientEntity client : clients) {
            ClientEntityObservable c = new ClientEntityObservable(client);
            observables.add(c);
            System.out.println(c.getNom() + " " + c.getPrenom());
        }

        tableViewClient.setItems(observables);
    }
}
