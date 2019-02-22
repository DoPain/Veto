package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Ordonnance;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Ordonnance}.
 */
public interface OrdonnanceDAO {
    /**
     * Persists ordonnance.
     *
     * @param ordonnance object to persist
     */
    void saveOrUpdate(Ordonnance ordonnance);

    /**
     * @return the full Ordonnance list
     */
    List<Ordonnance> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Ordonnance findByName(String name);
}
