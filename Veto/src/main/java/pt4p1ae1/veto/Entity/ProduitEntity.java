package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Produit", schema = "PT_S4P1A_E1", catalog = "")
public class ProduitEntity {
    private long id;
    private String nom;
    private int quantiteEnStock;
    private int quantiteMinimum;
    private double prix;
    private Collection<AppartenirEntity> appartenirsById;
    private Collection<CommanderEntity> commandersById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "quantiteEnStock", nullable = false)
    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Basic
    @Column(name = "quantiteMinimum", nullable = false)
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
        return id == that.id &&
                quantiteEnStock == that.quantiteEnStock &&
                quantiteMinimum == that.quantiteMinimum &&
                Double.compare(that.prix, prix) == 0 &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, quantiteEnStock, quantiteMinimum, prix);
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    public Collection<AppartenirEntity> getAppartenirsById() {
        return appartenirsById;
    }

    public void setAppartenirsById(Collection<AppartenirEntity> appartenirsById) {
        this.appartenirsById = appartenirsById;
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    public Collection<CommanderEntity> getCommandersById() {
        return commandersById;
    }

    public void setCommandersById(Collection<CommanderEntity> commandersById) {
        this.commandersById = commandersById;
    }
}
