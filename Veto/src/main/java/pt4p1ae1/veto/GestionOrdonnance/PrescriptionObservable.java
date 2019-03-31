package pt4p1ae1.veto.GestionOrdonnance;

import pt4p1ae1.veto.GestionStock.ProduitEntityObservable;


/**
 * This class is an Observable object which is used to display a prescription (product + description)
 */
public class PrescriptionObservable {

    private String productName;

    private String description;
    private ProduitEntityObservable produitEntityObservable;

    /**
     * @param productObservable the productObservable used to get productName
     * @param description       the text of the prescription
     */
    public PrescriptionObservable(ProduitEntityObservable productObservable, String description) {
        this.productName = productObservable.getNom();
        this.description = description;
        this.produitEntityObservable = productObservable;
    }

    /**
     * Getter of productEntityObservable
     *
     * @return the productObservable
     */
    public ProduitEntityObservable getProduitEntityObservable() {
        return produitEntityObservable;
    }

    /**
     * Getter of productName
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Getter of Description
     *
     * @return the prescription description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter of description
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
