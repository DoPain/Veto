package pt4p1ae1.veto.GestionAnimaux;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RechercheAnimalController extends ControllerSample implements Initializable {

    @FXML
    private TableView<AnimalEntityObservable> animalsTableView;
    @FXML
    private TableColumn<AnimalEntityObservable, String> nomProprioColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> nomAnimalColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> nomEspeceColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> nomRaceColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> ageColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> poidsColumn;
    @FXML
    private TableColumn<AnimalEntityObservable, String> nextMeetingColumn;

    @FXML
    private Button insertButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nomProprioColumn.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        nomAnimalColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomEspeceColumn.setCellValueFactory(new PropertyValueFactory<>("espece"));
        nomRaceColumn.setCellValueFactory(new PropertyValueFactory<>("race"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
        poidsColumn.setCellValueFactory(new PropertyValueFactory<>("poids"));
        nextMeetingColumn.setCellValueFactory(new PropertyValueFactory<>("prochainRDV"));

        ObservableList<AnimalEntityObservable> observableList = FXCollections.observableArrayList();
        List<AnimalEntity> animals = Utils.ANIMAL_DAO.findAll();
        for (AnimalEntity animal : animals)
                observableList.add(new AnimalEntityObservable(animal));
        animalsTableView.setItems(observableList);
    }

    public void filterBtnOnAction(ActionEvent actionEvent) {
        //TODO
    }

    public void insertBtnOnAction(ActionEvent actionEvent) throws IOException {
        Utils.setModifyAnimal(false);
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void editBtnOnAction(ActionEvent actionEvent) throws IOException {
        Utils.setCurrentAnimal(animalsTableView.getSelectionModel().getSelectedItem().toAnimalEntity());
        Utils.setModifyAnimal(true);
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void deleteBtnOnAction(ActionEvent actionEvent) {
        //TODO
    }
}
