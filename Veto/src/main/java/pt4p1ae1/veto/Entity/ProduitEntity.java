package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
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
    private String reference;
    private LocalDate peremption;
    private LocalDate dateAcquisition;
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

    @Basic
    @Column(name = "refProduit", nullable = false)
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "peremption", nullable = false)
    public LocalDate getPeremption() {
        return peremption;
    }

    public void setPeremption(LocalDate peremption) {
        this.peremption = peremption;
    }

    @Basic
    @Column(name = "dateAcquisition", nullable = false)
    public LocalDate getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(LocalDate dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    @Basic
    @Column(name = "description", nullable = true)
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
                quantiteMinimum == that.quantiteMinimum &&
                Double.compare(that.prix, prix) == 0 &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, quantiteEnStock, quantiteMinimum, prix);
    }

    @OneToMany( mappedBy = "produitByIdProduit")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<AppartenirEntity> getAppartenirsById() {
        return appartenirsById;
    }

    public void setAppartenirsById(Collection<AppartenirEntity> appartenirsById) {
        this.appartenirsById = appartenirsById;
    }

    @OneToMany( mappedBy = "produitByIdProduit")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<CommanderEntity> getCommandersById() {
        return commandersById;
    }

    public void setCommandersById(Collection<CommanderEntity> commandersById) {
        this.commandersById = commandersById;
    }
}
