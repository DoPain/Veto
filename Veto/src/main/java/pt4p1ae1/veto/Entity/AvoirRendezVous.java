package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(AvoirRendezVousPK.class)
public class AvoirRendezVous {
    private long idClient;
    private long idVeterinaire;
    private Timestamp dateHeure;
    private int dureeMinutes;
    private String message;

    @Id
    @Column(name = "idClient")
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Id
    @Column(name = "idVeterinaire")
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateHeure")
    public Timestamp getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Timestamp dateHeure) {
        this.dateHeure = dateHeure;
    }

    @Basic
    @Column(name = "dureeMinutes")
    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirRendezVous that = (AvoirRendezVous) o;
        return idClient == that.idClient &&
                idVeterinaire == that.idVeterinaire &&
                dureeMinutes == that.dureeMinutes &&
                Objects.equals(dateHeure, that.dateHeure) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idVeterinaire, dateHeure, dureeMinutes, message);
    }
}
