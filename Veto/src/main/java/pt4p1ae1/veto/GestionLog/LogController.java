package pt4p1ae1.veto.GestionLog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.Entity.LogEntity;

import java.net.URL;

import java.sql.Timestamp;

import java.util.List;
import java.util.ResourceBundle;

public class LogController extends ControllerSample implements Initializable {

    @FXML
    public VBox vbox;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public TableView<LogEntityObservable> tableView;
    @FXML
    private TableColumn<LogEntityObservable, String> action;
    @FXML
    private TableColumn<LogEntityObservable, String> employeNom;
    @FXML
    private TableColumn<LogEntityObservable, String> employePrenom;
    @FXML
    private TableColumn<LogEntityObservable, Timestamp> temps;
    @FXML
    public BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

        employeNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        employePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        temps.setCellValueFactory(new PropertyValueFactory<>("temps"));

        ObservableList<LogEntityObservable> observableList = FXCollections.observableArrayList();

        List<LogEntity> logs = DaoFactory.getDaoFor(LogEntity.class).findAll();

        for (LogEntity log : logs)
            observableList.add(new LogEntityObservable(log));

        tableView.setItems(observableList);
    }
}
