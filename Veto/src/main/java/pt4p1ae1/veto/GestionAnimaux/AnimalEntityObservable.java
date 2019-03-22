package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;
import pt4p1ae1.veto.Utils;

import java.sql.Date;
import java.util.List;

public class AnimalEntityObservable {
    private AnimalEntity animalEntity;
    private long id;
    private String proprietaire;
    private String nom;
    private String espece;
    private String race;
    private Date dateDeNaissance;
    private String age;
    private String poids;
    private String autresInformations;
    private String prochainRDV;

    public AnimalEntityObservable(AnimalEntity animal) {
        animalEntity = animal;
        this.id = animal.getId();
        this.proprietaire = animal.getClientByIdClient().getPersonneById().getNom();
        this.nom = animal.getNom();
        this.espece = animal.getRaceByIdRace().getEspeceByIdEspece().getNom();
        this.race = animal.getRaceByIdRace().getNom();
        this.dateDeNaissance = animal.getDateNaissance();
        this.age = Utils.calculateAge(animal.getDateNaissance());
        if (animal.getPoids() != null)
            this.poids = animal.getPoids().toString();
        else
            this.poids = "Non renseigné";
        this.autresInformations = animal.getAutreInformations();
        this.prochainRDV = getNextRDVAnimal();

    }

    private String getNextRDVAnimal() {
        List<AvoirRendezVousEntity> allRDV = Utils.getRDVAnimal(animalEntity.getId());
        AvoirRendezVousEntity next = null;

        if (allRDV != null) {
            for (AvoirRendezVousEntity rdv : allRDV) {
                if (next == null || rdv.getDateHeure().getTime() < next.getDateHeure().getTime()) {
                    next = rdv;
                }
            }
        }

        if (next != null) {
            return next.toString();
        } else {
            return "Pas de prochain rendez-vous";
        }
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public String getEspece() {
        return espece;
    }

    public String getRace() {
        return race;
    }

    public String getAge() {
        return age;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getPoids() {
        return poids;
    }

    public String getAutresInformations() {
        return autresInformations;
    }

    public String getProchainRDV() {
        return prochainRDV;
    }

    public long getId() {
        return id;
    }
}
