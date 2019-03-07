package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Personne", schema = "PT_S4P1A_E1", catalog = "")
public class PersonneEntity {
    private long idPersonne;
    private long idVille;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String mail;
    private String telephone;
    private ClientEntity clientByIdPersonne;
    private EmployeEntity employeByIdPersonne;
    private VilleEntity villeByIdVille;

    @Id
    @Column(name = "idPersonne", nullable = false)
    public long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(long idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "idVille", nullable = false)
    public long getIdVille() {
        return idVille;
    }

    public void setIdVille(long idVille) {
        this.idVille = idVille;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 128)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 128)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "dateNaissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "adresse", nullable = true, length = 255)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "mail", nullable = true, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 128)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneEntity that = (PersonneEntity) o;
        return idPersonne == that.idPersonne &&
                idVille == that.idVille &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, idVille, nom, prenom, dateNaissance, adresse, mail, telephone);
    }

    @OneToOne(mappedBy = "personneByIdClient")
    public ClientEntity getClientByIdPersonne() {
        return clientByIdPersonne;
    }

    public void setClientByIdPersonne(ClientEntity clientByIdPersonne) {
        this.clientByIdPersonne = clientByIdPersonne;
    }

    @OneToOne(mappedBy = "personneByIdEmploye")
    public EmployeEntity getEmployeByIdPersonne() {
        return employeByIdPersonne;
    }

    public void setEmployeByIdPersonne(EmployeEntity employeByIdPersonne) {
        this.employeByIdPersonne = employeByIdPersonne;
    }

    @ManyToOne
    @JoinColumn(name = "idVille", referencedColumnName = "idVille", nullable = false)
    public VilleEntity getVilleByIdVille() {
        return villeByIdVille;
    }

    public void setVilleByIdVille(VilleEntity villeByIdVille) {
        this.villeByIdVille = villeByIdVille;
    }
}
