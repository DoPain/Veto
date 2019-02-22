package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Produit {
    private short idProduit;
    private String nom;
    private int quantiteEnStock;
    private int quantiteMinimum;
    private double prix;

    @Id
    @Column(name = "idProduit")
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "QuantiteEnStock")
    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Basic
    @Column(name = "QuantiteMinimum")
    public int getQuantiteMinimum() {
        return quantiteMinimum;
    }

    public void setQuantiteMinimum(int quantiteMinimum) {
        this.quantiteMinimum = quantiteMinimum;
    }

    @Basic
    @Column(name = "prix")
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
        Produit produit = (Produit) o;
        return idProduit == produit.idProduit &&
                quantiteEnStock == produit.quantiteEnStock &&
                quantiteMinimum == produit.quantiteMinimum &&
                Double.compare(produit.prix, prix) == 0 &&
                Objects.equals(nom, produit.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduit, nom, quantiteEnStock, quantiteMinimum, prix);
    }
}
