package pt4p1ae1.veto.GestionCLient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.Client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController extends ControllerSample implements Initializable {

    @FXML
    VBox ClientBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO : récupérer les clients comme en JEE

        for (Client c : clients) {
//            ClientBox.getChildren().add(new Button(c.getPersonne().getIdPersonne() + ". " + c.getPersonne().getNom() + ", " + c.getPersonne().getPrenom()));
            ClientBox.getChildren().add(new Button( String.valueOf(c.getIdClient())));
        }
        super.start();
    }

    private void afficherClient(String s) {
        System.out.println(s);
    }
}
