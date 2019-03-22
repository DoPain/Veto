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
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.GestionCLient.ClientEntityObservable;
import pt4p1ae1.veto.Utils;

import javax.swing.text.Document;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.sql.Date;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        ObservableList<ClientEntityObservable> clientEntityObservables = FXCollections.observableArrayList();

        List<ClientEntity> clients = Utils.CLIENT_DAO.findAll();

        for (ClientEntity client : clients) clientEntityObservables.add(new ClientEntityObservable(client));

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
                        if (animal.getProprietaire().contains(nameClientField.getText()))
                            observableTmpList.add(animal);
                    tableViewAnimal.setItems(observableTmpList);
                } else
                    tableViewAnimal.setItems(animalEntityObservables);
            }
        });
    }

    public void createDocPDF() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateToday = dateFormat.format( new java.sql.Date(new java.util.Date().getTime()));
        EmployeEntity actualUser = Utils.getActualEmploye();
        VeterinaireEntity veterinaire = Utils.VETERINAIRE_DAO.findAll().get(0);
        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(dateToday + "." + tableViewAnimal.getSelectionModel().getSelectedItem().getNom() + ".pdf"));
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//
//
//            document.open();
//            document.addTitle("Ordonnance");
//            document.addAuthor(actualUser.getPersonneById().getNom() + " " + actualUser.getPersonneById().getPrenom());
//            Image img = Image.getInstance("src/main/resources/img/ordonnance.png");
//            document.add(img);
//            document.add(new Chunk(dateToday, font));
//            document.add(new Chunk(veterinaire.getPersonneById().getAdresse(), font));
//            document.add(new Chunk("Dr. " + veterinaire.getPersonneById().getNom(), font));
//
//            document.close();
        } catch (Exception e) {
            if (e.getClass() == NullPointerException.class) {
                validateError.setText("Selectionnez un animal et au moins un produit");
            }
        }
    }
}
