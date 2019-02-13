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
            passwordField.setStyle("-fx-prompt-text-fill: red");
            passwordField.setPromptText("Veuillez remplir ce champ.");
        } else if (connexionMatched()) {
            Stage primaryStage = (Stage) signInButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
            primaryStage.setScene(new Scene(root, 1280, 720));
        } else {
            loginField.setText("");
            passwordField.setText("");
            passwordField.setStyle("-fx-prompt-text-fill: red");
            loginField.setStyle("-fx-prompt-text-fill: red");
            loginField.setPromptText("Veuillez rentrer un login valide");
            passwordField.setPromptText("Veuillez rentrer un mot de passe valide");
        }
    }


    public boolean connexionMatched() {
        DataBase database = new DataBase();
        boolean loginFound = false;
        boolean mdpFound = false;
        ResultSet results = database.getEmployes();

        System.out.println("pas OK");
        try {
            while (results.next() && !loginFound && !mdpFound)  {
                if (results.getString("login").equals(loginField.getText())) {
                    loginFound = true;
                }
                if (results.getString("mdp").equals(passwordField.getText())) {
                    mdpFound = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return loginFound && mdpFound;
    }

    private void transitionScene(String nextScene) {
        FadeTransition transition = new FadeTransition();
        transition.setDuration(Duration.millis(1000));
        transition.setNode(rootPane);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setOnFinished(e -> loadNextScene(nextScene));
        transition.play();
    }

    private void loadNextScene(String nextScene) {
        try {
            Parent secondView;
            switch (nextScene) {
                case "register":
                    secondView = (VBox) FXMLLoader.load(getClass().getResource("/register.fxml"));
                    break;
                case "home":
                    secondView = (VBox) FXMLLoader.load(getClass().getResource("/home.fxml"));
                    break;
                default:
                    secondView = null;
            }
            Scene scene2 = new Scene(secondView);
            Stage currentStage = (Stage) rootPane.getScene().getWindow();
            currentStage.setScene(scene2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
