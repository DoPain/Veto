package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Veterinaire", schema = "PT_S4P1A_E1", catalog = "")
public class VeterinaireEntity {
    private long id;
    private byte[] signature;

    private Collection<OrdonnanceEntity> ordonnancesById;
    private Collection<RendezVousEntity> rendezVousById;
    private PersonneEntity personneById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return id == that.id &&
                Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @OneToMany(mappedBy = "veterinaireByIdVeterinaire")
    public Collection<OrdonnanceEntity> getOrdonnancesById() {
        return ordonnancesById;
    }

    public void setOrdonnancesById(Collection<OrdonnanceEntity> ordonnancesById) {
        this.ordonnancesById = ordonnancesById;
    }

    @OneToMany(mappedBy = "veterinaireByIdVeterinaire")
    public Collection<RendezVousEntity> getRendezVousById() {
        return rendezVousById;
    }

    public void setRendezVousById(Collection<RendezVousEntity> rendezVousById) {
        this.rendezVousById = rendezVousById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public PersonneEntity getPersonneById() {
        return personneById;
    }

    public void setPersonneById(PersonneEntity personneById) {
        this.personneById = personneById;
    }
}
