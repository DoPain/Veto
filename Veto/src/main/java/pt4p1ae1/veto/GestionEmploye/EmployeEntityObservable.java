package pt4p1ae1.veto.GestionEmploye;

import pt4p1ae1.veto.Entity.EmployeEntity;

/**
 * Classe permettant l'affichage de l'entité EmployeEntity.
 */
public class EmployeEntityObservable {

    private EmployeEntity empEntity;
    private long id;
    private String login;
    private String motDePasse;
    private Double salaire;
    private String dateDebutContrat;
    private String dateFinContrat;
    private String typeContrat;
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
        this.dateDebutContrat = employeEntity.getDateDebutContrat().toString();
        this.dateFinContrat = (employeEntity.getDateFinContrat() == null) ? "Indéfinie " : employeEntity.getDateFinContrat().toString();
        this.salaire = employeEntity.getSalaire();
        this.motDePasse = employeEntity.getMotDePasse();
        this.login = employeEntity.getLogin();
        this.id = employeEntity.getId();
        this.typeContrat = employeEntity.getTypeContrat();
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
     * Getter de l'attribut telephone.
     * @return telephone
     */
    public String getTel() {
        return telephone;
    }

    /**
     * Getter de l'attribut mail.
     * @return mail
     */
    public String getEmail() {
        return mail;
    }

    /**
     * Getter de l'attribut id.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Getter de l'attribut login.
     * @return login
     */
    public String getLogin() {
        return login;
    }
    /**
     * Getter de l'attribut motDePasse.
     * @return motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    /**
     * Getter de l'attribut salaire.
     * @return salaire
     */
    public Double getSalaire() {
        return salaire;
    }
    /**
     * Getter de l'attribut dateDebutContrat.
     * @return dateDebutContrat
     */
    public String getDateDebutContrat() {
        return dateDebutContrat;
    }
    /**
     * Getter de l'attribut empEntity.
     * @return empEntity
     */
    public EmployeEntity toEmpEntity() {
        return this.empEntity;
    }
    /**
     * Getter de l'attribut dateFinContrat.
     * @return dateFinContrat
     */
    public String getDateFinContrat() {
        return dateFinContrat;
    }
    /**
     * Getter de l'attribut typeContrat.
     * @return typeContrat
     */
    public String getTypeContrat() {
        return typeContrat;
    }
}

