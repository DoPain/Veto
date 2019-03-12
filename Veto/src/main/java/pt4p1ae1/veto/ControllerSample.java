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
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.LogEntity;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;

public class ControllerSample extends ControllerVbox implements Initializable {

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }

    protected void start() {
        BackgroundFill fill = new BackgroundFill(Color.web("#2E64FE"), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(fill));
    }

    @FXML
    private void onActionDisconnectBTN() throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/authentification.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.centerOnScreen();
        Utils.createLog("Disconnect");
    }
}
