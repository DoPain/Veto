package pt4p1ae1.veto.GestionClient;

import pt4p1ae1.veto.Entity.AnimalEntity;
import pt4p1ae1.veto.Entity.RendezVousEntity;
import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Utils;

import java.util.List;

/**
 * Classe permettant l'affichage de l'entité ClientEntity.
 */
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
        this.nextRDV = "None"; //getNextRDVOfClient();
    }

    /**
     * Fonction retournant la date en string du prochain rendez-vous du client.
     *
     * @return la date en string du prochain rendez-vous du client
     */
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

    /**
     * Getter de l'attribut clientEntity.
     * @return clientEntity
     */
    public ClientEntity toClientEntity() {
        return this.clientEntity;
    }

    /**
     * Getter de l'attribut nom.
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de l'attribut prenom.
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter de l'attribut age.
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * Getter de l'attribut tel.
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Getter de l'attribut email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter de l'attribut nextRDV.
     * @return nextRDV
     */
    public String getNextRDV() {
        return nextRDV;
    }
}