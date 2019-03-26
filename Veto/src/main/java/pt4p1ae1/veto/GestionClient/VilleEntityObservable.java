package pt4p1ae1.veto.GestionClient;

import pt4p1ae1.veto.Entity.VilleEntity;

public class VilleEntityObservable {
    private String nom;
    private long id;
    private String cp;

    public VilleEntityObservable(VilleEntity villeEntity) {
        this.nom = villeEntity.getVilleNom();
        this.id = villeEntity.getId();
        this.cp = villeEntity.getVilleCodePostal();
    }

    public String getNom() {
        return nom;
    }

    public long getId() {
        return id;
    }

    public String getCp() {
        return cp;
    }

    @Override
    public String toString() {
        return nom;
    }

}