package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Button btn_home;
    @FXML
    public Button btn_agenda;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void onActionAgendaBTN() throws IOException {
        Stage primaryStage = (Stage) btn_agenda.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/AgendaPage.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }
}
