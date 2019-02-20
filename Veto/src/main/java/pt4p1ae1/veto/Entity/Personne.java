package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Personne {
    @Id
    @GeneratedValue
    private int idPersonne;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private String adresse;

    private String mail;

    private String telephone;

//    @ManyToOne
//    private Ville ville;

//    public Ville getVille() {
//        return ville;
//    }
//
//    public void setVille(Ville ville) {
//        this.ville = ville;
//    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int id) {
        this.idPersonne = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
