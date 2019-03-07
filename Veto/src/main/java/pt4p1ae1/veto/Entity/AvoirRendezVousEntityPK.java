package pt4p1ae1.veto.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AvoirRendezVousEntityPK implements Serializable {
    private long idClient;
    private long idVeterinaire;

    @Column(name = "idClient", nullable = false)
    @Id
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Column(name = "idVeterinaire", nullable = false)
    @Id
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirRendezVousEntityPK that = (AvoirRendezVousEntityPK) o;
        return idClient == that.idClient &&
                idVeterinaire == that.idVeterinaire;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idVeterinaire);
    }
}
