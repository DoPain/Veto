package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Ordonnance", schema = "PT_S4P1A_E1", catalog = "")
public class OrdonnanceEntity {
    private long id;
    private long idAnimal;
    private long idVeterinaire;
    private Date dateOrdonnance;
    private String commentaire;
    private Collection<AppartenirEntity> appartenirsById;
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
    @Column(name = "idAnimal", nullable = false)
    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
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
    @Column(name = "dateOrdonnance", nullable = false)
    public Date getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(Date dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    @Basic
    @Column(name = "commentaire", nullable = true, length = 32)
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdonnanceEntity that = (OrdonnanceEntity) o;
        return id == that.id &&
                idAnimal == that.idAnimal &&
                idVeterinaire == that.idVeterinaire &&
                Objects.equals(dateOrdonnance, that.dateOrdonnance) &&
                Objects.equals(commentaire, that.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAnimal, idVeterinaire, dateOrdonnance, commentaire);
    }

    @OneToMany(mappedBy = "ordonnanceByIdOrdonnance")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<AppartenirEntity> getAppartenirsById() {
        return appartenirsById;
    }

    public void setAppartenirsById(Collection<AppartenirEntity> appartenirsById) {
        this.appartenirsById = appartenirsById;
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
