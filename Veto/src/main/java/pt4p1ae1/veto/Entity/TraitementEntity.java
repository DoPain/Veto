package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Traitement", schema = "PT_S4P1A_E1", catalog = "")
public class TraitementEntity {
    private long id;
    private long idAnimal;
    private String maladie;
    private String soin;
    private Date dateDebut;
    private Date dateFin;
    private AnimalEntity animalByIdAnimal;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idAnimal", nullable = false)
    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "maladie", nullable = false, length = 255)
    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    @Basic
    @Column(name = "soin", nullable = true, length = 255)
    public String getSoin() {
        return soin;
    }

    public void setSoin(String soin) {
        this.soin = soin;
    }

    @Basic
    @Column(name = "dateDebut", nullable = false)
    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "dateFin", nullable = true)
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraitementEntity that = (TraitementEntity) o;
        return id == that.id &&
                idAnimal == that.idAnimal &&
                Objects.equals(maladie, that.maladie) &&
                Objects.equals(soin, that.soin) &&
                Objects.equals(dateDebut, that.dateDebut) &&
                Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idAnimal, maladie, soin, dateDebut, dateFin);
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idAnimal", referencedColumnName = "id", nullable = false)
    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }
}
