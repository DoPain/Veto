package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Client {
    private long idClient;

    @Id
    @Column(name = "idClient")
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
        Client client = (Client) o;
        return idClient == client.idClient;
    }
//
//    @OneToOne @PrimaryKeyJoinColumn
//    Personne personne;
//
//    public Personne getPersonne() {
//        return personne;
//    }
//
//    public void setPersonne(Personne personne) {
//        this.personne = personne;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient);
    }
}
