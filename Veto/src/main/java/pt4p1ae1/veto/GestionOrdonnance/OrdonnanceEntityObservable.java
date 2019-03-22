package pt4p1ae1.veto.GestionOrdonnance;

import pt4p1ae1.veto.Entity.OrdonnanceEntity;

public class OrdonnanceEntityObservable {

    private String nameAnimal;
    private String nameClient;
    private String dateOrdonnance;
    private String veterinaire;

    public OrdonnanceEntityObservable(OrdonnanceEntity ordonnance) {
        this.nameAnimal = ordonnance.getAnimalByIdAnimal().getNom();
        this.nameClient = ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getNom()
                + " " + ordonnance.getAnimalByIdAnimal().getClientByIdClient().getPersonneById().getPrenom();
        this.dateOrdonnance = ordonnance.getDateOrdonnance().toString();
        this.veterinaire = ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getNom()
                + " " + ordonnance.getVeterinaireByIdVeterinaire().getPersonneById().getPrenom();
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
