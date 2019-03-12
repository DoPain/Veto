package pt4p1ae1.veto.ConnectionMenu.Authentification;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.LogEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;
import pt4p1ae1.veto.Utils;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.ResourceBundle;

public class AuthentificationController implements Initializable {

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signInButton;

    private final EntityDao<EmployeEntity> employeDao = DaoFactory.getDaoFor(EmployeEntity.class);
    private final EntityDao<VeterinaireEntity> veterinaireDao = DaoFactory.getDaoFor(VeterinaireEntity.class);
    private final EntityDao<LogEntity> logDao = DaoFactory.getDaoFor(LogEntity.class);
    private List<EmployeEntity> employeList;
    private List<VeterinaireEntity> veterinaireList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeList = employeDao.findAll();
        veterinaireList = veterinaireDao.findAll();
        loginField.setOnKeyPressed(ke -> {
            if (ke.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });
        passwordField.setOnKeyPressed(ke-> {
            if (ke.getCode() == KeyCode.ENTER) {
                try {
                    signInButtonPushed();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
                Utils.admin = true;
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
        // accountBoolean [0] == accountFound
        // accountBoolean [1] == adminAccount
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

                LogEntity log = new LogEntity();
                log.setAction("Connexion");
                log.setIdEmploye(employeEntity.getId());
                log.setTemps(Timestamp.from(Instant.now()));
                logDao.saveOrUpdate(log);
            }
        });

        if (accountBoolean[0] && accountBoolean[1]){
            return 2;
        } else if (accountBoolean[0]) {
            return 1;
        } else {
            return 0;
        }
    }
}
