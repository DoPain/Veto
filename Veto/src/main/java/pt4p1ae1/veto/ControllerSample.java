package pt4p1ae1.veto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSample extends ControllerVbox implements Initializable {

    @FXML
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
    }

    /**
     * Fonction qui ajoute du style au fxml associé
     */
    protected void start() {
        BackgroundFill fill = new BackgroundFill(Color.web("#01A99C"), CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(fill));
        pane.getChildren().forEach(node -> node.setStyle("-fx-fill: white; -fx-background-radius : 6;"));
    }


    /**
     * Fonction de gérant le bouton de déconnexion
     * @throws IOException si le FXMLLoader ne trouve pas le fxml correspondant.
     */
    @FXML
    private void onActionDisconnectBTN() throws IOException {
        Parent root1 = FXMLLoader.load(this.getClass().getResource("/fxml/popup.fxml"));
        Scene scene = new Scene(root1);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Confirmation");
        stage.showAndWait();

        if(Utils.getConfirmation()) {
            Stage primaryStage = (Stage) pane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/authentification.fxml"));
            primaryStage.setScene(new Scene(root, 700, 400));
            primaryStage.centerOnScreen();
            Utils.createLog("Disconnect");
        }
    }
}
