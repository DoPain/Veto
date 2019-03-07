package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSample implements Initializable {

    @FXML
    private Pane pane;

    protected void start() {
        BackgroundFill fill = new BackgroundFill(Color.web("#2E64FE"), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(fill));
    }

    @FXML
    private void onActionAgendaBTN() throws IOException {
        creatBtn("/fxml/agendaPage.fxml");
    }
    @FXML
    private void onActionHomeBTN() throws IOException {
        creatBtn("/fxml/home.fxml");
    }
    @FXML
    private void onActionDisconnectBTN() throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/authentification.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.centerOnScreen();
    }

    @FXML
    public void onActionAnimauxBTN() throws IOException {
        creatBtn("/pageAnimaux.fxml");
    }

    @FXML
    public void onActionClientBTN() throws IOException {
        creatBtn("/fxml/pageClient.fxml");
    }

    @FXML
    public void onActionOrdonnanceBTN() throws IOException  {
        creatBtn("/fxml/pageOrdonnance.fxml");
    }

    @FXML
    public void onActionStockBTN() throws IOException  {
        creatBtn("/fxml/pageStock.fxml");
    }

    @FXML
    public void onActionLogBTN() throws IOException  {
            Stage primaryStage = (Stage) btn_home.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/pageLog.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
    }
}
