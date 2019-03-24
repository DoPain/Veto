package pt4p1ae1.veto.AgendaPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import jfxtras.icalendarfx.VCalendar;
import jfxtras.icalendarfx.components.VEvent;
import jfxtras.scene.control.agenda.Agenda;
import pt4p1ae1.veto.AgendaPage.ModifiedICalendarAgenda.NewICalendarAgenda;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.ResourceBundle;

public class AgendaPage extends ControllerSample implements Initializable {

    @FXML
    public ChoiceBox animalBox;
    @FXML
    public ChoiceBox clientBox;
    @FXML
    public Button modifyButton;
    @FXML
    public VBox modifyEvent;
    @FXML
    private BorderPane BorderPane;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button increase_btn;
    @FXML
    private Button decrease_btn;
    @FXML
    private Button save_btn;
    private VCalendar vCalendar;
    private static NewICalendarAgenda agendaHome;
    private AvoirRendezVousEntity selectedRDV;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vCalendar = new VCalendar();
        agendaHome = new NewICalendarAgenda(vCalendar);
        datePicker.setValue(agendaHome.getDisplayedLocalDateTime().toLocalDate());
        BorderPane.setCenter(agendaHome);

        super.start();
        setActionButton();
        initializeAgenda();


    }

    private void initializeAgenda(){
        agendaHome.setSelectedOneAppointmentCallback(param ->
                {
                    Agenda.Appointment selectedAppointment = (Agenda.Appointment)param;
                    VEvent event = (VEvent)agendaHome.getAppointmentVComponentMap()
                            .get(System.identityHashCode(selectedAppointment));
                    if (event == null)
                    {
                        event = (VEvent)agendaHome.getVComponentFactory().createVComponent(selectedAppointment);
                    }
                    selectedRDV = AvoirRendezVousEntityOservable.toEntity(event);
                    modifyEvent.setDisable(false);
                    System.out.println("insérer l'event");
                    return null;
                }
        );

        /*
        clientBox.setItems(null); //mettre la liste des clients
        clientBox.setOnAction(event -> {
            animalBox.setItems(null); //mettre la liste d'animaux du client
        });
        animalBox.setItems(null); //mettre la liste des animaux du client de base
        */

        modifyButton.setOnAction(event -> {
            if(animalBox.getValue()!=null && clientBox.getValue()!=null){
                selectedRDV.setIdAnimal(-1); //recup l'id de l'animal
                selectedRDV.setIdVeterinaire(-1); //recup l'id du client
                System.out.println("insérer event");
            }
        });

    }

    private void setActionButton(){
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

        save_btn.setOnAction(event -> {
            saveEvents();
        });

        datePicker.setOnAction(event -> {
            LocalDateTime newLocalDateTime = datePicker.getValue().atStartOfDay();
            agendaHome.setDisplayedLocalDateTime(newLocalDateTime);
        });

    }

    static public void saveEvents() {
        List<VEvent> vEvents = agendaHome.getVCalendar().getVEvents();
        if (vEvents != null) {
            if (!vEvents.isEmpty()) {
                vEvents.forEach(vEvent -> {
                    AvoirRendezVousEntity rdv = AvoirRendezVousEntityOservable.toEntity(vEvent);

                    System.out.println("insérer event");
                });
            }
        }
    }
}
