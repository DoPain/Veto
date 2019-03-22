package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Animal", schema = "PT_S4P1A_E1", catalog = "")
public class AnimalEntity {
    private long id;
    private long idRace;
    private long idClient;
    private String nom;
    private String sexe;
    private Double poids;
    private String autreInformations;
    private Timestamp dateNaissance;
    private RaceEntity raceByIdRace;
    private ClientEntity clientByIdClient;
    private Collection<OrdonnanceEntity> ordonnancesById;
    private Collection<TraitementEntity> traitementsById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idRace", nullable = false)
    public long getIdRace() {
        return idRace;
    }

    public void setIdRace(long idRace) {
        this.idRace = idRace;
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
    @Column(name = "sexe", nullable = true, length = 1)
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Basic
    @Column(name = "poids", nullable = true, precision = 2)
    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    @Basic
    @Column(name = "autreInformations", nullable = true, length = -1)
    public String getAutreInformations() {
        return autreInformations;
    }

    public void setAutreInformations(String autreInformations) {
        this.autreInformations = autreInformations;
    }

    @Basic
    @Column(name = "dateNaissance", nullable = true)
    public Timestamp getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Timestamp dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity that = (AnimalEntity) o;
        return id == that.id &&
                idRace == that.idRace &&
                idClient == that.idClient &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(sexe, that.sexe) &&
                Objects.equals(poids, that.poids) &&
                Objects.equals(autreInformations, that.autreInformations) &&
                Objects.equals(dateNaissance, that.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idRace, idClient, nom, sexe, poids, autreInformations, dateNaissance);
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idRace", referencedColumnName = "id", nullable = false)
    public RaceEntity getRaceByIdRace() {
        return raceByIdRace;
    }

    public void setRaceByIdRace(RaceEntity raceByIdRace) {
        this.raceByIdRace = raceByIdRace;
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idClient", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @OneToMany( mappedBy = "animalByIdAnimal")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<OrdonnanceEntity> getOrdonnancesById() {
        return ordonnancesById;
    }

    public void setOrdonnancesById(Collection<OrdonnanceEntity> ordonnancesById) {
        this.ordonnancesById = ordonnancesById;
    }

    @OneToMany( mappedBy = "animalByIdAnimal")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<TraitementEntity> getTraitementsById() {
        return traitementsById;
    }

    public void setTraitementsById(Collection<TraitementEntity> traitementsById) {
        this.traitementsById = traitementsById;
    }
}
