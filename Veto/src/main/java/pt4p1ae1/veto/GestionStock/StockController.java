package pt4p1ae1.veto.GestionStock;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ProduitEntity;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StockController extends ControllerSample implements Initializable {

    @FXML
    private TableColumn<ClientEntityObservable, String> nameC;
    @FXML
    private TableColumn<ClientEntityObservable, Double> prixC;
    @FXML
    private TableColumn<ClientEntityObservable, LocalDate> datePeremptionC;
    @FXML
    private TableColumn<ClientEntityObservable, LocalDate> dateAcquisitionC;
    @FXML
    private TableColumn<ClientEntityObservable, Integer> quantiteC;
    @FXML
    private TableColumn<ClientEntityObservable, String> referenceC;
    @FXML
    private TableView<ProduitEntityObservable> tableViewProduit;

    private final ObservableList<ProduitEntityObservable> observables = FXCollections.observableArrayList();

    ObservableList<ProduitEntityObservable> observableTmpList = FXCollections.observableArrayList();
    @FXML
    private TextField referenceF;
    @FXML
    private TextField nomF;
    @FXML
    private TextField prixF;
    @FXML
    private TextField dateAcquisitionF;
    @FXML
    private TextField datePeremptionF;

    @FXML
    private Button insertBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nameC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateAcquisitionC.setCellValueFactory(new PropertyValueFactory<>("dateAcquisition"));
        datePeremptionC.setCellValueFactory(new PropertyValueFactory<>("peremption"));
        quantiteC.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        referenceC.setCellValueFactory(new PropertyValueFactory<>("reference"));

        loadProduits();

        referenceF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (!referenceF.getText().equals("")) {
                    for (ProduitEntityObservable produit : observables)
                        if (produit.getReference().contains(referenceF.getText()))
                            observableTmpList.add(produit);
                    tableViewProduit.setItems(observableTmpList);
                    observableTmpList.removeAll();
                } else
                    tableViewProduit.setItems(observables);
            }
        });

        nomF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (!nomF.getText().equals("")) {
                    for (ProduitEntityObservable produit : observables)
                        if (produit.getNom().contains(nomF.getText()))
                            observableTmpList.add(produit);
                    tableViewProduit.setItems(observableTmpList);
                    observableTmpList.removeAll();
                } else
                    tableViewProduit.setItems(observables);
            }
        });

        prixF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (!prixF.getText().equals("")) {
                    for (ProduitEntityObservable produit : observables)
                        if (produit.getPrix().equals(nomF.getText()))
                            observableTmpList.add(produit);
                    tableViewProduit.setItems(observableTmpList);
                    observableTmpList.removeAll();
                } else
                    tableViewProduit.setItems(observables);
            }
        });



    }

    @FXML
    private void insertionProduit(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/inscriptionProduit.fxml", (Stage) insertBtn.getScene().getWindow());
    }

    private void loadProduits() {
        this.observables.clear();
        List<ProduitEntity> produits = Utils.PRODUIT_ENTITY.findAll();
        for (ProduitEntity produit : produits) {
            ProduitEntityObservable p = new ProduitEntityObservable(produit);
            observables.add(p);
        }
        tableViewProduit.setItems(observables);
    }
}
