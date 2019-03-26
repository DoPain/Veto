package pt4p1ae1.veto.GestionEmploye;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.PersonneEntity;

import pt4p1ae1.veto.Entity.VilleEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class InscriptionEmployeController extends ControllerSample implements Initializable {

    @FXML
    public Button backToEmp;
    @FXML
    public TextField nameEmp;
    @FXML
    public TextField firstNameEmp;
    @FXML
    public TextField birthDateEmp;
    @FXML
    public TextField phoneEmp;
    @FXML
    public TextField emailEmp;
    @FXML
    public TextField addressEmp;
    @FXML
    public TextField startContractEmp;
    @FXML
    public TextField endContractEmp;
    @FXML
    public TextField salaryEmp;
    @FXML
    public TextField loginEmp;
    @FXML
    public TextField mdpEmp;
    @FXML
    public TextField villeEmp;
    @FXML
    public TextField typeContrat;
    @FXML
    public Label error;

    @FXML
    private void retourEmp(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/rechercheEmployes.fxml", (Stage) backToEmp.getScene().getWindow());
    }

    @FXML
    private void ajouterEmp(ActionEvent actionEvent) throws ParseException {
        List<VilleEntity> villes = Utils.VILLE_DAO.findAll();

        if(!nameEmp.getText().equals("") && !firstNameEmp.getText().equals("") && !birthDateEmp.getText().equals("") && !phoneEmp.getText().equals("") && !emailEmp.getText().equals("")
                && !addressEmp.getText().equals("") && !startContractEmp.getText().equals("") && !endContractEmp.getText().equals("") && !salaryEmp.getText().equals("")
                && !mdpEmp.getText().equals("") && !loginEmp.getText().equals("") && !typeContrat.getText().equals("")){

                EmployeEntity emp = new EmployeEntity();
                PersonneEntity person = new PersonneEntity();

            for (VilleEntity v: villes
                 ) {
                if (v.getVilleNom().equals(villeEmp.getText().toUpperCase())){
                    person.setVilleByIdVille(v);
                    person.setIdVille(v.getId());
                }

            }

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                Date dateB = formatter.parse(birthDateEmp.getText());
                Date dateD = formatter.parse(startContractEmp.getText());
                Date dateF = formatter.parse(endContractEmp.getText());
                java.sql.Date sqlDateB = new java.sql.Date(dateB.getTime());
                java.sql.Date sqlDateD = new java.sql.Date(dateD.getTime());
                java.sql.Date sqlDateF = new java.sql.Date(dateF.getTime());
                emp.setDateDebutContrat(sqlDateD);
                emp.setDateFinContrat(sqlDateF);

                person.setNom(nameEmp.getText());
                person.setPrenom(firstNameEmp.getText());
                person.setTelephone(phoneEmp.getText());
                person.setMail(emailEmp.getText());
                person.setAdresse(addressEmp.getText());
                person.setDateNaissance(sqlDateB);
                Utils.PERSONNE_DAO.saveOrUpdate(person);

                List<PersonneEntity> allP = Utils.PERSONNE_DAO.findAll();
                for(PersonneEntity p : allP) {
                    if (p.getNom().equals(person.getNom()) && p.getPrenom().equals(person.getPrenom())) {
                        person.setId(p.getId());
                    }
                }
                emp.setId(person.getId());
                emp.setSalaire(Double.parseDouble(salaryEmp.getText()));
                emp.setLogin(loginEmp.getText());
                emp.setMotDePasse(mdpEmp.getText());
                emp.setTypeContrat(typeContrat.getText());

                Utils.EMPLOYE_DAO.saveOrUpdate(emp);
            }
    }
}
