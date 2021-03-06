package pt4p1ae1.veto.GestionStock;

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
import pt4p1ae1.veto.Entity.ProduitEntity;
import pt4p1ae1.veto.GestionClient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RechecheProduitController extends ControllerSample implements Initializable {

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
    @FXML
    private Button deleteBtn;
    @FXML
    private Button ruptureBtn;
    @FXML
    private Button modifierBtn;
    @FXML
    private Button filtrer;
    @FXML
    private Label error;
    @FXML
    private TextField quantiteSupp;

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
                ObservableList<ProduitEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!referenceF.getText().equals("")) {
                    for (ProduitEntityObservable produit : observables)
                        if (produit.getReference().contains(referenceF.getText()))
                            observableTmpList.add(produit);
                    tableViewProduit.setItems(observableTmpList);
                } else
                    tableViewProduit.setItems(observables);
            }
        });

        nomF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
               filtrerProduits();
            }
        });

        prixF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerProduits();
            }
        });

        dateAcquisitionF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerProduits();
            }
        });

        datePeremptionF.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerProduits();
            }
        });

        tableViewProduit.setRowFactory(tv -> {
            TableRow<ProduitEntityObservable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    ProduitEntityObservable produit = row.getItem();
                    Utils.setCurrentProduit(produit.toProduitEntity());
                    try {
                        super.creatBtn("/fxml/dossierProduit.fxml", (Stage) tableViewProduit.getScene().getWindow());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });


    }

    /**
     * Redirige vers la page d'inscription d'un produit si un clic sur le boutton en question est effectué
     *
     * @param actionEvent clic sur le boutton
     * @throws IOException si l'application ne trouve pas la page
     */
    @FXML
    private void insertionProduit(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/inscriptionProduit.fxml", (Stage) insertBtn.getScene().getWindow());
    }

    /**
     * Permet le chargement de tous les produits présents dans la base de données
     *
     */
    private void loadProduits() {
        this.observables.clear();
        List<ProduitEntity> produits = Utils.PRODUIT_DAO.findAll();
        for (ProduitEntity produit : produits) {
            ProduitEntityObservable p = new ProduitEntityObservable(produit);
            observables.add(p);
        }
        tableViewProduit.setItems(observables);
    }

    /**
     * Permet l'affichage de tous les produits bientôt en rupture de stock
     *
     */
    @FXML
    private void ruptureProduit() {
        if (ruptureBtn.getText().equals("Afficher les produits bientôt en rupture de stock")) {
            ruptureBtn.setText("Afficher liste complète");
            ObservableList<ProduitEntityObservable> observableTmpList = FXCollections.observableArrayList();
            for (ProduitEntityObservable produit : observables) {
                if (produit.getQuantiteStock() <= produit.getQuantiteMin()) {
                    observableTmpList.add(produit);
                }
            }
            tableViewProduit.setItems(observableTmpList);
        } else {
            ruptureBtn.setText("Afficher les produits bientôt en rupture de stock");
            tableViewProduit.setItems(observables);
        }
    }

    /**
     * Permet la suppression du produit sélectionné si un clic sur le boutton en question est effectué
     *
     * @param actionEvent clic sur le boutton
     * @throws IOException si l'application ne trouve pas la page
     */
    @FXML
    private void supprimerProduit(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();

        if(Utils.getConfirmation()) {
            if (tableViewProduit.getSelectionModel().getSelectedItem() != null && !quantiteSupp.getText().equals("")) {
                ProduitEntityObservable selectedProduit = tableViewProduit.getSelectionModel().getSelectedItem();
                ProduitEntity produit = selectedProduit.toProduitEntity();
                if (produit.getQuantiteEnStock() - Integer.valueOf(quantiteSupp.getText()) >= 0) {
                    Utils.createLog("Suppression de " + quantiteSupp.getText() + " " + produit.getNom());
                    produit.setQuantiteEnStock(produit.getQuantiteEnStock() - Integer.valueOf(quantiteSupp.getText()));
                    Utils.PRODUIT_DAO.saveOrUpdate(produit);
                    loadProduits();
                    quantiteSupp.setText("");
                } else if (produit.getQuantiteEnStock() == 0) {
                    Utils.createLog("Suppression de : "+ produit.getNom());
                    Utils.PRODUIT_DAO.delete(produit);
                    loadProduits();
                    quantiteSupp.setText("");
                } else {
                    Utils.createLog("Suppression de " + quantiteSupp.getText() + " " + produit.getNom());
                    produit.setQuantiteEnStock(0);
                    Utils.PRODUIT_DAO.saveOrUpdate(produit);
                    loadProduits();
                    quantiteSupp.setText("");
                }
            } else {
                error.setStyle("-fx-text-fill: red");
                error.setText("Aucun produit selectionné ou quantité vide");
            }
        }

    }

    /**
     * Redirige vers la page de modification d'un produit ( ici le produit est celui sélectionné )
     *
     * @throws IOException si l'application ne trouve pas la page
     */
    @FXML
    private void modifierProduit() throws IOException {
        if (tableViewProduit.getSelectionModel().getSelectedItem() != null) {
            ProduitEntityObservable selectedProduit = tableViewProduit.getSelectionModel().getSelectedItem();
            ProduitEntity produit = selectedProduit.toProduitEntity();
            Utils.setCurrentProduit(produit);
            super.creatBtn("/fxml/dossierProduit.fxml", (Stage) modifierBtn.getScene().getWindow());
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun produit selectionné");
        }
    }

    /**
     * Permet le filtrage des produits selon le nom, le prix, la réference, la date d'acquisition et la date de péremption
     *
     */
    @FXML
    private void filtrerProduits(){
        Boolean ajout = false;
        ObservableList<ProduitEntityObservable> observableTmpList = FXCollections.observableArrayList();
        ObservableList<ProduitEntityObservable> observableTmpListCopy = FXCollections.observableArrayList();
        if(!nomF.getText().equals("")){
                ajout = true;
                for (ProduitEntityObservable produit : observables) {
                    if (produit.getNom().contains(nomF.getText())) {
                        observableTmpList.add(produit);
                    }
                }
                observableTmpListCopy.addAll(observableTmpList);
        }

        if(!referenceF.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (ProduitEntityObservable produit : observables) {
                    if (produit.getReference().contains(referenceF.getText())) {
                        observableTmpList.add(produit);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(ProduitEntityObservable produitT : observableTmpListCopy){
                    if(!produitT.getReference().contains(referenceF.getText())){
                        observableTmpList.remove(produitT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!prixF.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (ProduitEntityObservable produit : observables) {
                    if (produit.getPrix().toString().contains(prixF.getText())) {
                        observableTmpList.add(produit);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(ProduitEntityObservable produitT : observableTmpListCopy){
                    if(!produitT.getPrix().toString().contains(prixF.getText())){
                        observableTmpList.remove(produitT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!dateAcquisitionF.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (ProduitEntityObservable produit : observables) {
                    if (produit.getDateAcquisition().toString().contains(dateAcquisitionF.getText())) {
                        observableTmpList.add(produit);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(ProduitEntityObservable produitT : observableTmpListCopy){
                    if (!produitT.getDateAcquisition().toString().contains(dateAcquisitionF.getText())){
                        observableTmpList.remove(produitT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!datePeremptionF.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (ProduitEntityObservable produit : observables) {
                    if (produit.getPeremption().toString().contains(datePeremptionF.getText())) {
                        observableTmpList.add(produit);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(ProduitEntityObservable produitT : observableTmpListCopy){
                    if (!produitT.getPeremption().toString().contains(datePeremptionF.getText())){
                        observableTmpList.remove(produitT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!ajout){
            tableViewProduit.setItems(observables);
        } else {
            tableViewProduit.setItems(observableTmpList);
        }

    }


    }



