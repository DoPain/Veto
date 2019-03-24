package pt4p1ae1.veto.AgendaPage;

import jfxtras.icalendarfx.components.VEvent;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class AvoirRendezVousEntityOservable {
    private AvoirRendezVousEntity rendezVousEntity;
    private long id;
    private long idAnimal;
    private long idVeterinaire;
    private Timestamp dateHeure;
    private int dureeMinutes;
    private String message;
    private AnimalEntity animalByIdAnimal;
    private VeterinaireEntity veterinaireByIdVeterinaire;


    public static AvoirRendezVousEntity toEntity(VEvent vEvent){
        AvoirRendezVousEntity rdv = new AvoirRendezVousEntity();
        Temporal temporal = vEvent.getDateTimeStart().getValue();
        rdv.setDateHeure(Timestamp.valueOf(LocalDateTime.from(temporal)));
        rdv.setDureeMinutes(10);
        rdv.setMessage(vEvent.getSummary().getValue());
        return rdv;
    }
}
