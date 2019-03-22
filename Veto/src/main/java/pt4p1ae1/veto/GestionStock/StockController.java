package pt4p1ae1.veto.GestionStock;

import javafx.event.ActionEvent;
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

public class StockController extends ControllerSample implements Initializable {

    @FXML
    private Button insertBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();
    }

    @FXML
    private void insertionProduit(ActionEvent actionEvent) throws IOException {
        super.creatBtn("/fxml/inscriptionProduit.fxml", (Stage) insertBtn.getScene().getWindow());
    }
}
