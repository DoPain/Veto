package pt4p1ae1.veto.GestionCLient;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import pt4p1ae1.veto.ControllerSample;

import java.net.URL;
import java.util.ResourceBundle;

public class RechercheClientController extends ControllerSample implements Initializable {

    @FXML
    private TextField nameProprioField;
    @FXML
    private TextField nameAnimalField;
    @FXML
    private TextField speciesField;
    @FXML
    private TextField raceField;

    @FXML
    private Button filterButton;
    @FXML
    private Button firstButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button lastButton;
    @FXML
    private Button insertButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn nameProprioColumn;
    @FXML
    private TableColumn nameAnimalColumn;
    @FXML
    private TableColumn nameSpeciesColumn;
    @FXML
    private TableColumn nameRaceColumn;
    @FXML
    private TableColumn ageAnimal;
    @FXML
    private TableColumn weightAnimal;
    @FXML
    private TableColumn nextMeeting;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //super.start();
    }

    public void onActionInsertAnimal(ActionEvent actionEvent) {
    }

    public void onActionEditAnimal(ActionEvent actionEvent) {
    }

    public void onActionDeleteAnimal(ActionEvent actionEvent) {
    }
}

