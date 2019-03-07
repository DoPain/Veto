package pt4p1ae1.veto.ConnectionMenu.Authentification;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AuthentificationController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signInButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void signInButtonPushed() throws IOException {
        int returnInt = connexionMatched();
        if (loginField.getText().equals("") && passwordField.getText().equals("")) {
            passwordField.setStyle("-fx-prompt-text-fill: red");
            loginField.setStyle("-fx-prompt-text-fill: red");
            loginField.setPromptText("Veuillez remplir ce champ.");
            passwordField.setPromptText("Veuillez remplir ce champ.");
        } else if (loginField.getText().equals("")) {
            passwordField.setStyle("-fx-prompt-text-fill: red");
            loginField.setPromptText("Veuillez remplir ce champ.");
        } else if (passwordField.getText().equals("")) {
            loginField.setStyle("-fx-prompt-text-fill: red");
            passwordField.setStyle("-fx-prompt-text-fill: red");
            passwordField.setPromptText("Veuillez remplir ce champ.");
        } else if (returnInt == 1 || returnInt == 2) {
            if (returnInt == 1) {
                Utils.admin = false;
            } else {
                Utils.admin = false;
            }
            Stage primaryStage = (Stage) signInButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else {
            loginField.setText("");
            passwordField.setText("");
            passwordField.setStyle("-fx-prompt-text-fill: red");
            loginField.setStyle("-fx-prompt-text-fill: red");
            loginField.setPromptText("Veuillez rentrer un login valide");
            passwordField.setPromptText("Veuillez rentrer un mot de passe valide");
        }
    }


    private int connexionMatched() {
        return 0;
    }
}
