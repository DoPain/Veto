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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.*;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionStock.ProduitEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

public class OrdonnanceController extends ControllerSample implements Initializable {
    public TableView<AnimalEntityObservable> tableViewAnimal;
    public TableColumn<AnimalEntityObservable, String> nameAnimal;
    public TableColumn<AnimalEntityObservable, String> especeAnimal;
    public TableColumn<AnimalEntityObservable, String> raceAnimal;
    public TableColumn<AnimalEntityObservable, String> clientNameAnimal;
    public Label ordonnanceMsg;
    public TextField nameClientField;
    public TableView<ProduitEntityObservable> tableViewProduit;
    public TableColumn<ProduitEntityObservable, String> referenceC;
    public TableColumn<ProduitEntityObservable, String> nameC;
    public TableColumn<ProduitEntityObservable, String> prixC;
    public TableColumn<ProduitEntityObservable, String> quantiteC;
    public TextField posologie;

    private ObservableList<AnimalEntityObservable> animalEntityObservables = FXCollections.observableArrayList();
    private ObservableList<ProduitEntityObservable> productEntityObservables = FXCollections.observableArrayList();
    private HashMap<ProduitEntityObservable, String> prescriptions = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        setAnimalsTable();
        setProductTable();

        nameClientField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                ObservableList<AnimalEntityObservable> observableTmpList = FXCollections.observableArrayList();
                if (!nameClientField.getText().equals("")) {
                    for (AnimalEntityObservable animal : animalEntityObservables)
                        if (animal.getProprietaire().toLowerCase().contains(nameClientField.getText().toLowerCase()))
                            observableTmpList.add(animal);
                    tableViewAnimal.setItems(observableTmpList);
                } else
                    tableViewAnimal.setItems(animalEntityObservables);
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

    public void createDocPDF() {
        Date dateToday = new Date();
        String dateFormatUser = new SimpleDateFormat("dd.MM.yyyy").format(dateToday);
        EmployeEntity actualUser = Utils.getActualEmploye();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        try {
            Document document = new Document();
            FileOutputStream file = new FileOutputStream(new SimpleDateFormat("yyyy.MM.dd").format(dateToday)
                    + "." + tableViewAnimal.getSelectionModel().getSelectedItem().getNom() + ".pdf");
            PdfWriter.getInstance(document, file);
            Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);


            document.open();
            document.addTitle("Ordonnance");
            document.addAuthor(actualUser.getPersonneById().getNom() + " " + actualUser.getPersonneById().getPrenom());
            Image img = Image.getInstance("src/main/resources/img/ordonnance.png");
            img.scaleAbsoluteWidth(50);
            img.scaleAbsoluteHeight((float) 49.5);
            document.left(50);
            document.add(new Paragraph(new Chunk(dateFormatUser + "\nDr. " + veterinaire.getPersonneById().getNom()
                    + "\n" + veterinaire.getPersonneById().getAdresse(), font)));
            document.add(img);
            for (ProduitEntityObservable p : prescriptions.keySet())
                document.add(new Paragraph(new Chunk(p.getNom() + " : \n\t\t- " + prescriptions.get(p) + "\n", font)));
            document.close();
            ordonnanceMsg.setTextFill(Color.GREEN);
            ordonnanceMsg.setText("L'ordonnance a bien été créer");
            wait(5000);
            ordonnanceMsg.setText("");
            prescriptions.clear();
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordonnanceMsg.setTextFill(Color.RED);
                ordonnanceMsg.setText("Selectionnez un animal");
            }
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
            ordonnanceMsg.setText("");
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                ordonnanceMsg.setTextFill(Color.RED);
                ordonnanceMsg.setText("Selectionnez un produit");
            }
        }
    }
}