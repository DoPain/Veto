package pt4p1ae1.veto.GestionOrdonnance;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.ParallelCamera;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrdonnanceController extends ControllerSample implements Initializable {
    public TableView<AnimalEntityObservable> tableViewAnimal;
    public TableColumn<AnimalEntityObservable, String> nameAnimal;
    public TableColumn<AnimalEntityObservable, String> especeAnimal;
    public TableColumn<AnimalEntityObservable, String> raceAnimal;
    public TableColumn<AnimalEntityObservable, String> clientNameAnimal;
    public Label validateError;
    public TextField nameClientField;
    public TableView tableViewProduit;
    public TableColumn referenceC;
    public TableColumn nameC;
    public TableColumn prixC;
    public TableColumn quantiteC;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        this.nameAnimal.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.especeAnimal.setCellValueFactory(new PropertyValueFactory<>("espece"));
        this.raceAnimal.setCellValueFactory(new PropertyValueFactory<>("race"));
        this.clientNameAnimal.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));

        ObservableList<AnimalEntityObservable> animalEntityObservables = FXCollections.observableArrayList();

        for (AnimalEntity animal : Utils.ANIMAL_DAO.findAll())
            animalEntityObservables.add(new AnimalEntityObservable(animal));

        tableViewAnimal.setItems(animalEntityObservables);

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

            document.close();
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                validateError.setText("Selectionnez un animal et au moins un produit");
            }
        }
    }
}
