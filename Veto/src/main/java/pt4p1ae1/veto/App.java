package pt4p1ae1.veto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt4p1ae1.veto.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/authentification.fxml"));
        primaryStage.setTitle("nameToChoose");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
