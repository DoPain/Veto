package pt4p1ae1.veto.Entity;

import javax.persistence.*;

@Entity
@Table
public class Client{

    @Id
    @GeneratedValue
    private int idClient;

    @OneToOne @PrimaryKeyJoinColumn
    private Personne personne;

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int id) {
        this.idClient = id;
    }
}
