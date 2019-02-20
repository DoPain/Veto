package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Traitement {
    private int idTraitement;
    private long idOrdonnance;
    private Date dateDebut;
    private int dureeJour;
    private String produitPrescrit;
    private String posologie;
    private String methodeAdministration;

    @Id
    @Column(name = "idTraitement")
    public int getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(int idTraitement) {
        this.idTraitement = idTraitement;
    }

    @Basic
    @Column(name = "idOrdonnance")
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Basic
    @Column(name = "dateDebut")
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "dureeJour")
    public int getDureeJour() {
        return dureeJour;
    }

    public void setDureeJour(int dureeJour) {
        this.dureeJour = dureeJour;
    }

    @Basic
    @Column(name = "produitPrescrit")
    public String getProduitPrescrit() {
        return produitPrescrit;
    }

    public void setProduitPrescrit(String produitPrescrit) {
        this.produitPrescrit = produitPrescrit;
    }

    @Basic
    @Column(name = "posologie")
    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    @Basic
    @Column(name = "methodeAdministration")
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
        Traitement that = (Traitement) o;
        return idTraitement == that.idTraitement &&
                idOrdonnance == that.idOrdonnance &&
                dureeJour == that.dureeJour &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(produitPrescrit, that.produitPrescrit) &&
                Objects.equals(posologie, that.posologie) &&
                Objects.equals(methodeAdministration, that.methodeAdministration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTraitement, idOrdonnance, dateDebut, dureeJour, produitPrescrit, posologie, methodeAdministration);
    }
}
