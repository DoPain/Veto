package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Produit", schema = "PT_S4P1A_E1", catalog = "")
public class ProduitEntity {
    private short idProduit;
    private String nom;
    private int quantiteEnStock;
    private int quantiteMinimum;
    private double prix;
    private Collection<AppartenirEntity> appartenirsByIdProduit;
    private Collection<CommanderEntity> commandersByIdProduit;

    @Id
    @Column(name = "idProduit", nullable = false)
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "QuantiteEnStock", nullable = false)
    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Basic
    @Column(name = "QuantiteMinimum", nullable = false)
    public int getQuantiteMinimum() {
        return quantiteMinimum;
    }

    public void setQuantiteMinimum(int quantiteMinimum) {
        this.quantiteMinimum = quantiteMinimum;
    }

    @Basic
    @Column(name = "prix", nullable = false, precision = 2)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitEntity that = (ProduitEntity) o;
        return idProduit == that.idProduit &&
                quantiteEnStock == that.quantiteEnStock &&
                quantiteMinimum == that.quantiteMinimum &&
                Double.compare(that.prix, prix) == 0 &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit, nom, quantiteEnStock, quantiteMinimum, prix);
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    public Collection<AppartenirEntity> getAppartenirsByIdProduit() {
        return appartenirsByIdProduit;
    }

    public void setAppartenirsByIdProduit(Collection<AppartenirEntity> appartenirsByIdProduit) {
        this.appartenirsByIdProduit = appartenirsByIdProduit;
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    public Collection<CommanderEntity> getCommandersByIdProduit() {
        return commandersByIdProduit;
    }

    public void setCommandersByIdProduit(Collection<CommanderEntity> commandersByIdProduit) {
        this.commandersByIdProduit = commandersByIdProduit;
    }
}
