package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSample implements Initializable {

    @FXML
    private Button btn_home;
    @FXML
    private Button btn_agenda;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }

    protected void start(){
        BackgroundFill fill = new BackgroundFill(Color.web("#2E64FE"), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(fill));
    }

    @FXML
    private void onActionAgendaBTN() throws IOException {
        Stage primaryStage = (Stage) btn_agenda.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/agendaPage.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }
    @FXML
    private void onActionHomeBTN() throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }
    @FXML
    private void onActionDisconnectBTN() throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/register.fxml"));
        primaryStage.setScene(new Scene(root, 640, 400));
    }
}
