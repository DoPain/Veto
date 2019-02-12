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
        Parent root = FXMLLoader.load(getClass().getResource("/agendaPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        try {
            DataBase dataBase = new DataBase();
            ResultSet resultSet = dataBase.getRace();
            while (resultSet.next()) {
                System.out.println("Espece : "
                        + resultSet.getString("nomEspece")
                        + " Race : "
                        + resultSet.getString("nomRace"));
            }
        } catch (SQLException s){
            System.out.println(s);
        }
    }
}
