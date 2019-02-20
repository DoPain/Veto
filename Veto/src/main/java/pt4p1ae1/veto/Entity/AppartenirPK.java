package pt4p1ae1.veto.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AppartenirPK implements Serializable {
    private long idOrdonnance;
    private short idProduit;

    @Column(name = "idOrdonnance")
    @Id
    public long getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Column(name = "idProduit")
    @Id
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
        AppartenirPK that = (AppartenirPK) o;
        return idOrdonnance == that.idOrdonnance &&
                idProduit == that.idProduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrdonnance, idProduit);
    }
}
