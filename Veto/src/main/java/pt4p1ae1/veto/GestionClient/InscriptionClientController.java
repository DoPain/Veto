package pt4p1ae1.veto.GestionClient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt4p1ae1.veto.ControllerSample;

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
