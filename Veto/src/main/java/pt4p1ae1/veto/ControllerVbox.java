package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pt4p1ae1.veto.AgendaPage.AgendaPage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerVbox implements Initializable {

    @FXML
    protected Button btn_home;

    @FXML
    protected Button btn_log;
    @FXML
    protected Button btn_emp;

    @FXML
    protected VBox vBox;

    private static HashMap<String,String> titleMap = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!Utils.isAdmin()) {
            btn_log.setVisible(false);
            btn_emp.setVisible(false);
        }
        titleMap.put("/fxml/agendaPage.fxml","Agenda");
        titleMap.put("/fxml/home.fxml","VetoGestion");
        titleMap.put("/fxml/rechercheAnimal.fxml","Animaux");
        titleMap.put("/fxml/rechercheClient.fxml","Client");
        titleMap.put("/fxml/rechercheOrdonnance.fxml","Ordonnance");
        titleMap.put("/fxml/rechercheProduit.fxml","Stock");
        titleMap.put("/fxml/pageLog.fxml","Log");
        titleMap.put("/fxml/rechercheEmployes.fxml","Employé");
        titleMap.put("/fxml/rechercheProduit.fxml","Produit");
    }

    protected void creatBtn(String ressourceName, Stage primaryStage) throws IOException {
        if(primaryStage.getTitle().equals("Agenda")){
            AgendaPage.saveEvents();
        }
        Parent root = FXMLLoader.load(this.getClass().getResource(ressourceName));
        primaryStage.setScene(new Scene(root,Utils.WIDTH,Utils.HEIGHT));
        if(titleMap.containsKey(ressourceName)){
            primaryStage.setTitle(titleMap.get(ressourceName));
        }
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
        creatBtn("/fxml/rechercheProduit.fxml", (Stage) btn_home.getScene().getWindow());
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
