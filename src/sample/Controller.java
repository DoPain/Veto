package sample;

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

public class Controller implements Initializable {
    @FXML
    private Button btn_home;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_home.setOnAction(event -> {
            Stage primaryStage = (Stage) btn_home.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/homePage.fxml"));
            } catch (IOException e) {
                System.out.println("cannot load homePage.fxml");
            }
            primaryStage.setScene(new Scene(root, 1280, 720));
        });
    }
}
