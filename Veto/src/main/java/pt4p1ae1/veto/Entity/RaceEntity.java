package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Race", schema = "PT_S4P1A_E1", catalog = "")
public class RaceEntity {
    private long id;
    private long idEspece;
    private String nom;
    private Collection<AnimalEntity> animalsById;
    private EspeceEntity especeByIdEspece;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idEspece", nullable = false)
    public long getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(long idEspece) {
        this.idEspece = idEspece;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 32)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceEntity that = (RaceEntity) o;
        return id == that.id &&
                idEspece == that.idEspece &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEspece, nom);
    }

    @OneToMany(mappedBy = "raceByIdRace")
    public Collection<AnimalEntity> getAnimalsById() {
        return animalsById;
    }

    public void setAnimalsById(Collection<AnimalEntity> animalsById) {
        this.animalsById = animalsById;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "idEspece", referencedColumnName = "id", nullable = false)
    public EspeceEntity getEspeceByIdEspece() {
        return especeByIdEspece;
    }

    public void setEspeceByIdEspece(EspeceEntity especeByIdEspece) {
        this.especeByIdEspece = especeByIdEspece;
    }
}
