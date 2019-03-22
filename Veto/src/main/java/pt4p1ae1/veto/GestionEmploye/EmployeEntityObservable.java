package pt4p1ae1.veto.GestionEmploye;

import pt4p1ae1.veto.Entity.ClientEntity;
import pt4p1ae1.veto.Entity.EmployeEntity;

import java.sql.Date;

public class EmployeEntityObservable {
    private EmployeEntity empEntity;
    private long id;
    private String login;
    private String motDePasse;
    private Double salaire;
    private Date dateDebutContrat;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;

    public EmployeEntityObservable(EmployeEntity employeEntity) {
        this.empEntity = employeEntity;
        this.nom = employeEntity.getPersonneById().getNom();
        this.prenom = employeEntity.getPersonneById().getPrenom();
        this.telephone = employeEntity.getPersonneById().getTelephone();
        this.mail = employeEntity.getPersonneById().getMail();
        this.dateDebutContrat = employeEntity.getDateDebutContrat();
        this.salaire = employeEntity.getSalaire();
        this.motDePasse = employeEntity.getMotDePasse();
        this.login = employeEntity.getLogin();
        this.id = employeEntity.getId();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return telephone;
    }

    public String getEmail() {
        return mail;
    }


    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Double getSalaire() {
        return salaire;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }

    public EmployeEntity toEmpEntity() {
        return this.empEntity;
    }
}

