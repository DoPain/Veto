package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Produit", schema = "PT_S4P1A_E1", catalog = "")
public class ProduitEntity {
    private long id;
    private String nom;
    private String refProduit;
    private int quantiteEnStock;
    private double prix;
    private Integer quantiteMinimum;
    private Date peremption;
    private Date dateAcquisition;
    private String description;
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
    @Column(name = "refProduit", nullable = false, length = 32)
    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
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
    @Column(name = "prix", nullable = false, precision = 2)
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "quantiteMinimum", nullable = true)
    public Integer getQuantiteMinimum() {
        return quantiteMinimum;
    }

    public void setQuantiteMinimum(Integer quantiteMinimum) {
        this.quantiteMinimum = quantiteMinimum;
    }

    @Basic
    @Column(name = "peremption", nullable = true)
    public Date getPeremption() {
        return peremption;
    }

    public void setPeremption(Date peremption) {
        this.peremption = peremption;
    }

    @Basic
    @Column(name = "dateAcquisition", nullable = true)
    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitEntity that = (ProduitEntity) o;
        return id == that.id &&
                quantiteEnStock == that.quantiteEnStock &&
                Double.compare(that.prix, prix) == 0 &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(refProduit, that.refProduit) &&
                Objects.equals(quantiteMinimum, that.quantiteMinimum) &&
                Objects.equals(peremption, that.peremption) &&
                Objects.equals(dateAcquisition, that.dateAcquisition) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, refProduit, quantiteEnStock, prix, quantiteMinimum, peremption, dateAcquisition, description);
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<AppartenirEntity> getAppartenirsById() {
        return appartenirsById;
    }

    public void setAppartenirsById(Collection<AppartenirEntity> appartenirsById) {
        this.appartenirsById = appartenirsById;
    }

    @OneToMany(mappedBy = "produitByIdProduit")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<CommanderEntity> getCommandersById() {
        return commandersById;
    }

    public void setCommandersById(Collection<CommanderEntity> commandersById) {
        this.commandersById = commandersById;
    }
}
