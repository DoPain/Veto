package pt4p1ae1.veto.GestionStock;

import pt4p1ae1.veto.Entity.ProduitEntity;

import java.time.LocalDate;

public class ProduitEntityObservable {

    private ProduitEntity produit;
    private String nom;
    private String reference;
    private Integer quantiteStock;
    private Double prix;
    private Integer quantiteMin;
    private LocalDate peremption;
    private LocalDate dateAcquisition;
    private String desc;


    public ProduitEntityObservable(ProduitEntity produitEntity) {
        this.produit = produitEntity;
        this.nom = produitEntity.getNom();
        this.reference = produitEntity.getReference();
        this.peremption = produitEntity.getPeremption();
        this.dateAcquisition= produitEntity.getDateAcquisition();
        this.quantiteStock = new Integer(produitEntity.getQuantiteEnStock());
        this.prix = new Double(produitEntity.getPrix());
        this.quantiteMin = new Integer(produitEntity.getQuantiteMinimum());
        this.desc = produitEntity.getDescription();
    }

    public ProduitEntity toProduitEntity() {
        return produit;
    }

    public String getNom() {
        return nom;
    }

    public String getReference() {
        return reference;
    }

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public Integer getQuantiteMin() {
        return quantiteMin;
    }

    public LocalDate getPeremption() {
        return peremption;
    }

    public LocalDate getDateAcquisition() {
        return dateAcquisition;
    }

    public String getDesc() {
        return desc;
    }


    public Double getPrix() {
        return prix;
    }


}
