package pt4p1ae1.veto.GestionStock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ProduitEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class InscriptionProduitController extends ControllerSample implements Initializable {

    @FXML
    private Button backToProducts;
    @FXML
    private TextField nom;
    @FXML
    private TextField reference;
    @FXML
    private TextField prix;
    @FXML
    private TextArea description;
    @FXML
    private TextField nbInsertion;
    @FXML
    private DatePicker dateAcquisition;
    @FXML
    private DatePicker datePeremption;
    @FXML
    private TextField minQuantite;
    @FXML
    private Label error;
    @FXML
    private Button register;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    public void retourProduits(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/rechercheProduit.fxml", (Stage) backToProducts.getScene().getWindow());
    }

    @FXML
    private void ajouterProduit(ActionEvent actionEvent){
        Boolean found = false;
        int i = 0;
        if(!nom.getText().equals("") && !minQuantite.getText().equals("") && !reference.getText().equals("") && !prix.getText().equals("") && !nbInsertion.getText().equals("") && dateAcquisition.getValue() != null && datePeremption.getValue() != null){
            List<ProduitEntity> produits = Utils.PRODUIT_DAO.findAll();
            while(!found && i<produits.size()){
                if(produits.get(i).getNom().equals(nom.getText())){
                    found = true;
                    produits.get(i).setQuantiteEnStock(produits.get(i).getQuantiteEnStock() + Integer.parseInt(nbInsertion.getText()));
                    Utils.PRODUIT_DAO.saveOrUpdate(produits.get(i));
                }
                i++;
            }

            if(!found){
                ProduitEntity newProduit = new ProduitEntity();
                newProduit.setQuantiteEnStock(Integer.parseInt(nbInsertion.getText()));
                newProduit.setNom(nom.getText());
                newProduit.setPrix(Double.parseDouble(prix.getText()));
                newProduit.setQuantiteMinimum(Integer.parseInt(minQuantite.getText()));
                newProduit.setDescription(description.getText());
                newProduit.setRefProduit(reference.getText());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy",Locale.FRANCE);

                LocalDate localDateAcqui = dateAcquisition.getValue();
                LocalDate localDatePer = datePeremption.getValue();
                java.sql.Date sqlDateA = java.sql.Date.valueOf(localDateAcqui);
                java.sql.Date sqlDateP = java.sql.Date.valueOf(localDatePer);
                newProduit.setDateAcquisition(sqlDateA);
                newProduit.setPeremption(sqlDateP);

                Utils.PRODUIT_DAO.saveOrUpdate(newProduit);
                Utils.createLog(newProduit.getNom() + " " + "added");
            }
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Information(s) manquante(s)");
        }
    }
}
