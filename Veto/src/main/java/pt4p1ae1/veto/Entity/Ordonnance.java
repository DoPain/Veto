package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ordonnance {
    private long idOrdonnance;
    private int idAnimal;
    private long idVeterinaire;
    private Timestamp dateOrdonnance;
    private String commentaire;

    @Id
    @Column(name = "idOrdonnance")
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Basic
    @Column(name = "idAnimal")
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "idVeterinaire")
    public long getIdVeterinaire() {
        return idVeterinaire;
    }

    public void setIdVeterinaire(long idVeterinaire) {
        this.idVeterinaire = idVeterinaire;
    }

    @Basic
    @Column(name = "dateOrdonnance")
    public Timestamp getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(Timestamp dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    @Basic
    @Column(name = "commentaire")
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
        Ordonnance that = (Ordonnance) o;
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
}
