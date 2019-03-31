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
import java.time.LocalDate;
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
    public DatePicker birthDateEmp;
    @FXML
    public TextField phoneEmp;
    @FXML
    public TextField emailEmp;
    @FXML
    public TextField addressEmp;
    @FXML
    public DatePicker startContractEmp;
    @FXML
    public DatePicker endContractEmp;
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

    /**
     * Fonction qui permet de retourner à la page de recherche d'un employé
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    private void retourEmp(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/rechercheEmployes.fxml", (Stage) backToEmp.getScene().getWindow());
    }

    /**
     * Fonction qui permet d'ajouter un client à la base de donnée
     * @param actionEvent
     * @throws ParseException
     */
    @FXML
    private void ajouterEmp(ActionEvent actionEvent) throws ParseException {
        List<VilleEntity> villes = Utils.VILLE_DAO.findAll();

        if(!nameEmp.getText().equals("") && !firstNameEmp.getText().equals("") && birthDateEmp.getValue() != null && !phoneEmp.getText().equals("") && !emailEmp.getText().equals("")
                && !addressEmp.getText().equals("") && startContractEmp.getValue()!=null && endContractEmp.getValue() != null && !salaryEmp.getText().equals("")
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

            LocalDate localDateB = birthDateEmp.getValue();
            LocalDate localDateD = startContractEmp.getValue();
            LocalDate localDateF = endContractEmp.getValue();
            java.sql.Date sqlDateB = java.sql.Date.valueOf(localDateB);
            java.sql.Date sqlDateD = java.sql.Date.valueOf(localDateD);
            java.sql.Date sqlDateF = java.sql.Date.valueOf(localDateF);

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
                emp.setDateDebutContrat(sqlDateD);
                emp.setDateFinContrat(sqlDateF);
                emp.setId(person.getId());
                emp.setSalaire(Double.parseDouble(salaryEmp.getText()));
                emp.setLogin(loginEmp.getText());
                emp.setMotDePasse(mdpEmp.getText());
                emp.setTypeContrat(typeContrat.getText());

                Utils.EMPLOYE_DAO.saveOrUpdate(emp);
                Utils.createLog("Inscription Employé : " + emp.getPersonneById().getNom());
            }
    }
}
