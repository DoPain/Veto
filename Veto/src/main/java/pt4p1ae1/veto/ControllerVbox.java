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
    protected Button btn_home;

    @FXML
    protected Button btn_log;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!Utils.isAdmin()) {
            btn_log.setVisible(false);
        }
    }

    protected void creatBtn(String ressourceName, Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ressourceName));
        primaryStage.setScene(new Scene(root, Utils.WIDTH,Utils.HEIGHT));
    }
    @FXML
    protected void onActionAgendaBTN() throws IOException {
        creatBtn("/fxml/agendaPage.fxml", (Stage) btn_home.getScene().getWindow());
    }
    @FXML
    protected void onActionHomeBTN() throws IOException {
        creatBtn("/fxml/home.fxml", (Stage) btn_home.getScene().getWindow());
    }
    @FXML
    protected void onActionAnimauxBTN() throws IOException {
        creatBtn("/fxml/rechercheAnimal.fxml", (Stage) btn_home.getScene().getWindow());
    }

    @FXML
    protected void onActionClientBTN() throws IOException {
        creatBtn("/fxml/rechercheClient.fxml", (Stage) btn_home.getScene().getWindow());
    }

    @FXML
    protected void onActionOrdonnanceBTN() throws IOException  {
        creatBtn("/fxml/rechercheOrdonnance.fxml", (Stage) btn_home.getScene().getWindow());
    }

    @FXML
    protected void onActionStockBTN() throws IOException  {
        creatBtn("/fxml/pageStock.fxml", (Stage) btn_home.getScene().getWindow());
    }

    @FXML
    public void onActionLogBTN() throws IOException  {
        creatBtn("/fxml/pageLog.fxml", (Stage) btn_home.getScene().getWindow());

    }

    @FXML
    protected void onActionEmpBTN() throws IOException  {
        creatBtn("/fxml/rechercheEmployes.fxml", (Stage) btn_home.getScene().getWindow());

    }
}
