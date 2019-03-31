package pt4p1ae1.veto.ConnectionMenu.Authentification;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AuthentificationController implements Initializable {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signInButton;

    private List<EmployeEntity> employeList;
    private List<VeterinaireEntity> veterinaireList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeList = Utils.EMPLOYE_DAO.findAll();
        veterinaireList = Utils.VETERINAIRE_DAO.findAll();
        loginField.setOnKeyPressed(ke -> {
            if (ke.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });
        passwordField.setOnKeyPressed(ke -> {
            if (ke.getCode() == KeyCode.ENTER) {
                signInButton.fire();
            }
        });
    }

    /**
     * Renvoie vers la page d'accueil si le login ainsi que le mot de passe sont corrects
     *
     * @throws IOException si l'application ne trouve pas la page
     */
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
                Utils.setAdmin(false);
            } else {
                Utils.setAdmin(true);
            }
            Stage primaryStage = (Stage) signInButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
            primaryStage.setScene(new Scene(root, Utils.WIDTH, Utils.HEIGHT));
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

    /**
     * Vérifie si le login et le mot de passe sont présents dans la base et attribue les droits d'admin
     * si le compte en a la possibilité
     *
     * @return 2 si droits d'admin, 1 si droits normaux et 0 si le login ou le mot de passe n'apparaît pas
     * dans la base de données
     */
    private int connexionMatched() {
        final boolean[] accountBoolean = {false, false};
        final String login = loginField.getText();
        final String mdp = passwordField.getText();
        employeList.forEach(employeEntity -> {
            if (login.equals(employeEntity.getLogin()) &&
                    mdp.equals(employeEntity.getMotDePasse())) {
                veterinaireList.forEach(veterinaireEntity -> {
                    if (veterinaireEntity.getId() == employeEntity.getId()) {
                        accountBoolean[1] = true;
                    }

                });
                accountBoolean[0] = true;

                Utils.setActualEmploye(employeEntity);
                Utils.createLog("Connect");
            }
        });

        if (accountBoolean[0] && accountBoolean[1]) {
            return 2;
        } else if (accountBoolean[0]) {
            return 1;
        } else {
            return 0;
        }
    }
}
