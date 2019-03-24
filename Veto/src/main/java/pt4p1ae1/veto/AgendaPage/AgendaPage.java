package pt4p1ae1.veto.AgendaPage;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
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
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Utils;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

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
    private RendezVousEntity selectedRDV;
    private VEvent selectedVEvent;
    public static HashMap<String, RendezVousEntity> vEventEntity;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vCalendar = new VCalendar();
        agendaHome = new NewICalendarAgenda(vCalendar);
        vEventEntity = new HashMap<>();
        datePicker.setValue(agendaHome.getDisplayedLocalDateTime().toLocalDate());
        BorderPane.setCenter(agendaHome);

        super.start();
        setActionButton();
        initializeAgenda();


    }

    private void initializeAgenda() {
        agendaHome.setSelectedOneAppointmentCallback(param ->
                {
                    Agenda.Appointment selectedAppointment = (Agenda.Appointment) param;
                    selectedVEvent = (VEvent) agendaHome.getAppointmentVComponentMap()
                            .get(System.identityHashCode(selectedAppointment));
                    if (selectedVEvent == null) {
                        selectedVEvent = (VEvent) agendaHome.getVComponentFactory().createVComponent(selectedAppointment);
                    }
                    selectedRDV = RendezVousEntityOservable.toEntity(selectedVEvent);
                    modifyEvent.setDisable(false);

                    modifyButton.setOnAction(event -> {
                        if (animalBox.getValue() != null && clientBox.getValue() != null) {
                            selectedRDV.setIdAnimal(-1); //recup l'id de l'animal
                            selectedRDV.setIdVeterinaire(-1); //recup l'id du client
                            vEventEntity.put(selectedVEvent.getUniqueIdentifier().getValue(), selectedRDV);
                            System.out.println("insérer event");
                        }
                    });
                    return null;
                }
        );

        ObservableList<ClientEntity> clientEntities = new SimpleListProperty<ClientEntity>();
        clientEntities.addAll(Utils.CLIENT_DAO.findAll());
        clientBox.setItems(clientEntities);
        ClientEntity client = (ClientEntity) clientBox.getValue();

        ObservableList<AnimalEntity> animalEntities= new SimpleListProperty<AnimalEntity>();
        animalEntities.addAll(Utils.getAnimalFromClient(client.getId()));
        animalBox.setItems(animalEntities);

        clientBox.setOnAction(event -> {
            ClientEntity newClient = (ClientEntity) clientBox.getValue();
            animalEntities.clear();
            animalEntities.addAll(Utils.getAnimalFromClient(newClient.getId()));
            animalBox.setItems(animalEntities);
        });
    }

    private void setActionButton() {
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
        Utils.RENDEZ_VOUS_DAO
        if (vEvents != null) {
            if (!vEvents.isEmpty()) {
                vEvents.forEach(vEvent -> {
                    RendezVousEntity rdv;
                    String UID = vEvent.getUniqueIdentifier().getValue();
                    if (vEventEntity.containsKey(UID)) {
                        rdv = vEventEntity.get(UID);
                    } else {
                        rdv = RendezVousEntityOservable.toEntity(vEvent);
                    }
                    Utils.RENDEZ_VOUS_DAO.saveOrUpdate(rdv);
                });
                vEventEntity.keySet().forEach(s -> {
                    boolean exist = false;
                    Iterator<VEvent> iterator = vEvents.iterator();
                    while (!exist && iterator.hasNext()) {
                        exist = iterator.next().getUniqueIdentifier().getValue().equals(s);
                    }
                    if (!exist) {
                        vEventEntity.remove(s);
                    }
                });
            }
        }
    }
}
