package pt4p1ae1.veto.GestionOrdonnance;

import pt4p1ae1.veto.Entity.OrdonnanceEntity;
import java.text.SimpleDateFormat;

/**
 * This class is an Observable object which is used to display OrdonnanceEntity object
 */
public class OrdinanceEntityObservable {

    private OrdonnanceEntity ordonnance;
    private String nameAnimal;
    private String nameClient;
    private String dateOrdonnance;
    private String veterinaire;

    /**
     * @param ordonnance the OrdinanceEntity we will use to create this observable object
     */
    public OrdinanceEntityObservable(OrdonnanceEntity ordonnance) {
        this.ordonnance=ordonnance;
        this.nameAnimal = ordonnance.getAnimalByIdAnimal().getNom();
        this.nameClient = ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getNom()
                + " " + ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getPrenom();
        this.dateOrdonnance = new SimpleDateFormat("dd/MM/yyyy").format(ordonnance.getDateOrdonnance());
        this.veterinaire = ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getNom()
                + " " + ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getPrenom();
    }

    /**
     * Getter of ordonnance
     *
     * @return ordonnance
     */
    public OrdonnanceEntity getOrdonnance() {
        return ordonnance;
    }

    /**
     * Getter of nameAnimal
     *
     * @return nameAnimal
     */
    public String getNameAnimal() {
        return nameAnimal;
    }

    /**
     * Getter of nameClient
     *
     * @return nameClient
     */
    public String getNameClient() {
        return nameClient;
    }

    /**
     * Getter of dateOrdonnace
     *
     * @return dateOrdonnance
     */
    public String getDateOrdonnance() {
        return dateOrdonnance;
    }

    /**
     * Getter of veterinaire
     *
     * @return veterinaire
     */
    public String getVeterinaire() {
        return veterinaire;
    }
}
