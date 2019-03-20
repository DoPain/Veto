package pt4p1ae1.veto.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Panier", schema = "PT_S4P1A_E1", catalog = "")
public class PanierEntity {
    private long id;
    private long idClient;
    private long idEmploye;
    private Date date;
    private double montantTotal;
    private CommanderEntity commanderById;
    private ClientEntity clientByIdClient;
    private EmployeEntity employeByIdEmploye;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idClient", nullable = false)
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
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
    @Column(name = "DATE", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "montantTotal", nullable = false, precision = 2)
    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanierEntity that = (PanierEntity) o;
        return id == that.id &&
                idClient == that.idClient &&
                idEmploye == that.idEmploye &&
                Double.compare(that.montantTotal, montantTotal) == 0 &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, idEmploye, date, montantTotal);
    }

    @OneToOne(mappedBy = "panierById")
    public CommanderEntity getCommanderById() {
        return commanderById;
    }

    public void setCommanderById(CommanderEntity commanderById) {
        this.commanderById = commanderById;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "idClient", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "idEmploye", referencedColumnName = "id", nullable = false)
    public EmployeEntity getEmployeByIdEmploye() {
        return employeByIdEmploye;
    }

    public void setEmployeByIdEmploye(EmployeEntity employeByIdEmploye) {
        this.employeByIdEmploye = employeByIdEmploye;
    }
}
