package pt4p1ae1.veto.GestionLog;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.DataBase;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LogController extends ControllerSample implements Initializable {

    @FXML
    private VBox logBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DataBase dataBase = new DataBase();
            ResultSet rs = dataBase.getLog();
            while (rs.next()) {
                String s = rs.getString("idConnexion")
                        + " at "
                        + rs.getDate("temps")
                        + " -> "
                        + rs.getString("action");
                logBox.getChildren().add(new Label(s));
            }
        } catch (Exception e){
            System.out.println("Inizialisation LogController :" + e);
        }
        super.start();
    }
}
