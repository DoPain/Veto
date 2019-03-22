package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;
import pt4p1ae1.veto.Utils;

import java.util.Iterator;

public class AnimalEntityObservable {
    private String id;
    private String proprietaire;
    private String nom;
    private String espece;
    private String race;
    private String sexe;
    private String dateDeNaissance;
    private String poids;
    private String autresInformations;
    private String prochainRDV;

    private AnimalEntity animal;

    public AnimalEntityObservable(AnimalEntity animal) {
        this.animal = animal;
        this.id = String.valueOf(animal.getId());
        this.proprietaire = animal.getClientByIdClient().getPersonneById().getNom();
        this.nom = animal.getNom();
        this.espece = animal.getRaceByIdRace().getEspeceByIdEspece().getNom();
        this.race = animal.getRaceByIdRace().getNom();
        this.sexe = animal.getSexe();
        this.dateDeNaissance = animal.getDateNaissance().toString();
        if (animal.getPoids() != null)
            this.poids = animal.getPoids().toString();
        else
            this.poids = "Non renseigné";
        this.autresInformations = animal.getAutreInformations();
        this.prochainRDV = getNextRDVOfAnimal();
    }

    private String getNextRDVOfAnimal() {
        Iterator<AvoirRendezVousEntity> allRDV = Utils.AVOIR_RENDEZ_VOUS_DAO.findAll().iterator();
        AvoirRendezVousEntity next = null;
        while (allRDV.hasNext()) {
            AvoirRendezVousEntity rdv = allRDV.next();
            if (rdv.getIdClient() == animal.getId()) {
                if (next == null || next.getDateHeure().getTime() > rdv.getDateHeure().getTime()) {
                    next = rdv;
                }
            }
        }
        if (next != null) {
            return next.toString();
        } else {
            return "Pas de rendez-vous";
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

    public String getSexe() {
        return sexe;
    }

    public String getDateDeNaissance() {
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

    public String getId() {
        return id;
    }

    public AnimalEntity toAnimalEntity() {
        return animal;
    }
}
