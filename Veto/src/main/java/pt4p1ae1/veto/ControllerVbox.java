package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerVbox {

    @FXML
    private Button btn_home;

    private void creatBtn(String name) throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(name));
        primaryStage.setScene(new Scene(root,1280,720));
    }
    @FXML
    protected void onActionAgendaBTN() throws IOException {
        creatBtn("/agendaPage.fxml");
    }
    @FXML
    protected void onActionHomeBTN() throws IOException {
        creatBtn("/home.fxml");
    }
    @FXML
    public void onActionAnimauxBTN() throws IOException {
        creatBtn("/rechercheAnimal.fxml");
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
