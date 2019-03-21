package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Utils;

public class AnimalEntityObservable {
    private String proprietaire;
    private String nom;
    private String espece;
    private String race;
    private String sexe;
    private String dateDeNaissance;
    private String poids;
    private String autresInformations;

    public AnimalEntityObservable(AnimalEntity animal) {
        this.proprietaire = Utils.personneDao.findById(Utils.clientDao.findById(animal.getIdClient()).getId()).getNom();
        this.nom = animal.getNom();
        this.espece = Utils.especeDao.findById(animal.getIdRace()).getNom();
        this.race = Utils.raceDao.findById(animal.getIdRace()).getNom();
        this.sexe = animal.getSexe();
        this.dateDeNaissance = animal.getDateNaissance().toString();
        this.poids = animal.getPoids().toString();
        this.proprietaire = animal.getAutreInformations();
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getAutresInformations() {
        return autresInformations;
    }

    public void setAutresInformations(String autresInformations) {
        this.autresInformations = autresInformations;
    }
}
