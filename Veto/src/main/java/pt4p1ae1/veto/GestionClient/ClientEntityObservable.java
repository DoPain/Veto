package pt4p1ae1.veto.GestionClient;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.GestionAnimaux.AnimalEntityObservable;
import pt4p1ae1.veto.Utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        if (clientEntity.getPersonneById().getDateNaissance() != null) {
            this.age = Utils.calculateAge(clientEntity.getPersonneById().getDateNaissance());
        } else {
            this.age = "Non renseigné";
        }
        if (clientEntity.getPersonneById().getTelephone() != null) {
            this.tel = clientEntity.getPersonneById().getTelephone();
        } else {
            this.tel = "Non renseigné";
        }
        if (clientEntity.getPersonneById().getMail() != null) {
            this.email = clientEntity.getPersonneById().getMail();
        } else {
            this.email = "Non renseigné";
        }
        this.nextRDV = getNextRDVOfClient();
    }

    private String getNextRDVOfClient() {
        List<AnimalEntity> animalsClient = Utils.getAnimalFromClient(this.clientEntity.getId());
        RendezVousEntity nextRDV = null;
        for (AnimalEntity animal : animalsClient) {
            RendezVousEntity rdv = Utils.getNextRDVAnimal(animal.getId());
            if (null != rdv) {
                if (null == nextRDV || nextRDV.getDateHeureDebut().getTime() > rdv.getDateHeureDebut().getTime()) {
                    nextRDV = rdv;
                }
            }
        }
        if (null != nextRDV){
            return nextRDV.getDateHeureDebut().toString();
        } else {
            return "Pas de rendez-vous";
        }
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