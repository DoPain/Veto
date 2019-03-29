package pt4p1ae1.veto.GestionOrdonnance;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionStock.ProduitEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * This class is the controller of pageOrdonnance.fxml
 */
public class OrdonnanceController extends ControllerSample implements Initializable {

    @FXML
    public Label ordMsg;
    public TextField nameClientField;
    public TextField description;
    public AnchorPane editMode;

    @FXML
    public TableView<AnimalEntityObservable> tableViewAnimal;
    public TableColumn<AnimalEntityObservable, String> nameAnimal;
    public TableColumn<AnimalEntityObservable, String> specieAnimal;
    public TableColumn<AnimalEntityObservable, String> raceAnimal;
    public TableColumn<AnimalEntityObservable, String> clientNameAnimal;

    @FXML
    public TableView<ProduitEntityObservable> tableViewP;
    public TableColumn<ProduitEntityObservable, String> refP;
    public TableColumn<ProduitEntityObservable, String> nameP;
    public TableColumn<ProduitEntityObservable, String> price;
    public TableColumn<ProduitEntityObservable, String> quantity;

    @FXML
    public TableView<PrescriptionObservable> tableViewPrescriptions;
    public TableColumn<PrescriptionObservable, String> comment;
    public TableColumn<PrescriptionObservable, String> productName;

    private ObservableList<AnimalEntityObservable> animalEntityObservables = FXCollections.observableArrayList();
    private ObservableList<ProduitEntityObservable> productEntityObservables = FXCollections.observableArrayList();
    private ObservableList<PrescriptionObservable> prescriptionObservables = FXCollections.observableArrayList();
    private HashMap<ProduitEntityObservable, String> prescriptions = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        setAnimalsTable();
        setProductTable();

        description.setOnMouseClicked(e -> ordMsg.setText(""));
        tableViewP.setOnMouseClicked(e -> ordMsg.setText(""));

