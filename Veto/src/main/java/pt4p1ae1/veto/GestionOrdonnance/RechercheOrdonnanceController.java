package pt4p1ae1.veto.GestionOrdonnance;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionStock.ProduitEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class RechercheOrdonnanceController extends ControllerSample implements Initializable {
    public TextField nameClientField;
    public TextField nameAnimalField;
    public TableView<OrdonnanceEntityObservable> tableViewOrdonnace;
    public TableColumn<OrdonnanceEntityObservable, String> nameAnimal;
    public TableColumn<OrdonnanceEntityObservable, String> nameClient;
    public TableColumn<OrdonnanceEntityObservable, String> dateOrdonnance;
    public TableColumn<OrdonnanceEntityObservable, String> veterinaire;
    public Button createOrdonnance;
    public Label errorMsg;
    public Button generateOrdonnance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nameAnimal"));
        nameClient.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        dateOrdonnance.setCellValueFactory(new PropertyValueFactory<>("dateOrdonnance"));
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
        Stage primaryStage = (Stage) createOrdonnance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pageOrdonnance.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
    }

    public void generateOrdonnance() {
        EmployeEntity actualUser = Utils.getActualEmploye();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        try {
            OrdonnanceEntity ord = tableViewOrdonnace.getSelectionModel().getSelectedItem().getOrdonnance();
            OrdonnanceController.createOrdonnancePDF(ord);
            System.out.println(ord.getAnimalByIdAnimal().getNom() + " " + ord.getDateOrdonnance());
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                errorMsg.setTextFill(Color.RED);
                errorMsg.setText("Selectionnez une ordonnance");
            }
            else
                System.out.println(e.getMessage());
        }
    }
}
