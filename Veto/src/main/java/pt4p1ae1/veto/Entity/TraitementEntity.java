package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Traitement", schema = "PT_S4P1A_E1", catalog = "")
public class TraitementEntity {
    private long id;
    private long idOrdonnance;
    private Date dateDebut;
    private int dureeJour;
    private String produitPrescrit;
    private String posologie;
    private String methodeAdministration;
    private OrdonnanceEntity ordonnanceByIdOrdonnance;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idOrdonnance", nullable = false)
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Basic
    @Column(name = "dateDebut", nullable = false)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "dureeJour", nullable = false)
    public int getDureeJour() {
        return dureeJour;
    }

    public void setDureeJour(int dureeJour) {
        this.dureeJour = dureeJour;
    }

    @Basic
    @Column(name = "produitPrescrit", nullable = false, length = 32)
    public String getProduitPrescrit() {
        return produitPrescrit;
    }

    public void setProduitPrescrit(String produitPrescrit) {
        this.produitPrescrit = produitPrescrit;
    }

    @Basic
    @Column(name = "posologie", nullable = false, length = 32)
    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    @Basic
    @Column(name = "methodeAdministration", nullable = false, length = 32)
    public String getMethodeAdministration() {
        return methodeAdministration;
    }

    public void setMethodeAdministration(String methodeAdministration) {
        this.methodeAdministration = methodeAdministration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraitementEntity that = (TraitementEntity) o;
        return id == that.id &&
                idOrdonnance == that.idOrdonnance &&
                dureeJour == that.dureeJour &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(produitPrescrit, that.produitPrescrit) &&
                Objects.equals(posologie, that.posologie) &&
                Objects.equals(methodeAdministration, that.methodeAdministration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idOrdonnance, dateDebut, dureeJour, produitPrescrit, posologie, methodeAdministration);
    }

    @ManyToOne
    @JoinColumn(name = "idOrdonnance", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public OrdonnanceEntity getOrdonnanceByIdOrdonnance() {
        return ordonnanceByIdOrdonnance;
    }

    public void setOrdonnanceByIdOrdonnance(OrdonnanceEntity ordonnanceByIdOrdonnance) {
        this.ordonnanceByIdOrdonnance = ordonnanceByIdOrdonnance;
    }
}
