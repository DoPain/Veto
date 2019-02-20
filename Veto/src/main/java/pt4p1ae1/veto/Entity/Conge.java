package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Conge {
    private long idConge;
    private long idEmploye;
    private long idVeterinaire;
    private Timestamp dateDebut;
    private Timestamp datefin;

    @Id
    @Column(name = "idConge")
    public long getIdConge() {
        return idConge;
    }

    public void setIdConge(long idConge) {
        this.idConge = idConge;
    }

    @Basic
    @Column(name = "idEmploye")
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "idVeterinaire")
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateDebut")
    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "DATEFIN")
    public Timestamp getDatefin() {
        return datefin;
    }

    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conge conge = (Conge) o;
        return idConge == conge.idConge &&
                idEmploye == conge.idEmploye &&
                idVeterinaire == conge.idVeterinaire &&
                Objects.equals(dateDebut, conge.dateDebut) &&
                Objects.equals(datefin, conge.datefin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConge, idEmploye, idVeterinaire, dateDebut, datefin);
    }
}