        description.setOnKeyPressed(e -> {
            ordMsg.setText("");
            if (e.getCode() == KeyCode.ENTER) {
                createPrescription();
            }
        });

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                ordMsg.setText("");
                ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameClientField.getText().equals("")) {
                    for (AnimalEntityObservable animal : animalEntityObservables)
                        if (animal.getProprietaire().toLowerCase().contains(nameClientField.getText().toLowerCase()))
                            observableTmpList.add(animal);
                    tableViewAnimal.setItems(observableTmpList);
                } else
                    tableViewAnimal.setItems(animalEntityObservables);
                ordMsg.setText("");
            }
        });
    }


    /**
     * This method add to tableViewP all items displayed
     */
    private void setProductTable() {

        nameP.setCellValueFactory(new PropertyValueFactory<>("nom"));
        price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        refP.setCellValueFactory(new PropertyValueFactory<>("reference"));
        for (ProduitEntity produit : Utils.PRODUIT_DAO.findAll())
            productEntityObservables.add(new ProduitEntityObservable(produit));
        tableViewP.setItems(productEntityObservables);
    }

    /**
     * This method add to tableViewAnimal all items displayed
     */
    private void setAnimalsTable() {

        this.nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.specieAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        this.raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));
        this.clientNameAnimal.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));

        for (AnimalEntity animal : Utils.ANIMAL_DAO.findAll())
            animalEntityObservables.add(new AnimalEntityObservable(animal));

        tableViewAnimal.setItems(animalEntityObservables);
    }

    /**
     * This method create an Ordinance object and add it to DataBase
     */
    public void createOrdinance() {
        Date dateToday = new Date();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        try {
            AnimalEntityObservable animal = tableViewAnimal.getSelectionModel().getSelectedItem();

            OrdonnanceEntity ord = new OrdonnanceEntity();
            ord.setIdVeterinaire(veterinaire.getId());
            ord.setIdAnimal(animal.getId());
            ord.setVeterinaireByIdVeterinaire(veterinaire);
            ord.setAnimalByIdAnimal(animal.getAnimalEntity());
            ord.setDateOrdonnance(new java.sql.Date(dateToday.getTime()));
            ArrayList<AppartenirEntity> entities = new ArrayList<>();
            Utils.ORDONNANCE_DAO.saveOrUpdate(ord);
            long idOrdonnance = 0;
            for (OrdonnanceEntity o : Utils.ORDONNANCE_DAO.findAll())
                idOrdonnance = o.getId();
            for (ProduitEntityObservable p : prescriptions.keySet()) {
                AppartenirEntity a = new AppartenirEntity();
                for (ProduitEntity prd : Utils.PRODUIT_DAO.findAll())
                    if (p.toProduitEntity().getRefProduit().equals(prd.getRefProduit()))
                        a.setIdProduit(prd.getId());
                a.setIdOrdonnance(idOrdonnance);
                a.setIdProduit(p.toProduitEntity().getId());
                a.setQuantite(1);
                a.setDescription(prescriptions.get(p));
                entities.add(a);
                Utils.APPARTENIR_DAO.saveOrUpdate(a);
            }

            ord.setAppartenirsById(entities);
            printOrdinanceToPDF(ord);
            tableViewAnimal.getSelectionModel().select(null);
            ordMsg.setTextFill(Color.GREEN);
            ordMsg.setText("L'ordonnance à bien été crée");
            prescriptions.clear();
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordMsg.setTextFill(Color.RED);
                ordMsg.setText("Selectionnez un animal");
                System.out.println(e.getMessage());
            } else {
                ordMsg.setTextFill(Color.RED);
                ordMsg.setText("Erreur lors de la création du PDF");
            }
        }

    }

    /**
     * This method create a description of the selected Product
     */
    public void createPrescription() {
        try {
            ProduitEntityObservable product = tableViewP.getSelectionModel().getSelectedItem();
            prescriptions.put(product, description.getText());
            description.setText("");
            ordMsg.setTextFill(Color.GREEN);
            ordMsg.setText("La prescriptions à été enregistré");
            tableViewP.getSelectionModel().select(null);
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordMsg.setTextFill(Color.RED);
                ordMsg.setText("Selectionnez un produit");
            }
        }
    }


    /**
     * This method is an onClicked method which permit user to display PrescriptionTable
     */
    public void editModeDisplay() {
        setPrescriptionTable();
        editMode.setVisible(true);
    }

    /**
     * This method is an onClicked method which permit user to hide PrescriptionTable
     */
    public void editModeHide() {
        editMode.setVisible(false);
    }

    private void setPrescriptionTable() {
        prescriptionObservables.clear();
        this.productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        this.comment.setCellValueFactory(new PropertyValueFactory<>("description"));
        for (ProduitEntityObservable p : prescriptions.keySet()) {
            prescriptionObservables.add(new PrescriptionObservable(p, prescriptions.get(p)));
            tableViewPrescriptions.setItems(prescriptionObservables);
        }
    }

    /**
     * This method is an onClicked method which permit user to delete a selected prescription
     */
    public void deletePrescription() {
        if (null != tableViewPrescriptions.getSelectionModel().getSelectedItem()) {
            prescriptions.remove(tableViewPrescriptions.getSelectionModel().getSelectedItem().getProduitEntityObservable());
            tableViewPrescriptions.getSelectionModel().select(null);
            setPrescriptionTable();
        }
    }

    /**
     * This method permit to print an ordinance into PDF file
     *
     * @param ord the ordinance created
     * @throws FileNotFoundException if the file could'nt been created
     * @throws DocumentException     if the document could'nt been create
     */
    static void printOrdinanceToPDF(OrdonnanceEntity ord) throws FileNotFoundException, DocumentException {
        long idOrdinance = 0;
        for (OrdonnanceEntity o : Utils.ORDONNANCE_DAO.findAll())
            idOrdinance = o.getId();

        Date dateToday = new Date();
        String dateFormatUser = new SimpleDateFormat("dd/MM/yyyy").format(dateToday);
        EmployeEntity actualUser = Utils.getActualEmploye();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        AnimalEntityObservable animal = new AnimalEntityObservable(ord.getAnimalByIdAnimal());

        Document document = new Document();
        FileOutputStream file = new FileOutputStream(new SimpleDateFormat("yyyy.MM.dd").format(dateToday)
                + "." + animal.getNom() + ".pdf");
        PdfWriter.getInstance(document, file);
        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);

        StringBuilder content = new StringBuilder();
        content.append("Pour ").append(animal.getNom()).append(", ").append(animal.getEspece()).append(", ").append(animal.getAge()).append(" :\n");
        for (AppartenirEntity a : Utils.APPARTENIR_DAO.findAll()) {
            if (a.getIdOrdonnance() == idOrdinance)
                for (ProduitEntity p : Utils.PRODUIT_DAO.findAll())
                    if (a.getIdProduit() == p.getId())
                        content.append("     - ").append(p.getNom()).append(" :").append(" ").append(a.getDescription()).append("\n");
        }

        document.open();
        document.addTitle("Ordonnance");
        document.addAuthor(actualUser.getPersonneById().getNom() + " " + actualUser.getPersonneById().getPrenom());
        String header = dateFormatUser + "\nDocteur " + veterinaire.getPersonneById().getPrenom() + " " + veterinaire.getPersonneById().getNom() +
                "\n" + veterinaire.getPersonneById().getAdresse() +
                "\n" + veterinaire.getPersonneById().getTelephone() +
                "\n" + veterinaire.getPersonneById().getMail() + "\n\n\n\n\n";
        document.add(new Paragraph(new Chunk(header, font)));
        document.left(1000);
        document.add(new Paragraph(new Chunk(content.toString(), font)));
        document.close();

    }
}