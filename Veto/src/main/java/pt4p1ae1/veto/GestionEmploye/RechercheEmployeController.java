package pt4p1ae1.veto.GestionEmploye;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class RechercheEmployeController extends ControllerSample implements Initializable {


    public TextField nomEmpField;
    public TextField prenomEmpField;
    public TextField telEmpField;

    public Label error;

    public ComboBox<EmployeEntityObservable> posteEmpComboBox;

    public Button filterButton;
    public Button insertEmpButton;
    public Button editEmpButton;
    public Button deleteEmpButton;

    public BorderPane borderPane;

    public TableColumn<EmployeEntityObservable, String> nomEmpColumn;
    public TableColumn<EmployeEntityObservable, String> firstNameEmpColomn;
    public TableColumn<EmployeEntityObservable, String> phoneEmpColomn;
    public TableColumn<EmployeEntityObservable, String> emailEmpColomn;
    public TableColumn<EmployeEntityObservable, String> posteEmpColomn;
    public TableColumn<EmployeEntityObservable, String> typeContratEmpColomn;
    public TableColumn<EmployeEntityObservable, String> debutContratEmpColomn;
    public TableColumn<EmployeEntityObservable, String> finContratEmpColomn;

    public TableView<EmployeEntityObservable> tableViewEmp;

    private final ObservableList<EmployeEntityObservable> observables = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nomEmpColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        firstNameEmpColomn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        phoneEmpColomn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        emailEmpColomn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        debutContratEmpColomn.setCellValueFactory(new PropertyValueFactory<>("dateDebutContrat"));

        loadEmp();

    }

    public void insererEmploye(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) insertEmpButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/inscriptionEmploye.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    public void modifierEmploye(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) editEmpButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dossierEmploye.fxml"));
        primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
        primaryStage.centerOnScreen();
    }

    private void loadEmp() {
        this.observables.clear();
        List<EmployeEntity> emps = Utils.EMPLOYE_DAO.findAll();
        for (EmployeEntity emp : emps) {
            EmployeEntityObservable e = new EmployeEntityObservable(emp);
            observables.add(e);
        }
        tableViewEmp.setItems(observables);
    }

    @FXML
    private void supprimerEmp(ActionEvent actionEvent) {
        if (tableViewEmp.getSelectionModel().getSelectedItem() != null) {
            EmployeEntityObservable selectedEmp = tableViewEmp.getSelectionModel().getSelectedItem();

            EmployeEntity emp = selectedEmp.toEmpEntity();
            Utils.createLog("Remove Employe : " + emp.getPersonneById().getNom() + " " + emp.getPersonneById().getPrenom());
            Utils.EMPLOYE_DAO.delete(emp);
            loadEmp();
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun client selectionné");
        }
    }

    public void filtrageRecherche(ActionEvent actionEvent) throws IOException{

        ObservableList<EmployeEntityObservable> observables = FXCollections.observableArrayList();
        List<EmployeEntity> emps = Utils.EMPLOYE_DAO.findAll();

        EmployeEntity emp1 = new EmployeEntity();

        if (nomEmpField == null){
            emp1.getPersonneById().setNom(nomEmpField.getText());
        }
        if (prenomEmpField == null){
            emp1.getPersonneById().setPrenom(prenomEmpField.getText());
        }
        if (telEmpField == null){
            emp1.getPersonneById().setTelephone(telEmpField.getText());
        }

        for (EmployeEntity emp : emps) {
            if((emp1.getPersonneById().getNom().equals(emp.getPersonneById().getNom()))
                    && (emp1.getPersonneById().getPrenom().equals(emp.getPersonneById().getPrenom()))
                    && emp1.getPersonneById().getTelephone().equals(emp.getPersonneById().getTelephone())){
                EmployeEntityObservable e = new EmployeEntityObservable(emp);
                observables.add(e);
            }
        }
        tableViewEmp.setItems(observables);
    }


}
