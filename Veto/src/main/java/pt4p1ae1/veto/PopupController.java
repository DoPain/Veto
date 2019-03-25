package pt4p1ae1.veto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import jdk.internal.util.xml.impl.Input;

import java.awt.event.InputEvent;
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

    @FXML
    public void Confirmer(){
        stage = (Stage) refuser.getScene().getWindow();
        Utils.setConfirmation(true);
        stage.close();
    }

    @FXML
    public void Refuser(){
        Utils.setConfirmation(false);
        Platform.exit();
    }



}
