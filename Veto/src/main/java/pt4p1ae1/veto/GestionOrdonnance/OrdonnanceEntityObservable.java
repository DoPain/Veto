package pt4p1ae1.veto.GestionOrdonnance;

import pt4p1ae1.veto.Entity.OrdonnanceEntity;
import java.text.SimpleDateFormat;

public class OrdonnanceEntityObservable {

    private OrdonnanceEntity ordonnance;
    private String nameAnimal;
    private String nameClient;
    private String dateOrdonnance;
    private String veterinaire;

    public OrdonnanceEntityObservable(OrdonnanceEntity ordonnance) {
        this.ordonnance=ordonnance;
        this.nameAnimal = ordonnance.getAnimalByIdAnimal().getNom();
        this.nameClient = ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getNom()
                + " " + ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getPrenom();
        this.dateOrdonnance = new SimpleDateFormat("dd/MM/yyyy").format(ordonnance.getDateOrdonnance());
        this.veterinaire = ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getNom()
                + " " + ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getPrenom();
    }

    public OrdonnanceEntity getOrdonnance() {
        return ordonnance;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getDateOrdonnance() {
        return dateOrdonnance;
    }

    public String getVeterinaire() {
        return veterinaire;
    }
}
