package pt4p1ae1.veto.AgendaPage;


import pt4p1ae1.veto.Entity.LogEntity;

import java.sql.Timestamp;

public class EventEntityObservable {
    private String nom;
    private String prenom;
    private String action;
    private Timestamp temps;

    public EventEntityObservable(LogEntity log) {
        this.nom = log.getEmployeByIdEmploye().getPersonneById().getNom();
        this.prenom = log.getEmployeByIdEmploye().getPersonneById().getPrenom();
        this.action = log.getAction();
        this.temps = log.getTemps();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAction() {
        return action;
    }

    public Timestamp getTemps() {
        return temps;
    }
}