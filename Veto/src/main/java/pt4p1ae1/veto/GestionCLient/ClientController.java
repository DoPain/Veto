package pt4p1ae1.veto.GestionCLient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.DataBase;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ClientController extends ControllerSample implements Initializable {

    @FXML
    VBox ClientBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DataBase dataBase = new DataBase();
            ResultSet rs = dataBase.getClient();
            while (rs.next()) {
                String s = rs.getString("NOM")
                        + " "
                        + rs.getString("PRENOM")
                        + " "
                        + rs.getString("ADRESSE")
                        + " "
                        + rs.getString("MAIL")
                        + " "
                        + rs.getString("TEL")
                        + " "
                        + rs.getString("VILLE");
                Button a = new Button(s);
                a.setOnAction(e -> afficherClient(s));
                ClientBox.getChildren().add(a);
            }
        } catch (Exception e){
            System.out.println("Inizialisation LogController :" + e);
        }
        super.start();
    }

    private void afficherClient(String s) {
        System.out.println(s);
    }
}
