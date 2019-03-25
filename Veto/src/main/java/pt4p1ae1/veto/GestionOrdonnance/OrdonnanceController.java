package pt4p1ae1.veto.GestionOrdonnance;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import pt4p1ae1.veto.App;
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

public class OrdonnanceController extends ControllerSample implements Initializable {
    public Label ordonnanceMsg;
    public TextField nameClientField;
    public TextField posologie;
    public AnchorPane editMode;

    public TableView<AnimalEntityObservable> tableViewAnimal;
    public TableColumn<AnimalEntityObservable, String> nameAnimal;
    public TableColumn<AnimalEntityObservable, String> especeAnimal;
    public TableColumn<AnimalEntityObservable, String> raceAnimal;
    public TableColumn<AnimalEntityObservable, String> clientNameAnimal;

    public TableView<ProduitEntityObservable> tableViewProduit;
    public TableColumn<ProduitEntityObservable, String> referenceC;
    public TableColumn<ProduitEntityObservable, String> nameC;
    public TableColumn<ProduitEntityObservable, String> prixC;
    public TableColumn<ProduitEntityObservable, String> quantiteC;

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

        posologie.setOnMouseClicked(e -> ordonnanceMsg.setText(""));
        tableViewProduit.setOnMouseClicked(e -> ordonnanceMsg.setText(""));

        posologie.setOnKeyPressed(e -> {
            ordonnanceMsg.setText("");
            if (e.getCode() == KeyCode.ENTER) {
                createPrescription();
            }
        });

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                ordonnanceMsg.setText("");
                ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameClientField.getText().equals("")) {
                    for (AnimalEntityObservable animal : animalEntityObservables)
                        if (animal.getProprietaire().toLowerCase().contains(nameClientField.getText().toLowerCase()))
                            observableTmpList.add(animal);
                    tableViewAnimal.setItems(observableTmpList);
                } else
                    tableViewAnimal.setItems(animalEntityObservables);
                ordonnanceMsg.setText("");
            }
        });
    }

    private void setProductTable() {

        nameC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantiteC.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        referenceC.setCellValueFactory(new PropertyValueFactory<>("reference"));
        for (ProduitEntity produit : Utils.PRODUIT_DAO.findAll())
            productEntityObservables.add(new ProduitEntityObservable(produit));
        tableViewProduit.setItems(productEntityObservables);
    }

    private void setAnimalsTable() {

        this.nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        this.raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));
        this.clientNameAnimal.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));

        for (AnimalEntity animal : Utils.ANIMAL_DAO.findAll())
            animalEntityObservables.add(new AnimalEntityObservable(animal));

        tableViewAnimal.setItems(animalEntityObservables);
    }

    public void createOrdonnance() {
        Date dateToday = new Date();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        try {
            AnimalEntityObservable animal = tableViewAnimal.getSelectionModel().getSelectedItem();
            tableViewAnimal.getSelectionModel().select(null);
            prescriptions.clear();

            OrdonnanceEntity ord = new OrdonnanceEntity();
            ord.setIdVeterinaire(veterinaire.getId());
            ord.setIdAnimal(animal.getId());
            ord.setVeterinaireByIdVeterinaire(veterinaire);
            ord.setAnimalByIdAnimal(animal.getAnimalEntity());
            ord.setDateOrdonnance(new java.sql.Date(dateToday.getTime()));
            ArrayList<AppartenirEntity> entities = new ArrayList<>();
            for (ProduitEntityObservable p : prescriptions.keySet()) {
                AppartenirEntity a = new AppartenirEntity();
                a.setIdOrdonnance(ord.getId());
                a.setIdProduit(p.toProduitEntity().getId());
                a.setOrdonnanceByIdOrdonnance(ord);
                a.setProduitByIdProduit(p.toProduitEntity());
                a.setQuantite(1);
                entities.add(a);
            }
            ord.setAppartenirsById(entities);
            createOrdonnancePDF(ord);
            Utils.ORDONNANCE_DAO.saveOrUpdate(ord);
            ordonnanceMsg.setTextFill(Color.GREEN);
            ordonnanceMsg.setText("L'ordonnance a bien été créer");
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordonnanceMsg.setTextFill(Color.RED);
                ordonnanceMsg.setText("Selectionnez un animal");
            } else
                ordonnanceMsg.setText("Erreur lors de la création");
        }
    }

    public void createPrescription() {
        try {
            ProduitEntityObservable product = tableViewProduit.getSelectionModel().getSelectedItem();
            prescriptions.put(product, posologie.getText());
            posologie.setText("");
            ordonnanceMsg.setTextFill(Color.GREEN);
            ordonnanceMsg.setText("La prescriptions à été enregistré");
            tableViewProduit.getSelectionModel().select(null);
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordonnanceMsg.setTextFill(Color.RED);
                ordonnanceMsg.setText("Selectionnez un produit");
            }
        }
    }


    public void editModeDisplay() {
        setPrescriptionTable();


        editMode.setVisible(true);
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

    public void editModeUndisplay() {
        editMode.setVisible(false);
    }

    public void deletePoso() {
        if (null != tableViewPrescriptions.getSelectionModel().getSelectedItem()) {
            prescriptions.remove(tableViewPrescriptions.getSelectionModel().getSelectedItem().getProduitEntityObservable());
            tableViewPrescriptions.getSelectionModel().select(null);
            setPrescriptionTable();
        }
    }

    public static void createOrdonnancePDF(OrdonnanceEntity ord) {
        Date dateToday = new Date();
        String dateFormatUser = new SimpleDateFormat("dd/MM/yyyy").format(dateToday);
        EmployeEntity actualUser = Utils.getActualEmploye();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        AnimalEntityObservable animal = new AnimalEntityObservable(ord.getAnimalByIdAnimal());
        try {
            Document document = new Document();
            FileOutputStream file = null;
            PdfWriter.getInstance(document, file);
            Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);

            StringBuilder header = new StringBuilder();
            header.append(dateFormatUser).append("\nDocteur ").append(veterinaire.getPersonneById().getPrenom()).append(veterinaire.getPersonneById().getNom())
                    .append("\n").append(veterinaire.getPersonneById().getAdresse())
                    .append("\n").append(veterinaire.getPersonneById().getTelephone())
                    .append("\n").append(veterinaire.getPersonneById().getMail()).append("\n\n\n\n\n");
            StringBuilder content = new StringBuilder();
            content.append("Pour ").append(animal.getNom()).append(", ").append(animal.getEspece()).append(", ").append(animal.getAge()).append(" :\n");
            for (AppartenirEntity a : ord.getAppartenirsById()){
                content.append("     - ").append(a.getProduitByIdProduit().getNom()).append(" :").append().append("\n");
            }

            document.open();
            document.addTitle("Ordonnance");
            document.addAuthor(actualUser.getPersonneById().getNom() + " " + actualUser.getPersonneById().getPrenom());
            document.add(new Paragraph(new Chunk(header.toString(), font)));
            document.left(1000);
            document.add(new Paragraph(new Chunk(content.toString(), font)));
            document.close();
            file = new FileOutputStream(new SimpleDateFormat("yyyy.MM.dd").format(dateToday)
                    + "." + animal.getNom() + ".pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}