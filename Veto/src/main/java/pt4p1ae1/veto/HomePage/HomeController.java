package pt4p1ae1.veto.HomePage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import jfxtras.internal.scene.control.skin.agenda.AgendaDaySkin;
import jfxtras.internal.scene.control.skin.agenda.AgendaSkin;
import jfxtras.scene.control.agenda.Agenda;
import pt4p1ae1.veto.ControllerSample;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends ControllerSample implements Initializable {

    @FXML BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

    }
}
