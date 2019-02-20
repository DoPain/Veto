package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employe {
    private long idEmploye;
    private String idConnexion;
    private String motDePasse;

    @Id
    @Column(name = "idEmploye")
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "idConnexion")
    public String getIdConnexion() {
        return idConnexion;
    }

    public void setIdConnexion(String idConnexion) {
        this.idConnexion = idConnexion;
    }

    @Basic
    @Column(name = "motDePasse")
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return idEmploye == employe.idEmploye &&
                Objects.equals(idConnexion, employe.idConnexion) &&
                Objects.equals(motDePasse, employe.motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmploye, idConnexion, motDePasse);
    }
}
