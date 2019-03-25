package pt4p1ae1.veto.GestionAnimaux;


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
import javafx.scene.input.KeyCode;
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
    private TextField nomProprioText;
    @FXML
    private TextField nomAnimalText;
    @FXML
    private TextField especeText;
    @FXML
    private TextField raceText;

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
    private Button insertButton;
    @FXML
    private Button detailButton;

    @FXML
    private Label error;

    private ObservableList<AnimalEntityObservable> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nomProprioColumn.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        nomAnimalColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nomEspeceColumn.setCellValueFactory(new PropertyValueFactory<>("espece"));
        nomRaceColumn.setCellValueFactory(new PropertyValueFactory<>("race"));

        loadAnimals();

        nomProprioText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filterAnimals();
            }
        });

        nomAnimalText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filterAnimals();
            }
        });

        especeText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filterAnimals();
            }
        });

        raceText.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filterAnimals();
            }
        });
    }

    public void filterBtnOnAction(ActionEvent actionEvent) {
        filterAnimals();
    }

    public void insertBtnOnAction(ActionEvent actionEvent) throws IOException {
        error.setText("");
        Utils.setModifyAnimal(false);
        Stage primaryStage = (Stage) insertButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionAnimal.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.centerOnScreen();
    }

    public void detailBtnOnAction(ActionEvent actionEvent) throws IOException {
        if (animalsTableView.getSelectionModel().getSelectedItem() != null) {
            error.setText("");
            AnimalEntityObservable animalObservable = animalsTableView.getSelectionModel().getSelectedItem();
            AnimalEntity animal = animalObservable.getAnimal();
            Utils.setCurrentAnimal(animal);
            Stage primaryStage = (Stage) detailButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierAnimal.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun animal selectionné");
        }
    }

    private void loadAnimals() {
        nomProprioText.setText("");
        nomAnimalText.setText("");
        especeText.setText("");
        raceText.setText("");
        List<AnimalEntity> animals = Utils.ANIMAL_DAO.findAll();
        for (AnimalEntity animal : animals)
            observableList.add(new AnimalEntityObservable(animal));
        animalsTableView.setItems(observableList);
    }

    private void filterAnimals(){
        Boolean ajout = false;
        ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
        ObservableList<AnimalEntityObservable> observableTmpListCopy = FXCollections.observableArrayList();

        if(!nomProprioText.getText().equals("")){
            ajout = true;
            for (AnimalEntityObservable animal : observableList) {
                if (animal.getProprietaire().contains(nomProprioText.getText())) {
                    observableTmpList.add(animal);
                }
            }
            observableTmpListCopy.addAll(observableTmpList);
        }

        if(!nomAnimalText.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (AnimalEntityObservable animal : observableList) {
                    if (animal.getNom().contains(nomAnimalText.getText())) {
                        observableTmpList.add(animal);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(AnimalEntityObservable animalT : observableTmpListCopy){
                    if(!animalT.getNom().contains(nomAnimalText.getText())){
                        observableTmpList.remove(animalT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!especeText.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (AnimalEntityObservable animal : observableList) {
                    if (animal.getEspece().contains(especeText.getText())) {
                        observableTmpList.add(animal);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(AnimalEntityObservable animalT : observableTmpListCopy){
                    if(!animalT.getEspece().contains(especeText.getText())){
                        observableTmpList.remove(animalT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!raceText.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (AnimalEntityObservable animal : observableList) {
                    if (animal.getRace().contains(raceText.getText())) {
                        observableTmpList.add(animal);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(AnimalEntityObservable animalT : observableTmpListCopy){
                    if (!animalT.getRace().contains(raceText.getText())){
                        observableTmpList.remove(animalT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!ajout){
            animalsTableView.setItems(observableList);
        } else {
            animalsTableView.setItems(observableTmpList);
        }

    }
}
