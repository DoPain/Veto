package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Employe", schema = "PT_S4P1A_E1", catalog = "")
public class EmployeEntity {
    private long idEmploye;
    private String idConnexion;
    private String motDePasse;
    private Collection<CongeEntity> congesByIdEmploye;
    private PersonneEntity personneByIdEmploye;
    private Collection<LogEntity> logsByIdEmploye;
    private Collection<PanierEntity> paniersByIdEmploye;
    private VeterinaireEntity veterinaireByIdEmploye;

    @Id
    @Column(name = "idEmploye", nullable = false)
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "idConnexion", nullable = false, length = 32)
    public String getIdConnexion() {
        return idConnexion;
    }

    public void setIdConnexion(String idConnexion) {
        this.idConnexion = idConnexion;
    }

    @Basic
    @Column(name = "motDePasse", nullable = false, length = 32)
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
        EmployeEntity that = (EmployeEntity) o;
        return idEmploye == that.idEmploye &&
                Objects.equals(idConnexion, that.idConnexion) &&
                Objects.equals(motDePasse, that.motDePasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmploye, idConnexion, motDePasse);
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<CongeEntity> getCongesByIdEmploye() {
        return congesByIdEmploye;
    }

    public void setCongesByIdEmploye(Collection<CongeEntity> congesByIdEmploye) {
        this.congesByIdEmploye = congesByIdEmploye;
    }

    @OneToOne
    @JoinColumn(name = "idEmploye", referencedColumnName = "idPersonne", nullable = false)
    public PersonneEntity getPersonneByIdEmploye() {
        return personneByIdEmploye;
    }

    public void setPersonneByIdEmploye(PersonneEntity personneByIdEmploye) {
        this.personneByIdEmploye = personneByIdEmploye;
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<LogEntity> getLogsByIdEmploye() {
        return logsByIdEmploye;
    }

    public void setLogsByIdEmploye(Collection<LogEntity> logsByIdEmploye) {
        this.logsByIdEmploye = logsByIdEmploye;
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<PanierEntity> getPaniersByIdEmploye() {
        return paniersByIdEmploye;
    }

    public void setPaniersByIdEmploye(Collection<PanierEntity> paniersByIdEmploye) {
        this.paniersByIdEmploye = paniersByIdEmploye;
    }

    @OneToOne(mappedBy = "employeByIdVeterinaire")
    public VeterinaireEntity getVeterinaireByIdEmploye() {
        return veterinaireByIdEmploye;
    }

    public void setVeterinaireByIdEmploye(VeterinaireEntity veterinaireByIdEmploye) {
        this.veterinaireByIdEmploye = veterinaireByIdEmploye;
    }
}
