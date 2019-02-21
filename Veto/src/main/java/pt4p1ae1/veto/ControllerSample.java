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
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources)   {
        start();
    }

    protected void start(){
        BackgroundFill fill = new BackgroundFill(Color.web("#2E64FE"), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(fill));
    }

    private void creatBtn(String name) throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.setScene(new Scene(root,1280,720));
    }

    @FXML
    private void onActionAgendaBTN() throws IOException {
        creatBtn("/agendaPage.fxml");
    }
    @FXML
    private void onActionHomeBTN() throws IOException {
        creatBtn("/home.fxml");
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
        creatBtn("/pageAnimaux.fxml");
    }

    @FXML
    public void onActionClientBTN() throws IOException {
        creatBtn("/pageClient.fxml");
    }

    @FXML
    public void onActionOrdonnanceBTN() throws IOException  {
        creatBtn("/pageOrdonnance.fxml");
    }

    @FXML
    public void onActionStockBTN() throws IOException  {
        creatBtn("/pageStock.fxml");
    }

    @FXML
    public void onActionLogBTN() throws IOException  {
        creatBtn("/pageLog.fxml");
    }
}
