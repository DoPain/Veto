package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Race", schema = "PT_S4P1A_E1", catalog = "")
public class RaceEntity {
    private int idRace;
    private int idEspece;
    private String nom;
    private EspeceEntity especeByIdEspece;

    @Id
    @Column(name = "idRace", nullable = false)
    public int getIdRace() {
        return idRace;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }

    @Basic
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
        RaceEntity that = (RaceEntity) o;
        return idRace == that.idRace &&
                idEspece == that.idEspece &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRace, idEspece, nom);
    }

    @ManyToOne
    @JoinColumn(name = "idEspece", referencedColumnName = "idEspece", nullable = false)
    public EspeceEntity getEspeceByIdEspece() {
        return especeByIdEspece;
    }

    public void setEspeceByIdEspece(EspeceEntity especeByIdEspece) {
        this.especeByIdEspece = especeByIdEspece;
    }
}
