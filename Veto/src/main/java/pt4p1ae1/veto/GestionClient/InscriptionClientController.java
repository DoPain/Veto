package pt4p1ae1.veto.GestionClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.PersonneEntity;
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

public class InscriptionClientController extends ControllerSample implements Initializable {

    @FXML
    private Button register;

    @FXML
    private ComboBox<VilleEntityObservable> cityClient;
    @FXML
    private TextField cpClientText;
    @FXML
    private TextField addressClientText;
    @FXML
    private TextField birthDateClientText;
    @FXML
    private TextField emailClientText;
    @FXML
    private TextField nameClientText;
    @FXML
    private TextField firstNameClientText;
    @FXML
    private TextField phoneClientText;
    @FXML
    private Button backToClients;

    private List<VilleEntity> villes = Utils.VILLE_DAO.findAll();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        cpClientText.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.ENTER) {
                ObservableList<VilleEntityObservable> villesObservables = FXCollections.observableArrayList();
                villesObservables.clear();
                for (VilleEntity v : villes) {
                    if (v.getVilleCodePostal().contains(cpClientText.getText())) {
                        villesObservables.add(new VilleEntityObservable(v));
                    }
                }
                cityClient.setItems(villesObservables);
                cityClient.setValue(villesObservables.get(0));
            }
        });
        cityClient.setOnAction(e -> {
            cpClientText.setText(cityClient.getValue().getCp());
        });
    }

    @FXML
    private void retourClient() throws IOException {
        super.creatBtn("/fxml/rechercheClient.fxml", (Stage) backToClients.getScene().getWindow());
    }

    @FXML
    private void inscrireClient() throws ParseException, IOException {
        Parent root1 = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();

        if(Utils.getConfirmation()) {
            if (!nameClientText.getText().equals("")
                    && !firstNameClientText.getText().equals("")
                    && !cpClientText.getText().equals("")) {

                ClientEntity client = new ClientEntity();
                PersonneEntity person = new PersonneEntity();

                person.setNom(nameClientText.getText().toUpperCase());
                person.setPrenom(firstNameClientText.getText());

                if (!birthDateClientText.getText().equals("")) {
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                    Date dateB = formatter.parse(birthDateClientText.getText());
                    java.sql.Date sqlDateB = new java.sql.Date(dateB.getTime());
                    person.setDateNaissance(sqlDateB);
                }

                if (!phoneClientText.getText().equals("")) {
                    person.setTelephone(phoneClientText.getText());
                }
                if (!emailClientText.getText().equals("")) {
                    person.setMail(emailClientText.getText());
                }
                if (!addressClientText.getText().equals("")) {
                    person.setAdresse(addressClientText.getText());
                }
                if (!cityClient.getValue().toString().equals("")) {
                    person.setIdVille(cityClient.getValue().getId());
                }
                System.out.println(person.getId() + " " + cityClient.getValue().getNom());
                Utils.PERSONNE_DAO.saveOrUpdate(person);

                List<PersonneEntity> allP = Utils.PERSONNE_DAO.findAll();
                for (PersonneEntity p : allP) {
                    if (p.getNom().equals(person.getNom()) && p.getPrenom().equals(person.getPrenom())) {
                        person.setId(p.getId());
                    }
                }
                client.setId(person.getId());

                Utils.CLIENT_DAO.saveOrUpdate(client);

                Utils.createLog("Créer Client : " + person.getPrenom()
                        + " "
                        + person.getNom());
                super.creatBtn("/fxml/rechercheClient.fxml", (Stage) register.getScene().getWindow());

            } else {
                if (nameClientText.getText().equals("")) {
                    nameClientText.setPromptText("Veuillez remplir ce champ.");
                    nameClientText.setStyle("-fx-prompt-text-fill: red");
                }
                if (firstNameClientText.getText().equals("")) {
                    firstNameClientText.setStyle("-fx-prompt-text-fill: red");
                    firstNameClientText.setPromptText("Veuillez remplir ce champ.");
                }
                if (cpClientText.getText().equals("")) {
                    cpClientText.setStyle("-fx-prompt-text-fill: red");
                    cpClientText.setPromptText("Veuillez remplir ce champ");
                }
            }
        }
    }
}
