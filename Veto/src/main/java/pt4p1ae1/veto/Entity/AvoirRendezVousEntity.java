package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "AvoirRendezVous", schema = "PT_S4P1A_E1", catalog = "")
public class AvoirRendezVousEntity {
    private long id;
    private long idClient;
    private long idVeterinaire;
    private Timestamp dateHeure;
    private int dureeMinutes;
    private String message;
    private ClientEntity clientByIdClient;
    private VeterinaireEntity veterinaireByIdVeterinaire;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idClient", nullable = false)
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "idVeterinaire", nullable = false)
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateHeure", nullable = false)
    public Timestamp getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Timestamp dateHeure) {
        this.dateHeure = dateHeure;
    }

    @Basic
    @Column(name = "dureeMinutes", nullable = false)
    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 255)
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
        AvoirRendezVousEntity that = (AvoirRendezVousEntity) o;
        return id == that.id &&
                idClient == that.idClient &&
                idVeterinaire == that.idVeterinaire &&
                dureeMinutes == that.dureeMinutes &&
                Objects.equals(dateHeure, that.dateHeure) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, idVeterinaire, dateHeure, dureeMinutes, message);
    }

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(name = "idVeterinaire", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VeterinaireEntity getVeterinaireByIdVeterinaire() {
        return veterinaireByIdVeterinaire;
    }

    public void setVeterinaireByIdVeterinaire(VeterinaireEntity veterinaireByIdVeterinaire) {
        this.veterinaireByIdVeterinaire = veterinaireByIdVeterinaire;
    }
}
