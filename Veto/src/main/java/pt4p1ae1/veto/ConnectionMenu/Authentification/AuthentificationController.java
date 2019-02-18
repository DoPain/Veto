package pt4p1ae1.veto.ConnectionMenu.Authentification;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import pt4p1ae1.veto.DataBase;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        } else if (connexionMatched() == 1) {
            System.out.println(connexionMatched());
            Stage primaryStage = (Stage) signInButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
            primaryStage.centerOnScreen();
        } else if(connexionMatched() == 2){
            System.out.println(connexionMatched());
            Stage primaryStage = (Stage) signInButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
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


    public int connexionMatched() {
        DataBase database = new DataBase();
        boolean loginFound = false;
        boolean mdpFound = false;
        boolean admin = false;

        try {
            ResultSet resultsV = database.getIdVeterinaire();
            ResultSet results = database.getEmployes();
            resultsV.first();
            while (results.next() || (!loginFound && !mdpFound))  {

                if (results.getString("login").equals(loginField.getText())) {
                    loginFound = true;
                }
                if (results.getString("mdp").equals(passwordField.getText())) {
                    mdpFound = true;
                }
                if (results.getString("idE").equals(resultsV.getString("idV"))){
                    admin = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        if(loginFound && mdpFound && admin){
            return 2;
        } else if(loginFound && mdpFound && !admin) {
            return 1;
        } else {
            return 0;
        }
    }
}
