package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Client", schema = "PT_S4P1A_E1", catalog = "")
public class ClientEntity {
    private long idClient;
    private Collection<AnimalEntity> animalsByIdClient;
    private Collection<AvoirRendezVousEntity> avoirRendezVousByIdClient;
    private PersonneEntity personneByIdClient;
    private Collection<PanierEntity> paniersByIdClient;

    @Id
    @Column(name = "idClient", nullable = false)
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return idClient == that.idClient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient);
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<AnimalEntity> getAnimalsByIdClient() {
        return animalsByIdClient;
    }

    public void setAnimalsByIdClient(Collection<AnimalEntity> animalsByIdClient) {
        this.animalsByIdClient = animalsByIdClient;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<AvoirRendezVousEntity> getAvoirRendezVousByIdClient() {
        return avoirRendezVousByIdClient;
    }

    public void setAvoirRendezVousByIdClient(Collection<AvoirRendezVousEntity> avoirRendezVousByIdClient) {
        this.avoirRendezVousByIdClient = avoirRendezVousByIdClient;
    }

    @OneToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idPersonne", nullable = false)
    public PersonneEntity getPersonneByIdClient() {
        return personneByIdClient;
    }

    public void setPersonneByIdClient(PersonneEntity personneByIdClient) {
        this.personneByIdClient = personneByIdClient;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<PanierEntity> getPaniersByIdClient() {
        return paniersByIdClient;
    }

    public void setPaniersByIdClient(Collection<PanierEntity> paniersByIdClient) {
        this.paniersByIdClient = paniersByIdClient;
    }
}
