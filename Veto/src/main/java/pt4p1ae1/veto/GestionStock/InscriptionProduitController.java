package pt4p1ae1.veto.GestionStock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private TextField description;
    @FXML
    private TextField nbInsertion;
    @FXML
    private TextField dateAcquisition;
    @FXML
    private TextField datePeremption;
    @FXML
    private TextField minQuantite;
    @FXML
    private Button register;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    public void retourProduits(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/pageStock.fxml", (Stage) backToProducts.getScene().getWindow());
    }

    @FXML
    private void ajouterProduit(ActionEvent actionEvent) throws ParseException {
        Boolean found = false;
        int i = 0;
        if(nom.getText() != "" && minQuantite.getText() != "" && reference.getText() != "" && prix.getText() != "" && nbInsertion.getText() != "" && dateAcquisition.getAccessibleText() != "" && datePeremption.getAccessibleText() != ""){
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
                Date dateP = formatter.parse(datePeremption.getText());
                Date dateA = formatter.parse(dateAcquisition.getText());
                java.sql.Date sqlDateA = new java.sql.Date(dateA.getTime());
                java.sql.Date sqlDateP = new java.sql.Date(dateP.getTime());
                newProduit.setDateAcquisition(sqlDateA);
                newProduit.setPeremption(sqlDateP);
                Utils.PRODUIT_DAO.saveOrUpdate(newProduit);
            }
        }
    }
}
