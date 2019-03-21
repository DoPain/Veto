package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Commander", schema = "PT_S4P1A_E1", catalog = "")
public class CommanderEntity {
    private long id;
    private long idProduit;
    private Integer quantite;
    private Double prix;
    private PanierEntity panierById;
    private ProduitEntity produitByIdProduit;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idProduit", nullable = false)
    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "quantite", nullable = true)
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Basic
    @Column(name = "prix", nullable = true, precision = 2)
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommanderEntity that = (CommanderEntity) o;
        return id == that.id &&
                idProduit == that.idProduit &&
                Objects.equals(quantite, that.quantite) &&
                Objects.equals(prix, that.prix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProduit, quantite, prix);
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public PanierEntity getPanierById() {
        return panierById;
    }

    public void setPanierById(PanierEntity panierById) {
        this.panierById = panierById;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "idProduit", referencedColumnName = "id", nullable = false)
    public ProduitEntity getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(ProduitEntity produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
