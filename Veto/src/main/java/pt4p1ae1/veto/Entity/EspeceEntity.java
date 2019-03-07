package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Espece", schema = "PT_S4P1A_E1", catalog = "")
public class EspeceEntity {
    private int idEspece;
    private String nom;
    private Collection<AnimalEntity> animalsByIdEspece;
    private Collection<RaceEntity> racesByIdEspece;

    @Id
    @Column(name = "idEspece", nullable = false)
    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
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
        EspeceEntity that = (EspeceEntity) o;
        return idEspece == that.idEspece &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspece, nom);
    }

    @OneToMany(mappedBy = "especeByIdEspece")
    public Collection<AnimalEntity> getAnimalsByIdEspece() {
        return animalsByIdEspece;
    }

    public void setAnimalsByIdEspece(Collection<AnimalEntity> animalsByIdEspece) {
        this.animalsByIdEspece = animalsByIdEspece;
    }

    @OneToMany(mappedBy = "especeByIdEspece")
    public Collection<RaceEntity> getRacesByIdEspece() {
        return racesByIdEspece;
    }

    public void setRacesByIdEspece(Collection<RaceEntity> racesByIdEspece) {
        this.racesByIdEspece = racesByIdEspece;
    }
}
