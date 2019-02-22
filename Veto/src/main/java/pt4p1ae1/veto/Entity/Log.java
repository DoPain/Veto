package pt4p1ae1.veto.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Log {
    private long idLog;
    private long idEmploye;
    private Timestamp temps;
    private String action;

    @Id
    @Column(name = "idLog")
    public long getIdLog() {
        return idLog;
    }

    public void setIdLog(long idLog) {
        this.idLog = idLog;
    }

    @Basic
    @Column(name = "idEmploye")
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "temps")
    public Timestamp getTemps() {
        return temps;
    }

    public void setTemps(Timestamp temps) {
        this.temps = temps;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return idLog == log.idLog &&
                idEmploye == log.idEmploye &&
                Objects.equals(temps, log.temps) &&
                Objects.equals(action, log.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLog, idEmploye, temps, action);
    }
}
