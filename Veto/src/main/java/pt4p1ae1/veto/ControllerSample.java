package pt4p1ae1.veto;

import javafx.event.ActionEvent;
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

import static javafx.application.Platform.exit;

public class ControllerSample implements Initializable {

    @FXML
    private Button btn_home;
    @FXML
    private Button btn_agenda;
    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources)   {
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
        Parent root = FXMLLoader.load(getClass().getResource("/authentification.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.centerOnScreen();
    }

    @FXML
    public void onActionAnimauxBTN() throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pageAnimaux.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    public void onActionClientBTN() throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pageClient.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    public void onActionOrdonnanceBTN() throws IOException  {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pageOrdonnance.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    public void onActionStockBTN() throws IOException  {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/pageStock.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    public void onActionLogBTN() throws IOException  {
            Stage primaryStage = (Stage) btn_home.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/pageLog.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
    }
}
