package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RendezVous", schema = "PT_S4P1A_E1", catalog = "")
public class RendezVousEntity {
    private long id;
    private Long idAnimal;
    private Long idVeterinaire;
    private Timestamp dateHeureDebut;
    private Timestamp dateHeureFin;
    private String message;
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
    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "idVeterinaire", nullable = true)
    public Long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(Long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateHeureDebut", nullable = false)
    public Timestamp getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Timestamp dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    @Basic
    @Column(name = "dateHeureFin", nullable = false)
    public Timestamp getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(Timestamp dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 255)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAnimal, idVeterinaire, dateHeureDebut, dateHeureFin, message);
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
