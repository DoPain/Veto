package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Employe", schema = "PT_S4P1A_E1", catalog = "")
public class EmployeEntity {
    private long id;
    private String login;
    private String motDePasse;
    private Double salaire;
    private Date dateDebutContrat;
    private Collection<CongeEntity> congesById;
    private PersonneEntity personneById;
    private Collection<LogEntity> logsById;
    private Collection<PanierEntity> paniersById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 32)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "motDePasse", nullable = false, length = 32)
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Basic
    @Column(name = "salaire", nullable = true, precision = 2)
    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    @Basic
    @Column(name = "dateDebutContrat", nullable = false)
    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeEntity that = (EmployeEntity) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(motDePasse, that.motDePasse) &&
                Objects.equals(salaire, that.salaire) &&
                Objects.equals(dateDebutContrat, that.dateDebutContrat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, motDePasse, salaire, dateDebutContrat);
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<CongeEntity> getCongesById() {
        return congesById;
    }

    public void setCongesById(Collection<CongeEntity> congesById) {
        this.congesById = congesById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public PersonneEntity getPersonneById() {
        return personneById;
    }

    public void setPersonneById(PersonneEntity personneById) {
        this.personneById = personneById;
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<LogEntity> getLogsById() {
        return logsById;
    }

    public void setLogsById(Collection<LogEntity> logsById) {
        this.logsById = logsById;
    }

    @OneToMany(mappedBy = "employeByIdEmploye")
    public Collection<PanierEntity> getPaniersById() {
        return paniersById;
    }

    public void setPaniersById(Collection<PanierEntity> paniersById) {
        this.paniersById = paniersById;
    }
}
