package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Espece", schema = "PT_S4P1A_E1", catalog = "")
public class EspeceEntity {
    private long id;
    private String nom;
    private Collection<RaceEntity> racesById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        EspeceEntity that = (EspeceEntity) o;
        return id == that.id &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @OneToMany( mappedBy = "especeByIdEspece")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<RaceEntity> getRacesById() {
        return racesById;
    }

    public void setRacesById(Collection<RaceEntity> racesById) {
        this.racesById = racesById;
    }
}
