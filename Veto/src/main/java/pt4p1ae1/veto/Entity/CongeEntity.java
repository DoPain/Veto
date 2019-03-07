package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Conge", schema = "PT_S4P1A_E1", catalog = "")
public class CongeEntity {
    private long idConge;
    private long idEmploye;
    private long idVeterinaire;
    private Timestamp dateDebut;
    private Timestamp datefin;
    private EmployeEntity employeByIdEmploye;
    private VeterinaireEntity veterinaireByIdVeterinaire;

    @Id
    @Column(name = "idConge", nullable = false)
    public long getIdConge() {
        return idConge;
    }

    public void setIdConge(long idConge) {
        this.idConge = idConge;
    }

    @Basic
    @Column(name = "idEmploye", nullable = false)
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
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
    @Column(name = "dateDebut", nullable = false)
    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "DATEFIN", nullable = false)
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
        CongeEntity that = (CongeEntity) o;
        return idConge == that.idConge &&
                idEmploye == that.idEmploye &&
                idVeterinaire == that.idVeterinaire &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(datefin, that.datefin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConge, idEmploye, idVeterinaire, dateDebut, datefin);
    }

    @ManyToOne
    @JoinColumn(name = "idEmploye", referencedColumnName = "idEmploye", nullable = false)
    public EmployeEntity getEmployeByIdEmploye() {
        return employeByIdEmploye;
    }

    public void setEmployeByIdEmploye(EmployeEntity employeByIdEmploye) {
        this.employeByIdEmploye = employeByIdEmploye;
    }

    @ManyToOne
    @JoinColumn(name = "idVeterinaire", referencedColumnName = "idVeterinaire", nullable = false)
    public VeterinaireEntity getVeterinaireByIdVeterinaire() {
        return veterinaireByIdVeterinaire;
    }

    public void setVeterinaireByIdVeterinaire(VeterinaireEntity veterinaireByIdVeterinaire) {
        this.veterinaireByIdVeterinaire = veterinaireByIdVeterinaire;
    }
}
