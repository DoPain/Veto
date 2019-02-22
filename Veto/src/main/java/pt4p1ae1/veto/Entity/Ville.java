package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ville {
    private long idVille;
    private String villeDepartement;
    private String villeSlug;
    private String villeNom;
    private String villeNomSimple;
    private String villeNomReel;
    private String villeNomSoundex;
    private String villeNomMetaphone;
    private String villeCodePostal;
    private String villeCommune;
    private String villeCodeCommune;
    private Short villeArrondissement;
    private String villeCanton;
    private Short villeAmdi;
    private Integer villePopulation2010;
    private Integer villePopulation1999;
    private Integer villePopulation2012;
    private Integer villeDensite2010;
    private Double villeSurface;
    private Double villeLongitudeDeg;
    private Double villeLatitudeDeg;
    private String villeLongitudeGrd;
    private String villeLatitudeGrd;
    private String villeLongitudeDms;
    private String villeLatitudeDms;
    private Integer villeZmin;
    private Integer villeZmax;

    @Id
    @Column(name = "idVille")
    public long getIdVille() {
        return idVille;
    }

    public void setIdVille(long idVille) {
        this.idVille = idVille;
    }

    @Basic
    @Column(name = "ville_departement")
    public String getVilleDepartement() {
        return villeDepartement;
    }

    public void setVilleDepartement(String villeDepartement) {
        this.villeDepartement = villeDepartement;
    }

    @Basic
    @Column(name = "ville_slug")
    public String getVilleSlug() {
        return villeSlug;
    }

    public void setVilleSlug(String villeSlug) {
        this.villeSlug = villeSlug;
    }

    @Basic
    @Column(name = "ville_nom")
    public String getVilleNom() {
        return villeNom;
    }

    public void setVilleNom(String villeNom) {
        this.villeNom = villeNom;
    }

    @Basic
    @Column(name = "ville_nom_simple")
    public String getVilleNomSimple() {
        return villeNomSimple;
    }

    public void setVilleNomSimple(String villeNomSimple) {
        this.villeNomSimple = villeNomSimple;
    }

    @Basic
    @Column(name = "ville_nom_reel")
    public String getVilleNomReel() {
        return villeNomReel;
    }

    public void setVilleNomReel(String villeNomReel) {
        this.villeNomReel = villeNomReel;
    }

    @Basic
    @Column(name = "ville_nom_soundex")
    public String getVilleNomSoundex() {
        return villeNomSoundex;
    }

    public void setVilleNomSoundex(String villeNomSoundex) {
        this.villeNomSoundex = villeNomSoundex;
    }

    @Basic
    @Column(name = "ville_nom_metaphone")
    public String getVilleNomMetaphone() {
        return villeNomMetaphone;
    }

    public void setVilleNomMetaphone(String villeNomMetaphone) {
        this.villeNomMetaphone = villeNomMetaphone;
    }

    @Basic
    @Column(name = "ville_code_postal")
    public String getVilleCodePostal() {
        return villeCodePostal;
    }

    public void setVilleCodePostal(String villeCodePostal) {
        this.villeCodePostal = villeCodePostal;
    }

    @Basic
    @Column(name = "ville_commune")
    public String getVilleCommune() {
        return villeCommune;
    }

    public void setVilleCommune(String villeCommune) {
        this.villeCommune = villeCommune;
    }

    @Basic
    @Column(name = "ville_code_commune")
    public String getVilleCodeCommune() {
        return villeCodeCommune;
    }

    public void setVilleCodeCommune(String villeCodeCommune) {
        this.villeCodeCommune = villeCodeCommune;
    }

    @Basic
    @Column(name = "ville_arrondissement")
    public Short getVilleArrondissement() {
        return villeArrondissement;
    }

    public void setVilleArrondissement(Short villeArrondissement) {
        this.villeArrondissement = villeArrondissement;
    }

    @Basic
    @Column(name = "ville_canton")
    public String getVilleCanton() {
        return villeCanton;
    }

    public void setVilleCanton(String villeCanton) {
        this.villeCanton = villeCanton;
    }

    @Basic
    @Column(name = "ville_amdi")
    public Short getVilleAmdi() {
        return villeAmdi;
    }

    public void setVilleAmdi(Short villeAmdi) {
        this.villeAmdi = villeAmdi;
    }

    @Basic
    @Column(name = "ville_population_2010")
    public Integer getVillePopulation2010() {
        return villePopulation2010;
    }

    public void setVillePopulation2010(Integer villePopulation2010) {
        this.villePopulation2010 = villePopulation2010;
    }

    @Basic
    @Column(name = "ville_population_1999")
    public Integer getVillePopulation1999() {
        return villePopulation1999;
    }

    public void setVillePopulation1999(Integer villePopulation1999) {
        this.villePopulation1999 = villePopulation1999;
    }

    @Basic
    @Column(name = "ville_population_2012")
    public Integer getVillePopulation2012() {
        return villePopulation2012;
    }

    public void setVillePopulation2012(Integer villePopulation2012) {
        this.villePopulation2012 = villePopulation2012;
    }

    @Basic
    @Column(name = "ville_densite_2010")
    public Integer getVilleDensite2010() {
        return villeDensite2010;
    }

    public void setVilleDensite2010(Integer villeDensite2010) {
        this.villeDensite2010 = villeDensite2010;
    }

    @Basic
    @Column(name = "ville_surface")
    public Double getVilleSurface() {
        return villeSurface;
    }

    public void setVilleSurface(Double villeSurface) {
        this.villeSurface = villeSurface;
    }

    @Basic
    @Column(name = "ville_longitude_deg")
    public Double getVilleLongitudeDeg() {
        return villeLongitudeDeg;
    }

    public void setVilleLongitudeDeg(Double villeLongitudeDeg) {
        this.villeLongitudeDeg = villeLongitudeDeg;
    }

    @Basic
    @Column(name = "ville_latitude_deg")
    public Double getVilleLatitudeDeg() {
        return villeLatitudeDeg;
    }

    public void setVilleLatitudeDeg(Double villeLatitudeDeg) {
        this.villeLatitudeDeg = villeLatitudeDeg;
    }

    @Basic
    @Column(name = "ville_longitude_grd")
    public String getVilleLongitudeGrd() {
        return villeLongitudeGrd;
    }

    public void setVilleLongitudeGrd(String villeLongitudeGrd) {
        this.villeLongitudeGrd = villeLongitudeGrd;
    }

    @Basic
    @Column(name = "ville_latitude_grd")
    public String getVilleLatitudeGrd() {
        return villeLatitudeGrd;
    }

    public void setVilleLatitudeGrd(String villeLatitudeGrd) {
        this.villeLatitudeGrd = villeLatitudeGrd;
    }

    @Basic
    @Column(name = "ville_longitude_dms")
    public String getVilleLongitudeDms() {
        return villeLongitudeDms;
    }

    public void setVilleLongitudeDms(String villeLongitudeDms) {
        this.villeLongitudeDms = villeLongitudeDms;
    }

    @Basic
    @Column(name = "ville_latitude_dms")
    public String getVilleLatitudeDms() {
        return villeLatitudeDms;
    }

    public void setVilleLatitudeDms(String villeLatitudeDms) {
        this.villeLatitudeDms = villeLatitudeDms;
    }

    @Basic
    @Column(name = "ville_zmin")
    public Integer getVilleZmin() {
        return villeZmin;
    }

    public void setVilleZmin(Integer villeZmin) {
        this.villeZmin = villeZmin;
    }

    @Basic
    @Column(name = "ville_zmax")
    public Integer getVilleZmax() {
        return villeZmax;
    }

    public void setVilleZmax(Integer villeZmax) {
        this.villeZmax = villeZmax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return idVille == ville.idVille &&
                Objects.equals(villeDepartement, ville.villeDepartement) &&
                Objects.equals(villeSlug, ville.villeSlug) &&
                Objects.equals(villeNom, ville.villeNom) &&
                Objects.equals(villeNomSimple, ville.villeNomSimple) &&
                Objects.equals(villeNomReel, ville.villeNomReel) &&
                Objects.equals(villeNomSoundex, ville.villeNomSoundex) &&
                Objects.equals(villeNomMetaphone, ville.villeNomMetaphone) &&
                Objects.equals(villeCodePostal, ville.villeCodePostal) &&
                Objects.equals(villeCommune, ville.villeCommune) &&
                Objects.equals(villeCodeCommune, ville.villeCodeCommune) &&
                Objects.equals(villeArrondissement, ville.villeArrondissement) &&
                Objects.equals(villeCanton, ville.villeCanton) &&
                Objects.equals(villeAmdi, ville.villeAmdi) &&
                Objects.equals(villePopulation2010, ville.villePopulation2010) &&
                Objects.equals(villePopulation1999, ville.villePopulation1999) &&
                Objects.equals(villePopulation2012, ville.villePopulation2012) &&
                Objects.equals(villeDensite2010, ville.villeDensite2010) &&
                Objects.equals(villeSurface, ville.villeSurface) &&
                Objects.equals(villeLongitudeDeg, ville.villeLongitudeDeg) &&
                Objects.equals(villeLatitudeDeg, ville.villeLatitudeDeg) &&
                Objects.equals(villeLongitudeGrd, ville.villeLongitudeGrd) &&
                Objects.equals(villeLatitudeGrd, ville.villeLatitudeGrd) &&
                Objects.equals(villeLongitudeDms, ville.villeLongitudeDms) &&
                Objects.equals(villeLatitudeDms, ville.villeLatitudeDms) &&
                Objects.equals(villeZmin, ville.villeZmin) &&
                Objects.equals(villeZmax, ville.villeZmax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVille, villeDepartement, villeSlug, villeNom, villeNomSimple, villeNomReel, villeNomSoundex, villeNomMetaphone, villeCodePostal, villeCommune, villeCodeCommune, villeArrondissement, villeCanton, villeAmdi, villePopulation2010, villePopulation1999, villePopulation2012, villeDensite2010, villeSurface, villeLongitudeDeg, villeLatitudeDeg, villeLongitudeGrd, villeLatitudeGrd, villeLongitudeDms, villeLatitudeDms, villeZmin, villeZmax);
    }
}
