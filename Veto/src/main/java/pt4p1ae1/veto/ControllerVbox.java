package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.scene.control.agenda.Agenda;
import pt4p1ae1.veto.AgendaPage.AgendaPage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerVbox implements Initializable {

    @FXML
    private Button btn_home;

    @FXML
    protected Button btn_log;

    @FXML
    protected VBox vBox;

    HashMap<String,String> titleMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!Utils.isAdmin()) {
            btn_log.setVisible(false);
        }
        titleMap = new HashMap<>();
        titleMap.put("/fxml/agendaPage.fxml","Agenda");
        titleMap.put("/fxml/home.fxml","Home");
        titleMap.put("/fxml/rechercheAnimal.fxml","Animaux");
        titleMap.put("/fxml/rechercheClient.fxml","Client");
        titleMap.put("/fxml/rechercheOrdonnance.fxml","Ordonnance");
        titleMap.put("/fxml/pageStock.fxml","Stock");
        titleMap.put("/fxml/pageLog.fxml","Log");
        titleMap.put("/fxml/rechercheEmployes.fxml","Employé");
    }

    protected void creatBtn(String name) throws IOException {
        Stage primaryStage = (Stage) btn_home.getScene().getWindow();
        if(primaryStage.getTitle().equals("Agenda")){
            System.out.println("agenda, à faire");
            AgendaPage.saveEvent();
        }
        Parent root = FXMLLoader.load(this.getClass().getResource(name));
        primaryStage.setScene(new Scene(root,Utils.WIDTH,Utils.HEIGHT));
        primaryStage.setTitle(titleMap.get(name));
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
    protected void onActionAnimauxBTN() throws IOException {
        creatBtn("/fxml/rechercheAnimal.fxml");
    }

    @FXML
    protected void onActionClientBTN() throws IOException {
        creatBtn("/fxml/rechercheClient.fxml");
    }

    @FXML
    protected void onActionOrdonnanceBTN() throws IOException  {
        creatBtn("/fxml/rechercheOrdonnance.fxml");
    }

    @FXML
    protected void onActionStockBTN() throws IOException  {
        creatBtn("/fxml/pageStock.fxml");
    }

    @FXML
    protected void onActionLogBTN() throws IOException  {
        creatBtn("/fxml/pageLog.fxml");

    }

    @FXML
    protected void onActionEmpBTN() throws IOException  {
        creatBtn("/fxml/rechercheEmployes.fxml");

    }
}
