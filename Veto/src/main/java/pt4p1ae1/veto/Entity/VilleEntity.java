package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ville", schema = "PT_S4P1A_E1", catalog = "")
public class VilleEntity {
    private long id;
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
    private Collection<PersonneEntity> personnesById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ville_departement", nullable = true, length = 3)
    public String getVilleDepartement() {
        return villeDepartement;
    }

    public void setVilleDepartement(String villeDepartement) {
        this.villeDepartement = villeDepartement;
    }

    @Basic
    @Column(name = "ville_slug", nullable = true, length = 150)
    public String getVilleSlug() {
        return villeSlug;
    }

    public void setVilleSlug(String villeSlug) {
        this.villeSlug = villeSlug;
    }

    @Basic
    @Column(name = "ville_nom", nullable = true, length = 45)
    public String getVilleNom() {
        return villeNom;
    }

    public void setVilleNom(String villeNom) {
        this.villeNom = villeNom;
    }

    @Basic
    @Column(name = "ville_nom_simple", nullable = true, length = 45)
    public String getVilleNomSimple() {
        return villeNomSimple;
    }

    public void setVilleNomSimple(String villeNomSimple) {
        this.villeNomSimple = villeNomSimple;
    }

    @Basic
    @Column(name = "ville_nom_reel", nullable = true, length = 45)
    public String getVilleNomReel() {
        return villeNomReel;
    }

    public void setVilleNomReel(String villeNomReel) {
        this.villeNomReel = villeNomReel;
    }

    @Basic
    @Column(name = "ville_nom_soundex", nullable = true, length = 20)
    public String getVilleNomSoundex() {
        return villeNomSoundex;
    }

    public void setVilleNomSoundex(String villeNomSoundex) {
        this.villeNomSoundex = villeNomSoundex;
    }

    @Basic
    @Column(name = "ville_nom_metaphone", nullable = true, length = 22)
    public String getVilleNomMetaphone() {
        return villeNomMetaphone;
    }

    public void setVilleNomMetaphone(String villeNomMetaphone) {
        this.villeNomMetaphone = villeNomMetaphone;
    }

    @Basic
    @Column(name = "ville_code_postal", nullable = true, length = 150)
    public String getVilleCodePostal() {
        return villeCodePostal;
    }

    public void setVilleCodePostal(String villeCodePostal) {
        this.villeCodePostal = villeCodePostal;
    }

    @Basic
    @Column(name = "ville_commune", nullable = true, length = 3)
    public String getVilleCommune() {
        return villeCommune;
    }

    public void setVilleCommune(String villeCommune) {
        this.villeCommune = villeCommune;
    }

    @Basic
    @Column(name = "ville_code_commune", nullable = false, length = 5)
    public String getVilleCodeCommune() {
        return villeCodeCommune;
    }

    public void setVilleCodeCommune(String villeCodeCommune) {
        this.villeCodeCommune = villeCodeCommune;
    }

    @Basic
    @Column(name = "ville_arrondissement", nullable = true)
    public Short getVilleArrondissement() {
        return villeArrondissement;
    }

    public void setVilleArrondissement(Short villeArrondissement) {
        this.villeArrondissement = villeArrondissement;
    }

    @Basic
    @Column(name = "ville_canton", nullable = true, length = 4)
    public String getVilleCanton() {
        return villeCanton;
    }

    public void setVilleCanton(String villeCanton) {
        this.villeCanton = villeCanton;
    }

    @Basic
    @Column(name = "ville_amdi", nullable = true)
    public Short getVilleAmdi() {
        return villeAmdi;
    }

    public void setVilleAmdi(Short villeAmdi) {
        this.villeAmdi = villeAmdi;
    }

    @Basic
    @Column(name = "ville_population_2010", nullable = true)
    public Integer getVillePopulation2010() {
        return villePopulation2010;
    }

    public void setVillePopulation2010(Integer villePopulation2010) {
        this.villePopulation2010 = villePopulation2010;
    }

    @Basic
    @Column(name = "ville_population_1999", nullable = true)
    public Integer getVillePopulation1999() {
        return villePopulation1999;
    }

    public void setVillePopulation1999(Integer villePopulation1999) {
        this.villePopulation1999 = villePopulation1999;
    }

    @Basic
    @Column(name = "ville_population_2012", nullable = true)
    public Integer getVillePopulation2012() {
        return villePopulation2012;
    }

    public void setVillePopulation2012(Integer villePopulation2012) {
        this.villePopulation2012 = villePopulation2012;
    }

    @Basic
    @Column(name = "ville_densite_2010", nullable = true)
    public Integer getVilleDensite2010() {
        return villeDensite2010;
    }

    public void setVilleDensite2010(Integer villeDensite2010) {
        this.villeDensite2010 = villeDensite2010;
    }

    @Basic
    @Column(name = "ville_surface", nullable = true, precision = 0)
    public Double getVilleSurface() {
        return villeSurface;
    }

    public void setVilleSurface(Double villeSurface) {
        this.villeSurface = villeSurface;
    }

