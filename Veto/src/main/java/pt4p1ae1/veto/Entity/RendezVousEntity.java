package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RendezVous", schema = "PT_S4P1A_E1", catalog = "")
public class RendezVousEntity {
    private long id;
    private long idAnimal;
    private long idVeterinaire;
    private Timestamp dateHeureDebut;
    private Timestamp dateHeureFin;
    private String resume;
    private AnimalEntity animalByIdAnimal;
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
    @Column(name = "idAnimal", nullable = true)
    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "idVeterinaire", nullable = true)
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateHeureDebut", insertable = false,  updatable = false, nullable = false)
    public Timestamp getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Timestamp dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    @Basic
    @Column(name = "dateHeureDebut", insertable = false,  updatable = false, nullable = false)
    public Timestamp getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(Timestamp dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    @Basic
    @Column(name = "resume", nullable = true, length = 255)
    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVousEntity that = (RendezVousEntity) o;
        return id == that.id &&
                idAnimal == that.idAnimal &&
                idVeterinaire == that.idVeterinaire &&
                Objects.equals(dateHeureFin, that.dateHeureFin) &&
                Objects.equals(dateHeureDebut, that.dateHeureDebut) &&
                Objects.equals(resume, that.resume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAnimal, idVeterinaire, dateHeureDebut, dateHeureFin, resume);
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idAnimal", referencedColumnName = "id", nullable = false)
    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idVeterinaire", referencedColumnName = "id", nullable = false)
    public VeterinaireEntity getVeterinaireByIdVeterinaire() {
        return veterinaireByIdVeterinaire;
    }

    public void setVeterinaireByIdVeterinaire(VeterinaireEntity veterinaireByIdVeterinaire) {
        this.veterinaireByIdVeterinaire = veterinaireByIdVeterinaire;
    }
}
