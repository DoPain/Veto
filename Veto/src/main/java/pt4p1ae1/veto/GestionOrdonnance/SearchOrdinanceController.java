package pt4p1ae1.veto.GestionOrdonnance;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the controller of rechercheOrdonnance.fxml
 */
public class SearchOrdinanceController extends ControllerSample implements Initializable {
    @FXML
    public TableView<OrdinanceEntityObservable> tableViewOrdinance;
    public TableColumn<OrdinanceEntityObservable, String> nameAnimal;
    public TableColumn<OrdinanceEntityObservable, String> nameClient;
    public TableColumn<OrdinanceEntityObservable, String> dateOrdonnance;
    public TableColumn<OrdinanceEntityObservable, String> veterinaire;

    @FXML
    public TextField nameClientField;
    public TextField nameAnimalField;
    public Button createOrdinance;
    public Button generateOrdinance;
    public Label errorMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nameAnimal"));
        nameClient.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        dateOrdonnance.setCellValueFactory(new PropertyValueFactory<>("dateOrdonnance"));
        veterinaire.setCellValueFactory(new PropertyValueFactory<>("veterinaire"));

        ObservableList<OrdinanceEntityObservable> observableList = FXCollections.observableArrayList();

        for (OrdonnanceEntity ordonnanceEntity : Utils.ORDONNANCE_DAO.findAll())
            observableList.add(new OrdinanceEntityObservable(ordonnanceEntity));

        tableViewOrdinance.setItems(observableList);

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                nameAnimalField.setText("");
                errorMsg.setText("");
                ObservableList<OrdinanceEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameClientField.getText().equals("")) {
                    for (OrdinanceEntityObservable ordonnance : observableList)
                        if (ordonnance.getNameClient().contains(nameClientField.getText()))
                            observableTmpList.add(ordonnance);
                    tableViewOrdinance.setItems(observableTmpList);
                } else
                    tableViewOrdinance.setItems(observableList);
            }
        });

        nameAnimalField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                nameClientField.setText("");
                errorMsg.setText("");
                ObservableList<OrdinanceEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameAnimalField.getText().equals("")) {
                    for (OrdinanceEntityObservable ordonnance : observableList)
                        if (ordonnance.getNameAnimal().contains(nameAnimalField.getText()))
                            observableTmpList.add(ordonnance);
                    tableViewOrdinance.setItems(observableTmpList);
                } else
                    tableViewOrdinance.setItems(observableList);
            }
        });

    }

    /**
     * This method is an onClicked method which permit to change to pageOrdonnance scene
     *
     * @throws IOException fxmlBug
     */
    public void createOrdinanceView() throws IOException {
        Stage primaryStage = (Stage) createOrdinance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pageOrdonnance.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
    }


    /**
     * This method is an onClicked method which permit to create a PDF with the selected ordinance of tableViewOrdinance
     */
    public void generateOrdonnance() {
        try {
            OrdonnanceEntity ord = tableViewOrdinance.getSelectionModel().getSelectedItem().getOrdonnance();
            OrdonnanceController.printOrdinanceToPDF(ord);
            System.out.println(ord.getAnimalByIdAnimal().getNom() + " " + ord.getDateOrdonnance());
            errorMsg.setTextFill(Color.GREEN);
            errorMsg.setText("L'ordonnance à bien été regénérée");
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                errorMsg.setTextFill(Color.RED);
                errorMsg.setText("Selectionnez une ordonnance");
            } else
                System.out.println(e.getMessage());
        }
    }
}
