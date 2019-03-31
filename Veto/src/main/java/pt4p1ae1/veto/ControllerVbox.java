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

    private static Boolean isAgenda = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!Utils.isAdmin()) {
            btn_log.setVisible(false);
            btn_emp.setVisible(false);
        }
        vBox.setSpacing(3);
        vBox.getChildren().forEach(node -> node.setStyle("-fx-background-radius : 6; -fx-background-insets:0,1;"));
    }

    /**
     * Fonction gérant les boutons.
     *
     * @param ressourceName le chemin relatif du fxml correspondant
     * @param primaryStage le stage à changer
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    protected void creatBtn(String ressourceName, Stage primaryStage) throws IOException {
        if(isAgenda){
            AgendaPage.saveEvents();
        }
        Parent root = FXMLLoader.load(this.getClass().getResource(ressourceName));
        primaryStage.setScene(new Scene(root,Utils.WIDTH,Utils.HEIGHT));
        isAgenda = ressourceName.equals("/fxml/agendaPage.fxml");
    }

    /**
     * Fonction gérant le bouton de l'agenda.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionAgendaBTN() throws IOException {
        creatBtn("/fxml/agendaPage.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton d'accueil.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionHomeBTN() throws IOException {
        creatBtn("/fxml/home.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton de la gestion des animaux.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionAnimauxBTN() throws IOException {
        creatBtn("/fxml/rechercheAnimal.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton de la gestion des clients.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionClientBTN() throws IOException {
        creatBtn("/fxml/rechercheClient.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton de la gestion des ordonnances.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionOrdonnanceBTN() throws IOException  {
        creatBtn("/fxml/rechercheOrdonnance.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton de la gestion des stocks.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionStockBTN() throws IOException  {
        creatBtn("/fxml/rechercheProduit.fxml", (Stage) btn_home.getScene().getWindow());
    }

    /**
     * Fonction gérant le bouton des logs.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    public void onActionLogBTN() throws IOException  {
        creatBtn("/fxml/pageLog.fxml", (Stage) btn_home.getScene().getWindow());

    }

    /**
     * Fonction gérant le bouton de la gestion des employés.
     *
     * @throws IOException si le FXMLLoader ne trouve pas le fxml passé en paramètre
     */
    @FXML
    protected void onActionEmpBTN() throws IOException  {
        creatBtn("/fxml/rechercheEmployes.fxml", (Stage) btn_home.getScene().getWindow());

    }
}
