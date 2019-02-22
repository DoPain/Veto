package pt4p1ae1.veto.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CommanderPK implements Serializable {
    private long idVente;
    private short idProduit;

    @Column(name = "idVente")
    @Id
    public long getIdVente() {
        return idVente;
    }

    public void setIdVente(long idVente) {
        this.idVente = idVente;
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
        CommanderPK that = (CommanderPK) o;
        return idVente == that.idVente &&
                idProduit == that.idProduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVente, idProduit);
    }
}
