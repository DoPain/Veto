package pt4p1ae1.veto.GestionAnimaux;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Utils;

import java.sql.Date;
import java.util.List;

public class AnimalEntityObservable {
    private long id;
    private String proprietaire;
    private String nom;
    private String espece;
    private String race;
    private Date dateDeNaissance;
    private String sexe;
    private String age;
    private String poids;
    private String autresInformations;
    private String prochainRDV;

    private AnimalEntity animal;

    public AnimalEntityObservable(AnimalEntity animal) {
        this.animal = animal;
        this.id = animal.getId();
        this.proprietaire = animal.getClientByIdClient().getPersonneById().getNom() + " " + animal.getClientByIdClient().getPersonneById().getPrenom();
        this.nom = animal.getNom();
        this.espece = animal.getRaceByIdRace().getEspeceByIdEspece().getNom();
        this.race = animal.getRaceByIdRace().getNom();
        this.sexe = animal.getSexe();
        this.dateDeNaissance = animal.getDateNaissance();
        this.age = Utils.calculateAge(animal.getDateNaissance()) + " ans";
        if (animal.getPoids() != null)
            this.poids = animal.getPoids().toString();
        else
            this.poids = "";
        this.autresInformations = animal.getAutreInformations();
        this.prochainRDV = "pas défini";
    }

    private String getNextRDVAnimal() {
        List<RendezVousEntity> allRDV = Utils.getRDVAnimal(animal.getId());
        RendezVousEntity next = null;

        if (allRDV != null) {
            for (RendezVousEntity rdv : allRDV) {
                if (next == null || rdv.getDateHeureDebut().getTime() < next.getDateHeureDebut().getTime()) {
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

    public AnimalEntity getAnimal() {
        return animal;
    }

    public String getSexe() {
        return sexe;
    }

    public AnimalEntity getAnimalEntity() {
        return animal;
    }
}
