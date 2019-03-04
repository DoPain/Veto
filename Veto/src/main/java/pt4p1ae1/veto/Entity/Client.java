package pt4p1ae1.veto.Entity;

import java.io.Serializable;

public class Client implements Serializable {

    private int id;

    public int getIdClient() {
        return id;
    }

    public void setIdClient(int id) {
        this.id = id;
    }

    private Personne personne;
}
