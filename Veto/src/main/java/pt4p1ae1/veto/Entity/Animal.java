package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;


@Entity
public class Animal {
    private int idAnimal;
    private int idEspece;
    private long idClient;
    private String nom;
    private Date dateNaissance;

    @Id
    @Column(name = "idAnimal")
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "idEspece")
    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
    }

    @Basic
    @Column(name = "idClient")
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "dateNaissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return idAnimal == animal.idAnimal &&
                idEspece == animal.idEspece &&
                idClient == animal.idClient &&
                Objects.equals(nom, animal.nom) &&
                Objects.equals(dateNaissance, animal.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimal, idEspece, idClient, nom, dateNaissance);
    }
}