    @Basic
    @Column(name = "ville_longitude_deg", nullable = true, precision = 0)
    public Double getVilleLongitudeDeg() {
        return villeLongitudeDeg;
    }

    public void setVilleLongitudeDeg(Double villeLongitudeDeg) {
        this.villeLongitudeDeg = villeLongitudeDeg;
    }

    @Basic
    @Column(name = "ville_latitude_deg", nullable = true, precision = 0)
    public Double getVilleLatitudeDeg() {
        return villeLatitudeDeg;
    }

    public void setVilleLatitudeDeg(Double villeLatitudeDeg) {
        this.villeLatitudeDeg = villeLatitudeDeg;
    }

    @Basic
    @Column(name = "ville_longitude_grd", nullable = true, length = 9)
    public String getVilleLongitudeGrd() {
        return villeLongitudeGrd;
    }

    public void setVilleLongitudeGrd(String villeLongitudeGrd) {
        this.villeLongitudeGrd = villeLongitudeGrd;
    }

    @Basic
    @Column(name = "ville_latitude_grd", nullable = true, length = 8)
    public String getVilleLatitudeGrd() {
        return villeLatitudeGrd;
    }

    public void setVilleLatitudeGrd(String villeLatitudeGrd) {
        this.villeLatitudeGrd = villeLatitudeGrd;
    }

    @Basic
    @Column(name = "ville_longitude_dms", nullable = true, length = 9)
    public String getVilleLongitudeDms() {
        return villeLongitudeDms;
    }

    public void setVilleLongitudeDms(String villeLongitudeDms) {
        this.villeLongitudeDms = villeLongitudeDms;
    }

    @Basic
    @Column(name = "ville_latitude_dms", nullable = true, length = 8)
    public String getVilleLatitudeDms() {
        return villeLatitudeDms;
    }

    public void setVilleLatitudeDms(String villeLatitudeDms) {
        this.villeLatitudeDms = villeLatitudeDms;
    }

    @Basic
    @Column(name = "ville_zmin", nullable = true)
    public Integer getVilleZmin() {
        return villeZmin;
    }

    public void setVilleZmin(Integer villeZmin) {
        this.villeZmin = villeZmin;
    }

    @Basic
    @Column(name = "ville_zmax", nullable = true)
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
        VilleEntity that = (VilleEntity) o;
        return id == that.id &&
                Objects.equals(villeDepartement, that.villeDepartement) &&
                Objects.equals(villeSlug, that.villeSlug) &&
                Objects.equals(villeNom, that.villeNom) &&
                Objects.equals(villeNomSimple, that.villeNomSimple) &&
                Objects.equals(villeNomReel, that.villeNomReel) &&
                Objects.equals(villeNomSoundex, that.villeNomSoundex) &&
                Objects.equals(villeNomMetaphone, that.villeNomMetaphone) &&
                Objects.equals(villeCodePostal, that.villeCodePostal) &&
                Objects.equals(villeCommune, that.villeCommune) &&
                Objects.equals(villeCodeCommune, that.villeCodeCommune) &&
                Objects.equals(villeArrondissement, that.villeArrondissement) &&
                Objects.equals(villeCanton, that.villeCanton) &&
                Objects.equals(villeAmdi, that.villeAmdi) &&
                Objects.equals(villePopulation2010, that.villePopulation2010) &&
                Objects.equals(villePopulation1999, that.villePopulation1999) &&
                Objects.equals(villePopulation2012, that.villePopulation2012) &&
                Objects.equals(villeDensite2010, that.villeDensite2010) &&
                Objects.equals(villeSurface, that.villeSurface) &&
                Objects.equals(villeLongitudeDeg, that.villeLongitudeDeg) &&
                Objects.equals(villeLatitudeDeg, that.villeLatitudeDeg) &&
                Objects.equals(villeLongitudeGrd, that.villeLongitudeGrd) &&
                Objects.equals(villeLatitudeGrd, that.villeLatitudeGrd) &&
                Objects.equals(villeLongitudeDms, that.villeLongitudeDms) &&
                Objects.equals(villeLatitudeDms, that.villeLatitudeDms) &&
                Objects.equals(villeZmin, that.villeZmin) &&
                Objects.equals(villeZmax, that.villeZmax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, villeDepartement, villeSlug, villeNom, villeNomSimple, villeNomReel, villeNomSoundex, villeNomMetaphone, villeCodePostal, villeCommune, villeCodeCommune, villeArrondissement, villeCanton, villeAmdi, villePopulation2010, villePopulation1999, villePopulation2012, villeDensite2010, villeSurface, villeLongitudeDeg, villeLatitudeDeg, villeLongitudeGrd, villeLatitudeGrd, villeLongitudeDms, villeLatitudeDms, villeZmin, villeZmax);
    }

    @OneToMany(mappedBy = "villeByIdVille")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public Collection<PersonneEntity> getPersonnesById() {
        return personnesById;
    }

    public void setPersonnesById(Collection<PersonneEntity> personnesById) {
        this.personnesById = personnesById;
    }
}
