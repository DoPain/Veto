package pt4p1ae1.veto.GestionCLient;

import pt4p1ae1.veto.Entity.AvoirRendezVousEntity;
import pt4p1ae1.veto.Entity.ClientEntity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

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

        LocalDate naissance = clientEntity.getPersonneById().getDateNaissance().toLocalDate();
        LocalDate now = LocalDate.now();
        this.age = String.valueOf(Period.between(naissance, now).getYears());
        this.tel = clientEntity.getPersonneById().getTelephone();
        this.email = clientEntity.getPersonneById().getMail();
        Collection<AvoirRendezVousEntity> rdv = clientEntity.getAvoirRendezVousById();
        if (!rdv.isEmpty()) {
            this.nextRDV = rdv.iterator().next().getDateHeure().toString();
        } else {
            this.nextRDV = "Pas de rendez-vous";
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