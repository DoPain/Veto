package HomePage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import jfxtras.labs.icalendaragenda.scene.control.agenda.ICalendarAgenda;
import jfxtras.labs.icalendarfx.VCalendar;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ResourceBundle;

public class HomePage implements Initializable {

    @FXML
    private BorderPane pane;
    private VCalendar vCalendar;
    private ICalendarAgenda agendaHome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vCalendar = new VCalendar();
        agendaHome = new ICalendarAgenda(vCalendar);
        pane.setCenter(agendaHome);
    }
    @FXML
    public void increaseBtnAction(){
        System.out.println(">");
        LocalDateTime newLocalDateTime = agendaHome.getDisplayedLocalDateTime().plus(Period.ofWeeks(1));
        agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
    }
    @FXML
    public void decreaseBtnAction(){
        LocalDateTime newLocalDateTime = agendaHome.getDisplayedLocalDateTime().minus(Period.ofWeeks(1));
        agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
    }
}
