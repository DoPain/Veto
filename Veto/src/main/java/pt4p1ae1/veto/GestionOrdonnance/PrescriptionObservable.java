package pt4p1ae1.veto.GestionOrdonnance;

import pt4p1ae1.veto.GestionStock.ProduitEntityObservable;

public class PrescriptionObservable {

    private String productName;

    private String description;
    private ProduitEntityObservable produitEntityObservable;

    public PrescriptionObservable(ProduitEntityObservable productObservable, String description) {
        this.productName = productObservable.getNom();
        this.description = description;
        this.produitEntityObservable = productObservable;
    }

    public ProduitEntityObservable getProduitEntityObservable() {
        return produitEntityObservable;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
