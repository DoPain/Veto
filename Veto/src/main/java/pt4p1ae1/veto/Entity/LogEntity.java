package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Log", schema = "PT_S4P1A_E1", catalog = "")
public class LogEntity {
    private long idLog;
    private long idEmploye;
    private Timestamp temps;
    private String action;
    private EmployeEntity employeByIdEmploye;

    @Id
    @Column(name = "idLog", nullable = false)
    public long getIdLog() {
        return idLog;
    }

    public void setIdLog(long idLog) {
        this.idLog = idLog;
    }

    @Basic
    @Column(name = "idEmploye", nullable = false)
    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "temps", nullable = false)
    public Timestamp getTemps() {
        return temps;
    }

    public void setTemps(Timestamp temps) {
        this.temps = temps;
    }

    @Basic
    @Column(name = "action", nullable = false, length = 255)
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
        LogEntity logEntity = (LogEntity) o;
        return idLog == logEntity.idLog &&
                idEmploye == logEntity.idEmploye &&
                Objects.equals(temps, logEntity.temps) &&
                Objects.equals(action, logEntity.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLog, idEmploye, temps, action);
    }

    @ManyToOne
    @JoinColumn(name = "idEmploye", referencedColumnName = "idEmploye", nullable = false)
    public EmployeEntity getEmployeByIdEmploye() {
        return employeByIdEmploye;
    }

    public void setEmployeByIdEmploye(EmployeEntity employeByIdEmploye) {
        this.employeByIdEmploye = employeByIdEmploye;
    }
}
