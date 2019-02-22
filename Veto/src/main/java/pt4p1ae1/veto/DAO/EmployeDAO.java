package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Employe;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Employe}.
 */
public interface EmployeDAO {
    /**
     * Persists employe.
     *
     * @param employe object to persist
     */
    void saveOrUpdate(Employe employe);

    /**
     * @return the full employe list
     */
    List<Employe> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Employe findByName(String name);
}
