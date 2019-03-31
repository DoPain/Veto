package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PopupController{

    @FXML
    private Button confirmer;
    @FXML
    private Button refuser;

    Stage stage;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Confirme la décision actuelle si un clic sur le boutton est effectué
     *
     */
    @FXML
    public void Confirmer(){
        stage = (Stage) refuser.getScene().getWindow();
        Utils.setConfirmation(true);
        stage.close();
    }

    /**
     * Refuse la décision actuelle si un clic sur le boutton est effectué
     *
     */
    @FXML
    public void Refuser(){
        stage = (Stage) refuser.getScene().getWindow();
        Utils.setConfirmation(false);
        stage.close();
    }



}
