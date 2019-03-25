package pt4p1ae1.veto.GestionStock;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ProduitEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class dossierProduitController extends ControllerSample implements Initializable {

    @FXML
    private Button backToProducts;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField reference;
    @FXML
    private TextField quantite;
    @FXML
    private TextField quantiteMin;
    @FXML
    private TextField dateAcquisition;
    @FXML
    private TextField datePeremption;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TextArea description;
    @FXML
    private Label error;

    private ProduitEntity currentProduit;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        currentProduit = Utils.getCurrentProduit();
        nom.setText(currentProduit.getNom());
        prix.setText(String.valueOf(currentProduit.getPrix()));
        reference.setText(currentProduit.getRefProduit());
        quantite.setText(String.valueOf(currentProduit.getQuantiteEnStock()));
        quantiteMin.setText(String.valueOf(currentProduit.getQuantiteMinimum()));
        dateAcquisition.setText(currentProduit.getDateAcquisition().toString());
        datePeremption.setText(currentProduit.getPeremption().toString());
        description.setText(currentProduit.getDescription());

    }

    public void retourProduits(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/rechercheProduit.fxml", (Stage) backToProducts.getScene().getWindow());
    }

    @FXML
    private void modifierProduit() throws ParseException {
        if(!nom.getText().equals("") && !prix.getText().equals("") && !quantite.getText().equals("") && !quantiteMin.getText().equals("") && !reference.getText().equals("") && !datePeremption.getText().equals("") && !dateAcquisition.getText().equals("")) {
            currentProduit.setRefProduit(reference.getText());
            currentProduit.setDescription(description.getText());
            currentProduit.setPrix(Double.parseDouble(prix.getText()));
            currentProduit.setNom(nom.getText());
            currentProduit.setQuantiteMinimum(Integer.parseInt(quantiteMin.getText()));
            currentProduit.setQuantiteEnStock(Integer.parseInt(quantite.getText()));
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
            Date dateP = formatter.parse(datePeremption.getText());
            Date dateA = formatter.parse(dateAcquisition.getText());
            java.sql.Date sqlDateA = new java.sql.Date(dateA.getTime());
            java.sql.Date sqlDateP = new java.sql.Date(dateP.getTime());
            currentProduit.setDateAcquisition(sqlDateA);
            currentProduit.setPeremption(sqlDateP);
            Utils.PRODUIT_DAO.saveOrUpdate(currentProduit);
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Information(s) manquante(s)");
        }
    }

    @FXML
    private void supprimerProduit() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();

        if(Utils.getConfirmation()) {
            Utils.PRODUIT_DAO.delete(currentProduit);
            super.creatBtn("/fxml/rechercheProduit.fxml", (Stage) supprimer.getScene().getWindow());
        }
    }

    public void display(){

    }

}
