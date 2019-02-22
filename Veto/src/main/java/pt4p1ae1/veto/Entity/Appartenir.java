package pt4p1ae1.veto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(AppartenirPK.class)
public class Appartenir {
    private long idOrdonnance;
    private short idProduit;

    @Id
    @Column(name = "idOrdonnance")
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Id
    @Column(name = "idProduit")
    public short getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(short idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appartenir that = (Appartenir) o;
        return idOrdonnance == that.idOrdonnance &&
                idProduit == that.idProduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrdonnance, idProduit);
    }
}
