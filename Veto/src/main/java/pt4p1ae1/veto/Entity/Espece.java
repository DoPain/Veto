package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Espece {
    private int idEspece;
    private String nom;

    @Id
    @Column(name = "idEspece")
    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Espece espece = (Espece) o;
        return idEspece == espece.idEspece &&
                Objects.equals(nom, espece.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspece, nom);
    }
}
