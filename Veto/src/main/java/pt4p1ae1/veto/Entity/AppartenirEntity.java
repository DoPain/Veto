package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Appartenir", schema = "PT_S4P1A_E1", catalog = "")
@IdClass(AppartenirEntityPK.class)
public class AppartenirEntity {
    private long idOrdonnance;
    private short idProduit;
    private OrdonnanceEntity ordonnanceByIdOrdonnance;
    private ProduitEntity produitByIdProduit;

    @Id
    @Column(name = "idOrdonnance", nullable = false)
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Id
    @Column(name = "idProduit", nullable = false)
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppartenirEntity that = (AppartenirEntity) o;
        return idOrdonnance == that.idOrdonnance &&
                idProduit == that.idProduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrdonnance, idProduit);
    }

    @ManyToOne
    @JoinColumn(name = "idOrdonnance", referencedColumnName = "idOrdonnance", nullable = false)
    public OrdonnanceEntity getOrdonnanceByIdOrdonnance() {
        return ordonnanceByIdOrdonnance;
    }

    public void setOrdonnanceByIdOrdonnance(OrdonnanceEntity ordonnanceByIdOrdonnance) {
        this.ordonnanceByIdOrdonnance = ordonnanceByIdOrdonnance;
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
