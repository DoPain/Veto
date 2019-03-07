package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ordonnance", schema = "PT_S4P1A_E1", catalog = "")
public class OrdonnanceEntity {
    private long idOrdonnance;
    private int idAnimal;
    private long idVeterinaire;
    private Timestamp dateOrdonnance;
    private String commentaire;
    private Collection<AppartenirEntity> appartenirsByIdOrdonnance;
    private AnimalEntity animalByIdAnimal;
    private VeterinaireEntity veterinaireByIdVeterinaire;
    private Collection<TraitementEntity> traitementsByIdOrdonnance;

    @Id
    @Column(name = "idOrdonnance", nullable = false)
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Basic
    @Column(name = "idAnimal", nullable = false)
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
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
    public Timestamp getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(Timestamp dateOrdonnance) {
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
        return idOrdonnance == that.idOrdonnance &&
                idAnimal == that.idAnimal &&
                idVeterinaire == that.idVeterinaire &&
                Objects.equals(dateOrdonnance, that.dateOrdonnance) &&
                Objects.equals(commentaire, that.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrdonnance, idAnimal, idVeterinaire, dateOrdonnance, commentaire);
    }

    @OneToMany(mappedBy = "ordonnanceByIdOrdonnance")
    public Collection<AppartenirEntity> getAppartenirsByIdOrdonnance() {
        return appartenirsByIdOrdonnance;
    }

    public void setAppartenirsByIdOrdonnance(Collection<AppartenirEntity> appartenirsByIdOrdonnance) {
        this.appartenirsByIdOrdonnance = appartenirsByIdOrdonnance;
    }

    @ManyToOne
    @JoinColumn(name = "idAnimal", referencedColumnName = "idAnimal", nullable = false)
    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "idVeterinaire", referencedColumnName = "idVeterinaire", nullable = false)
    public VeterinaireEntity getVeterinaireByIdVeterinaire() {
        return veterinaireByIdVeterinaire;
    }

    public void setVeterinaireByIdVeterinaire(VeterinaireEntity veterinaireByIdVeterinaire) {
        this.veterinaireByIdVeterinaire = veterinaireByIdVeterinaire;
    }

    @OneToMany(mappedBy = "ordonnanceByIdOrdonnance")
    public Collection<TraitementEntity> getTraitementsByIdOrdonnance() {
        return traitementsByIdOrdonnance;
    }

    public void setTraitementsByIdOrdonnance(Collection<TraitementEntity> traitementsByIdOrdonnance) {
        this.traitementsByIdOrdonnance = traitementsByIdOrdonnance;
    }
}
