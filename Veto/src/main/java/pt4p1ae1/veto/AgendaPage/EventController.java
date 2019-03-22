package pt4p1ae1.veto.AgendaPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt4p1ae1.veto.ControllerSample;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class EventController extends ControllerSample implements Initializable {

    @FXML
    public VBox vbox;
    @FXML
    public TableView<EventEntityObservable> tableView;
    @FXML
    private TableColumn<EventEntityObservable, String> action;
    @FXML
    private TableColumn<EventEntityObservable, String> employeNom;
    @FXML
    private TableColumn<EventEntityObservable, String> employePrenom;
    @FXML
    private TableColumn<EventEntityObservable, Timestamp> temps;
    @FXML
    public BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.start();

//        employeNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        employePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//        action.setCellValueFactory(new PropertyValueFactory<>("action"));
//        temps.setCellValueFactory(new PropertyValueFactory<>("temps"));
//
//        ObservableList<EventEntityObservable> observableList = FXCollections.observableArrayList();
//
//        List<LogEntity> logs = Utils.logDao.findAll();
//
//        for (LogEntity log : logs)
//            observableList.add(new EventEntityObservable(log));
//
//        tableView.setItems(observableList);
    }
}
