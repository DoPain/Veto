package pt4p1ae1.veto.AgendaPage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import jfxtras.icalendarfx.VCalendar;
import jfxtras.icalendarfx.components.VEvent;
import jfxtras.icalendarfx.utilities.ICalendarUtilities;
import jfxtras.scene.control.agenda.icalendar.ICalendarAgenda;
import pt4p1ae1.veto.ControllerSample;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ResourceBundle;

public class AgendaPage extends ControllerSample implements Initializable{

    @FXML
    private BorderPane BorderPane;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button increase_btn;
    @FXML
    private Button decrease_btn;
    private VCalendar vCalendar;
    private ICalendarAgenda agendaHome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vCalendar = new VCalendar();
        agendaHome = new ICalendarAgenda(vCalendar);
        datePicker.setValue(agendaHome.getDisplayedLocalDateTime().toLocalDate());
        BorderPane.setCenter(agendaHome);

        super.start();

        increase_btn.setOnAction(event -> {
            LocalDateTime newLocalDateTime = agendaHome.getDisplayedLocalDateTime().plus(Period.ofWeeks(1));
            agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
            datePicker.setValue(newLocalDateTime.toLocalDate());
        });

        decrease_btn.setOnAction(event -> {
            LocalDateTime newLocalDateTime = agendaHome.getDisplayedLocalDateTime().minus(Period.ofWeeks(1));
            agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
            datePicker.setValue(newLocalDateTime.toLocalDate());
        });

        datePicker.setOnAction(event -> {
            LocalDateTime newLocalDateTime = datePicker.getValue().atStartOfDay();
            agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
            System.out.println(vCalendar.toString());
        });
        //TODO use this method to save events in file or base and use this information to fill the vCalenda

    }
}
