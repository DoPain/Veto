package pt4p1ae1.veto.GestionCLient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InscriptionClientController extends ControllerSample implements Initializable {

    @FXML
    private Button backToClients;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
    }

    @FXML
    private void retour() throws IOException {
        super.creatBtn("/fxml/rechercheClient.fxml", (Stage) backToClients.getScene().getWindow());
    }
}
