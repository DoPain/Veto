package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Client", schema = "PT_S4P1A_E1", catalog = "")
public class ClientEntity {
    private long id;
    private Collection<AnimalEntity> animalsById;
    private PersonneEntity personneById;
    private Collection<PanierEntity> paniersById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "clientByIdClient")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<AnimalEntity> getAnimalsById() {
        return animalsById;
    }

    public void setAnimalsById(Collection<AnimalEntity> animalsById) {
        this.animalsById = animalsById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public PersonneEntity getPersonneById() {
        return personneById;
    }

    public void setPersonneById(PersonneEntity personneById) {
        this.personneById = personneById;
    }

    @OneToMany(mappedBy = "clientByIdClient")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<PanierEntity> getPaniersById() {
        return paniersById;
    }

    public void setPaniersById(Collection<PanierEntity> paniersById) {
        this.paniersById = paniersById;
    }
}
