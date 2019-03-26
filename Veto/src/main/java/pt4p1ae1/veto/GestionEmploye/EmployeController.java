package pt4p1ae1.veto.GestionEmploye;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.VilleEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class EmployeController extends ControllerSample implements Initializable {

    @FXML
    private Button backToEmp;

    private EmployeEntity currEmp;

    @FXML
    private TextField nomEmp;
    @FXML
    private TextField prenomEmp;
    @FXML
    private TextField dateNaiss;
    @FXML
    private TextField telEmp;
    @FXML
    private TextField mailEmp;
    @FXML
    private TextField addrEmp;
    @FXML
    private TextField villeEmp;
    @FXML
    private TextField typeContrat;
    @FXML
    private TextField dateD;
    @FXML
    private TextField dateF;
    @FXML
    private TextField salaireEmp;
    @FXML
    private TextField loginEmp;
    @FXML
    private TextField pwdEmp;

    @FXML
    private Button empModifyBtn;

    @FXML
    private Label error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        currEmp = Utils.getActualEmploye();
        nomEmp.setText(currEmp.getPersonneById().getNom());
        prenomEmp.setText(currEmp.getPersonneById().getPrenom());
        dateNaiss.setText(currEmp.getPersonneById().getDateNaissance().toString());
        telEmp.setText(currEmp.getPersonneById().getTelephone());
        mailEmp.setText(currEmp.getPersonneById().getMail());
        addrEmp.setText(currEmp.getPersonneById().getAdresse());
        villeEmp.setText(currEmp.getPersonneById().getVilleByIdVille().getVilleNom());
        typeContrat.setText(currEmp.getTypeContrat());
        dateD.setText(currEmp.getDateDebutContrat().toString());
        dateF.setText((currEmp.getDateFinContrat() == null) ? "" : currEmp.getDateFinContrat().toString());
        salaireEmp.setText(currEmp.getSalaire().toString());
        loginEmp.setText(currEmp.getLogin());
        pwdEmp.setText(currEmp.getMotDePasse());
    }


    @FXML
    private void retourEmploye(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) backToEmp.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rechercheEmployes.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    @FXML
    private void modifierEmp() throws ParseException, IOException {
        List<VilleEntity> villes = Utils.VILLE_DAO.findAll();

        if(!nomEmp.getText().equals("")
                && !prenomEmp.getText().equals("")
                && !dateNaiss.getText().equals("")
                && !telEmp.getText().equals("")
                && !mailEmp.getText().equals("")
                && !addrEmp.getText().equals("")
                && !villeEmp.getText().equals("")
                && !dateD.getText().equals("")
                && !typeContrat.getText().equals("")
                && !salaireEmp.getText().equals("")
                && !loginEmp.getText().equals("")
                && !pwdEmp.getText().equals("")){
            currEmp.getPersonneById().setNom(nomEmp.getText());
            currEmp.getPersonneById().setPrenom(prenomEmp.getText());
            currEmp.getPersonneById().setTelephone(telEmp.getText());
            currEmp.getPersonneById().setMail(mailEmp.getText());
            currEmp.getPersonneById().setAdresse(addrEmp.getText());
            currEmp.setTypeContrat(typeContrat.getText());
            currEmp.setSalaire(Double.valueOf(salaireEmp.getText()));
            currEmp.setLogin(loginEmp.getText());
            currEmp.setMotDePasse(pwdEmp.getText());


            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
            Date dateDebut = formatter.parse(dateD.getText());
            java.sql.Date sqlDateD = new java.sql.Date(dateDebut.getTime());
            currEmp.setDateDebutContrat(sqlDateD);

            if(!dateF.getText().equals("")){
                Date dateFin = formatter.parse(dateF.getText());
                java.sql.Date sqlDateF = new java.sql.Date(dateFin.getTime());
                currEmp.setDateFinContrat(sqlDateF);
            }

            for (VilleEntity v: villes
            ) {
                if (v.getVilleNom().equals(villeEmp.getText().toUpperCase())){
                    currEmp.getPersonneById().setVilleByIdVille(v);
                    currEmp.getPersonneById().setIdVille(v.getId());
                }

            }

            Utils.EMPLOYE_DAO.saveOrUpdate(currEmp);
            Utils.PERSONNE_DAO.saveOrUpdate(currEmp.getPersonneById());
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Information(s) manquante(s)");
        }
        super.creatBtn("/fxml/rechercheEmployes.fxml", (Stage) empModifyBtn.getScene().getWindow());
    }

}
