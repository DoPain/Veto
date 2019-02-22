package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Panier {
    private long idVente;
    private long idClient;
    private long idEmploye;
    private Date date;
    private double montantTotal;

    @Id
    @Column(name = "idVente")
    public long getIdVente() {
        return idVente;
    }

    public void setIdVente(long idVente) {
        this.idVente = idVente;
    }

    @Basic
    @Column(name = "idClient")
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "idEmploye")
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "montantTotal")
    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return idVente == panier.idVente &&
                idClient == panier.idClient &&
                idEmploye == panier.idEmploye &&
                Double.compare(panier.montantTotal, montantTotal) == 0 &&
                Objects.equals(date, panier.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVente, idClient, idEmploye, date, montantTotal);
    }
}
