package pt4p1ae1.veto.GestionOrdonnance;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.OrdonnanceEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RechercheOrdonnanceController extends ControllerSample implements Initializable {
    public TextField nameClientField;
    public TextField nameAnimalField;
    public TableView<OrdonnanceEntityObservable> tableViewOrdonnace;
    public TableColumn<OrdonnanceEntityObservable, String> nameAnimal;
    public TableColumn<OrdonnanceEntityObservable, String> nameClient;
    public TableColumn<OrdonnanceEntityObservable, String> dateOrdonnance;
    public TableColumn<OrdonnanceEntityObservable, String> veterinaire;
    public Button createOrdonnace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nameAnimal"));
        nameClient.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        dateOrdonnance.setCellValueFactory(new PropertyValueFactory<>("date"));
        veterinaire.setCellValueFactory(new PropertyValueFactory<>("veterinaire"));

        ObservableList<OrdonnanceEntityObservable> observableList = FXCollections.observableArrayList();

        for (OrdonnanceEntity ordonnanceEntity : Utils.ORDONNANCE_DAO.findAll())
            observableList.add(new OrdonnanceEntityObservable(ordonnanceEntity));

        tableViewOrdonnace.setItems(observableList);

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                nameAnimalField.setText("");
                ObservableList<OrdonnanceEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameClientField.getText().equals("")) {
                    for (OrdonnanceEntityObservable ordonnance : observableList)
                        if (ordonnance.getNameClient().contains(nameClientField.getText()))
                            observableTmpList.add(ordonnance);
                    tableViewOrdonnace.setItems(observableTmpList);
                } else
                    tableViewOrdonnace.setItems(observableList);
            }
        });

        nameAnimalField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                nameClientField.setText("");
                ObservableList<OrdonnanceEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameAnimalField.getText().equals("")) {
                    for (OrdonnanceEntityObservable ordonnance : observableList)
                        if (ordonnance.getNameAnimal().contains(nameAnimalField.getText()))
                            observableTmpList.add(ordonnance);
                    tableViewOrdonnace.setItems(observableTmpList);
                } else
                    tableViewOrdonnace.setItems(observableList);
            }
        });

    }

    @FXML
    public void createOrdonnanceView() throws IOException {
        Stage primaryStage = (Stage) createOrdonnace.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pageOrdonnance.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
    }
}
