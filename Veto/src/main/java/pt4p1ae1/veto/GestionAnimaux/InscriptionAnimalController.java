package pt4p1ae1.veto.GestionAnimaux;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import pt4p1ae1.veto.ControllerSample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class InscriptionAnimalController extends ControllerSample implements Initializable {

    @FXML
    private Button backToAnimalsBtn;
    @FXML
    private Button registerBtn;

    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox speciesComboBox;
    @FXML
    private ComboBox raceComboBox;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private RadioButton femaleRadioBtn;
    @FXML
    private TextField birthDateTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField furtherInformationsTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
    }
    //TODO Remplir les ComboBox

    @FXML
    private void onActionBackToAnimalBtn() {
        //TODO Retour vers la liste des animaux
    }

    @FXML
    private void onActionRegisterBtn() {
        //TODO Inscrire l'animal et rediriger vers la liste des animaux
    }
}
