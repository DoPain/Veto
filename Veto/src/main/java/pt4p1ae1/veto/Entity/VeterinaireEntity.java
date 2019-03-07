package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Veterinaire", schema = "PT_S4P1A_E1", catalog = "")
public class VeterinaireEntity {
    private long idVeterinaire;
    private byte[] signature;
    private Collection<AvoirRendezVousEntity> avoirRendezVousByIdVeterinaire;
    private Collection<CongeEntity> congesByIdVeterinaire;
    private Collection<OrdonnanceEntity> ordonnancesByIdVeterinaire;
    private EmployeEntity employeByIdVeterinaire;

    @Id
    @Column(name = "idVeterinaire", nullable = false)
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "signature", nullable = true)
    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeterinaireEntity that = (VeterinaireEntity) o;
        return idVeterinaire == that.idVeterinaire &&
                Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idVeterinaire);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @OneToMany(mappedBy = "veterinaireByIdVeterinaire")
    public Collection<AvoirRendezVousEntity> getAvoirRendezVousByIdVeterinaire() {
        return avoirRendezVousByIdVeterinaire;
    }

    public void setAvoirRendezVousByIdVeterinaire(Collection<AvoirRendezVousEntity> avoirRendezVousByIdVeterinaire) {
        this.avoirRendezVousByIdVeterinaire = avoirRendezVousByIdVeterinaire;
    }

    @OneToMany(mappedBy = "veterinaireByIdVeterinaire")
    public Collection<CongeEntity> getCongesByIdVeterinaire() {
        return congesByIdVeterinaire;
    }

    public void setCongesByIdVeterinaire(Collection<CongeEntity> congesByIdVeterinaire) {
        this.congesByIdVeterinaire = congesByIdVeterinaire;
    }

    @OneToMany(mappedBy = "veterinaireByIdVeterinaire")
    public Collection<OrdonnanceEntity> getOrdonnancesByIdVeterinaire() {
        return ordonnancesByIdVeterinaire;
    }

    public void setOrdonnancesByIdVeterinaire(Collection<OrdonnanceEntity> ordonnancesByIdVeterinaire) {
        this.ordonnancesByIdVeterinaire = ordonnancesByIdVeterinaire;
    }

    @OneToOne
    @JoinColumn(name = "idVeterinaire", referencedColumnName = "idEmploye", nullable = false)
    public EmployeEntity getEmployeByIdVeterinaire() {
        return employeByIdVeterinaire;
    }

    public void setEmployeByIdVeterinaire(EmployeEntity employeByIdVeterinaire) {
        this.employeByIdVeterinaire = employeByIdVeterinaire;
    }
}
