package pt4p1ae1.veto.AgendaPage;

import jfxtras.icalendarfx.components.VEvent;
import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Entity.VeterinaireEntity;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class RendezVousEntityOservable {
    private RendezVousEntity rendezVousEntity;
    private long id;
    private long idAnimal;
    private long idVeterinaire;
    private Timestamp start;
    private Timestamp end;
    private String message;
    private AnimalEntity animalByIdAnimal;
    private VeterinaireEntity veterinaireByIdVeterinaire;


    public static RendezVousEntity toEntity(VEvent vEvent){
        RendezVousEntity rdv = new RendezVousEntity();
        Temporal temporalStart = vEvent.getDateTimeStart().getValue();
        rdv.setDateHeureDebut(Timestamp.valueOf(LocalDateTime.from(temporalStart)));
        Temporal temporalEnd = vEvent.getDateTimeStart().getValue();
        rdv.setDateHeureFin(Timestamp.valueOf(LocalDateTime.from(temporalEnd)));
        rdv.setMessage(vEvent.getSummary().getValue());
        return rdv;
    }
}
