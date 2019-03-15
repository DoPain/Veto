package pt4p1ae1.veto;

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

public class ControllerVbox implements Initializable {

    @FXML
    private Button btn_home;

    @FXML
    protected Button btn_log;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Utils.admin == false ) {
            btn_log.setVisible(false);
        }
    }

    private void creatBtn(String name) throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.setScene(new Scene(root,1280,720));
    }
    @FXML
    protected void onActionAgendaBTN() throws IOException {
        creatBtn("/fxml/agendaPage.fxml");
    }
    @FXML
    protected void onActionHomeBTN() throws IOException {
        creatBtn("/fxml/home.fxml");
    }
    @FXML
    public void onActionAnimauxBTN() throws IOException {
        creatBtn("/fxml/rechercheAnimal.fxml");
    }

    @FXML
    public void onActionClientBTN() throws IOException {
        creatBtn("/fxml/rechercheClient.fxml");
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
        creatBtn("/fxml/pageLog.fxml");

    }
}
