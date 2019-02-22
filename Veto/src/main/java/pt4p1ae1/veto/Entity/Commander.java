package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CommanderPK.class)
public class Commander {
    private long idVente;
    private short idProduit;
    private Integer quantitesortie;
    private Double prixvente;

    @Id
    @Column(name = "idVente")
    public long getIdVente() {
        return idVente;
    }

    public void setIdVente(long idVente) {
        this.idVente = idVente;
    }

    @Id
    @Column(name = "idProduit")
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "QUANTITESORTIE")
    public Integer getQuantitesortie() {
        return quantitesortie;
    }

    public void setQuantitesortie(Integer quantitesortie) {
        this.quantitesortie = quantitesortie;
    }

    @Basic
    @Column(name = "PRIXVENTE")
    public Double getPrixvente() {
        return prixvente;
    }

    public void setPrixvente(Double prixvente) {
        this.prixvente = prixvente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commander commander = (Commander) o;
        return idVente == commander.idVente &&
                idProduit == commander.idProduit &&
                Objects.equals(quantitesortie, commander.quantitesortie) &&
                Objects.equals(prixvente, commander.prixvente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVente, idProduit, quantitesortie, prixvente);
    }
}
