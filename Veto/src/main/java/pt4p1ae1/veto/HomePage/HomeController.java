package pt4p1ae1.veto.HomePage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jfxtras.internal.scene.control.skin.agenda.AgendaDaySkin;
import jfxtras.internal.scene.control.skin.agenda.AgendaSkin;
import jfxtras.scene.control.agenda.Agenda;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends ControllerSample implements Initializable {

    @FXML BorderPane borderPane;
    @FXML Pane paneImage;
    @FXML Label welcomeText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
        String prenom = Utils.getActualEmploye().getPersonneById().getPrenom();
        String nom = Utils.getActualEmploye().getPersonneById().getNom();
        welcomeText.setText("Bienvenue "+prenom);
        paneImage.setBackground(
                new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
