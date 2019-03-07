package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Commander", schema = "PT_S4P1A_E1", catalog = "")
@IdClass(CommanderEntityPK.class)
public class CommanderEntity {
    private long idVente;
    private short idProduit;
    private Integer quantitesortie;
    private Double prixvente;
    private PanierEntity panierByIdVente;
    private ProduitEntity produitByIdProduit;

    @Id
    @Column(name = "idVente", nullable = false)
    public long getIdVente() {
        return idVente;
    }

    public void setIdVente(long idVente) {
        this.idVente = idVente;
    }

    @Id
    @Column(name = "idProduit", nullable = false)
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "QUANTITESORTIE", nullable = true)
    public Integer getQuantitesortie() {
        return quantitesortie;
    }

    public void setQuantitesortie(Integer quantitesortie) {
        this.quantitesortie = quantitesortie;
    }

    @Basic
    @Column(name = "PRIXVENTE", nullable = true, precision = 2)
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
        CommanderEntity that = (CommanderEntity) o;
        return idVente == that.idVente &&
                idProduit == that.idProduit &&
                Objects.equals(quantitesortie, that.quantitesortie) &&
                Objects.equals(prixvente, that.prixvente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVente, idProduit, quantitesortie, prixvente);
    }

    @ManyToOne
    @JoinColumn(name = "idVente", referencedColumnName = "idVente", nullable = false)
    public PanierEntity getPanierByIdVente() {
        return panierByIdVente;
    }

    public void setPanierByIdVente(PanierEntity panierByIdVente) {
        this.panierByIdVente = panierByIdVente;
    }

    @ManyToOne
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit", nullable = false)
    public ProduitEntity getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(ProduitEntity produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
