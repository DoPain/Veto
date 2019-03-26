package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.TraitementEntity;

public class TraitementEntityObservable {
    private Long id;
    private String animal;
    private String maladie;
    private String soin;
    private String dateDebut;
    private String dateFin;

    private TraitementEntity traitement;

    public TraitementEntityObservable(TraitementEntity traitement) {
        this.traitement = traitement;
        this.id = traitement.getId();
        this.animal = traitement.getAnimalByIdAnimal().getNom();
        this.maladie = traitement.getMaladie();
        this.soin = traitement.getSoin();
        this.dateDebut = traitement.getDateDebut().toString();
        this.dateFin = traitement.getDateFin().toString();
    }

    public String getAnimal() {
        return animal;
    }

    public String getMaladie() {
        return maladie;
    }

    public String getSoin() {
        return soin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public Long getId() {
        return id;
    }

    public TraitementEntity getTraitement() {
        return traitement;
    }
}
