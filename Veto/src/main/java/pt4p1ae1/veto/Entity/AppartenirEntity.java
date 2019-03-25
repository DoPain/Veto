package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Appartenir", schema = "PT_S4P1A_E1", catalog = "")
public class AppartenirEntity {
    private long id;
    private long idOrdonnance;
    private long idProduit;
    private int quantite;
    private OrdonnanceEntity ordonnanceByIdOrdonnance;
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
    @Column(name = "idOrdonnance", nullable = false)
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
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
    @Column(name = "quantite", nullable = false)
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppartenirEntity that = (AppartenirEntity) o;
        return id == that.id &&
                idOrdonnance == that.idOrdonnance &&
                idProduit == that.idProduit &&
                quantite == that.quantite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idOrdonnance, idProduit, quantite);
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false, name = "idOrdonnance", referencedColumnName = "id", nullable = false)
    public OrdonnanceEntity getOrdonnanceByIdOrdonnance() {
        return ordonnanceByIdOrdonnance;
    }

    public void setOrdonnanceByIdOrdonnance(OrdonnanceEntity ordonnanceByIdOrdonnance) {
        this.ordonnanceByIdOrdonnance = ordonnanceByIdOrdonnance;
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false, name = "idProduit", referencedColumnName = "id", nullable = false)
    public ProduitEntity getProduitByIdProduit() {
        return produitByIdProduit;
    }

    public void setProduitByIdProduit(ProduitEntity produitByIdProduit) {
        this.produitByIdProduit = produitByIdProduit;
    }
}
