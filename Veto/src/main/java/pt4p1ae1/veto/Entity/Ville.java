package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Ville {

    @Id
    private int idVille;
    private int ville_departement;
    private String ville_slug;
    private String ville_nom;
    private String ville_nom_simple;
    private String ville_nom_reel;
    private String ville_nom_soundex;
    private String ville_nom_metaphone;
    private String ville_code_postal;
    private String ville_commune;
    private String ville_code_commune;
    private int ville_arrondissement;
    private String ville_canton;
    private int ville_amdi;
    private int ville_population_2010;
    private int ville_population_1999;
    private int ville_population_2012;
    private int ville_densite_2010;
    private float ville_surface;
    private float ville_longitude_deg;
    private float ville_latitude_deg;
    private String ville_longitude_grd;
    private String ville_latitude_grd;
    private String ville_longitude_dms;
    private String ville_latitude_dms;
    private int ville_zmin;
    private int ville_zmax;


//    @OneToMany(mappedBy = "ville")
//    private List<Personne> personnes;

    public int getId() {
        return idVille;
    }

//    public List<Personne> getPersonnes() {
//        return personnes;
//    }

    public int getDepartement() {
        return ville_departement;
    }

    public String getVille_slug() {
        return ville_slug;
    }

    public String getNomMaj() {
        return ville_nom;
    }

    public String getNomMin() {
        return ville_nom_simple;
    }

    public String getNom() {
        return ville_nom_reel;
    }

    public String getVille_nom_soundex() {
        return ville_nom_soundex;
    }

    public String getVille_nom_metaphone() {
        return ville_nom_metaphone;
    }

    public String getVille_code_postal() {
        return ville_code_postal;
    }

    public String getVille_commune() {
        return ville_commune;
    }

    public String getVille_code_commune() {
        return ville_code_commune;
    }

    public int getVille_arrondissement() {
        return ville_arrondissement;
    }

    public String getVille_canton() {
        return ville_canton;
    }

    public int getVille_amdi() {
        return ville_amdi;
    }

    public int getVille_population_2010() {
        return ville_population_2010;
    }

    public int getVille_population_1999() {
        return ville_population_1999;
    }

    public int getVille_population_2012() {
        return ville_population_2012;
    }

    public int getVille_densite_2010() {
        return ville_densite_2010;
    }

    public float getVille_surface() {
        return ville_surface;
    }

    public float getVille_longitude_deg() {
        return ville_longitude_deg;
    }

    public float getVille_latitude_deg() {
        return ville_latitude_deg;
    }

    public String getVille_longitude_grd() {
        return ville_longitude_grd;
    }

    public String getVille_latitude_grd() {
        return ville_latitude_grd;
    }

    public String getVille_longitude_dms() {
        return ville_longitude_dms;
    }

    public String getVille_latitude_dms() {
        return ville_latitude_dms;
    }

    public int getVille_zmin() {
        return ville_zmin;
    }

    public int getVille_zmax() {
        return ville_zmax;
    }
}