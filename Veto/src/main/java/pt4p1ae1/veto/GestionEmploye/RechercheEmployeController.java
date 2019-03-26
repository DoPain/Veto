package pt4p1ae1.veto.GestionEmploye;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class RechercheEmployeController extends ControllerSample implements Initializable {

    @FXML
    private TextField nomEmpField;
    @FXML
    private TextField prenomEmpField;
    @FXML
    private TextField telEmpField;
    @FXML
    private TextField typeContratEmp;
    @FXML
    private Label error;
    @FXML
    private Button filterButton;
    @FXML
    private Button insertEmpButton;
    @FXML
    private Button editEmpButton;
    @FXML
    private Button deleteEmpButton;
    @FXML
    private BorderPane borderPane;
    @FXML
    private TableColumn<EmployeEntityObservable, String> nomEmpColumn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> firstNameEmpColomn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> phoneEmpColomn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> emailEmpColomn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> typeContratEmpColomn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> debutContratEmpColomn;
    @FXML
    private TableColumn<EmployeEntityObservable, String> finContratEmpColomn;
    @FXML
    private TableView<EmployeEntityObservable> tableViewEmp;

    private final ObservableList<EmployeEntityObservable> observables = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        nomEmpColumn.setCellValueFactory(new PropertyValueFactory<>("nom")); // Le String représente le nom de l'attribut de l'observable.
        firstNameEmpColomn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        phoneEmpColomn.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        emailEmpColomn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        debutContratEmpColomn.setCellValueFactory(new PropertyValueFactory<>("dateDebutContrat"));
        finContratEmpColomn.setCellValueFactory(new PropertyValueFactory<>("dateFinContrat"));
        typeContratEmpColomn.setCellValueFactory(new PropertyValueFactory<>("typeContrat"));

        loadEmp();

        nomEmpField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerEmp();
            }
        });

        prenomEmpField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerEmp();
            }
        });

        telEmpField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
            filtrerEmp();
            }
        });

        typeContratEmp.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                filtrerEmp();
            }
        });


        tableViewEmp.setRowFactory(tv -> {
            TableRow<EmployeEntityObservable> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    EmployeEntityObservable emp = row.getItem();
                    Utils.setActualEmploye(emp.toEmpEntity());
                    try {
                        super.creatBtn("/fxml/dossierEmploye.fxml", (Stage) tableViewEmp.getScene().getWindow());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    @FXML
    private void insererEmploye(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/inscriptionEmploye.fxml", (Stage) insertEmpButton.getScene().getWindow());
    }

    @FXML
    private void modifierEmploye(ActionEvent actionEvent) throws IOException {
        if (tableViewEmp.getSelectionModel().getSelectedItem() != null) {
            EmployeEntityObservable selectedEmp = tableViewEmp.getSelectionModel().getSelectedItem();
            EmployeEntity emp = selectedEmp.toEmpEntity();
            Utils.setActualEmploye(emp);
            super.creatBtn("/fxml/dossierEmploye.fxml", (Stage) editEmpButton.getScene().getWindow());
        } else {
            error.setStyle("-fx-text-fill: red");
            error.setText("Aucun produit selectionné");
        }
    }

    @FXML
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

    @FXML
    private void filtrerEmp(){
        Boolean ajout = false;
        ObservableList<EmployeEntityObservable> observableTmpList = FXCollections.observableArrayList();
        ObservableList<EmployeEntityObservable> observableTmpListCopy = FXCollections.observableArrayList();

        if(!nomEmpField.getText().equals("")){
            ajout = true;
            for (EmployeEntityObservable emp : observables) {
                if (emp.getNom().contains(nomEmpField.getText())) {
                    observableTmpList.add(emp);
                }
            }
            observableTmpListCopy.addAll(observableTmpList);
        }

        if(!prenomEmpField.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (EmployeEntityObservable emp : observables) {
                    if (emp.getPrenom().contains(prenomEmpField.getText())) {
                        observableTmpList.add(emp);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(EmployeEntityObservable empT : observableTmpListCopy){
                    if(!empT.getPrenom().contains(prenomEmpField.getText())){
                        observableTmpList.remove(empT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!telEmpField.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (EmployeEntityObservable emp : observables) {
                    if (emp.getTel().contains(telEmpField.getText())) {
                        observableTmpList.add(emp);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(EmployeEntityObservable empT : observableTmpListCopy){
                    if(!empT.getTel().contains(telEmpField.getText())){
                        observableTmpList.remove(empT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!typeContratEmp.getText().equals("")){
            if(!ajout){
                ajout = true;
                for (EmployeEntityObservable emp : observables) {
                    if (emp.getTypeContrat().contains(typeContratEmp.getText())) {
                        observableTmpList.add(emp);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            } else {
                for(EmployeEntityObservable empT : observableTmpListCopy){
                    if(!empT.getTypeContrat().contains(typeContratEmp.getText())){
                        observableTmpList.remove(empT);
                    }
                }
                observableTmpListCopy.removeAll();
                observableTmpListCopy.addAll(observableTmpList);
            }
        }

        if(!ajout){
            tableViewEmp.setItems(observables);
        } else {
            tableViewEmp.setItems(observableTmpList);
        }

    }


}
