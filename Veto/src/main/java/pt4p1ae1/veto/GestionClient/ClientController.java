package pt4p1ae1.veto.GestionClient;

import javafx.fxml.Initializable;
import pt4p1ae1.veto.ControllerSample;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController extends ControllerSample implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
    }

    private void afficherClient(String s) {
        System.out.println(s);
    }
}
