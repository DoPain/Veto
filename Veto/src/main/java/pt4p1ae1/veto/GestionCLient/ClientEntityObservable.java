package pt4p1ae1.veto.GestionCLient;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;

public class ClientEntityObservable {
    private ClientEntity clientEntity;
    private String nom;
    private String prenom;
    private String age;
    private String tel;
    private String email;
    private String nextRDV;

    public ClientEntityObservable(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
        this.nom = clientEntity.getPersonneById().getNom();
        this.prenom = clientEntity.getPersonneById().getPrenom();

        this.age = Utils.calculateAge(clientEntity.getPersonneById().getDateNaissance());

        this.tel = clientEntity.getPersonneById().getTelephone();
        this.email = clientEntity.getPersonneById().getMail();
        this.nextRDV = getNextRDVOfClient();
    }

    private String getNextRDVOfClient() {
        List<AnimalEntity> allAnimals = Utils.getAnimalFromClient(this.clientEntity.getPersonneById().getId());
        List<RendezVousEntity> allRDV = null;
        RendezVousEntity next = null;
        if (allAnimals != null) {
            for (AnimalEntity animal : allAnimals) {
                List<RendezVousEntity> allRDVAnimal = Utils.getRDVAnimal(animal.getId());
                if (allRDVAnimal != null) {
                    allRDV.addAll(allRDVAnimal);
                }
            }
            if (allRDV != null) {
                for (RendezVousEntity rdv : allRDV) {
                    if (next != null || next.getDateHeureDebut().getTime() > rdv.getDateHeureDebut().getTime()){
                        next = rdv;
                    }
                }
            return next.getDateHeureDebut().toString();
            }
        }
        return "Pas de rendez-vous";
    }

    public ClientEntity toClientEntity() {
        return this.clientEntity;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAge() {
        return age;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getNextRDV() {
        return nextRDV;
    }
}