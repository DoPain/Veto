package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Animal", schema = "PT_S4P1A_E1", catalog = "")
public class AnimalEntity {
    private int idAnimal;
    private int idEspece;
    private long idClient;
    private String nom;
    private Date dateNaissance;
    private EspeceEntity especeByIdEspece;
    private ClientEntity clientByIdClient;
    private Collection<OrdonnanceEntity> ordonnancesByIdAnimal;

    @Id
    @Column(name = "idAnimal", nullable = false)
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "idEspece", nullable = false)
    public int getIdEspece() {
        return idEspece;
    }

    public void setIdEspece(int idEspece) {
        this.idEspece = idEspece;
    }

    @Basic
    @Column(name = "idClient", nullable = false)
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 32)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "dateNaissance", nullable = false)
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
        AnimalEntity that = (AnimalEntity) o;
        return idAnimal == that.idAnimal &&
                idEspece == that.idEspece &&
                idClient == that.idClient &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(dateNaissance, that.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimal, idEspece, idClient, nom, dateNaissance);
    }

    @ManyToOne
    @JoinColumn(name = "idEspece", referencedColumnName = "idEspece", nullable = false)
    public EspeceEntity getEspeceByIdEspece() {
        return especeByIdEspece;
    }

    public void setEspeceByIdEspece(EspeceEntity especeByIdEspece) {
        this.especeByIdEspece = especeByIdEspece;
    }

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @OneToMany(mappedBy = "animalByIdAnimal")
    public Collection<OrdonnanceEntity> getOrdonnancesByIdAnimal() {
        return ordonnancesByIdAnimal;
    }

    public void setOrdonnancesByIdAnimal(Collection<OrdonnanceEntity> ordonnancesByIdAnimal) {
        this.ordonnancesByIdAnimal = ordonnancesByIdAnimal;
    }
}
