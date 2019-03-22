package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;

import java.util.Collection;

public class AnimalEntityObservable {
    private String proprietaire;
    private String nom;
    private String espece;
    private String race;
    private String sexe;
    private String dateDeNaissance;
    private String poids;
    private String autresInformations;
    private String prochainRDV;

    public AnimalEntityObservable(AnimalEntity animal) {
        this.proprietaire = animal.getClientByIdClient().getPersonneById().getNom() + " " + animal.getClientByIdClient().getPersonneById().getPrenom();
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
        Collection<AvoirRendezVousEntity> rdv = animal.getClientByIdClient().getAvoirRendezVousById();
        if (!rdv.isEmpty())
            this.prochainRDV = rdv.iterator().next().getDateHeure().toString();
        else
            this.prochainRDV = "Pas de rendez-vous";

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
}
