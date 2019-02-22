package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Appartenir;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Appartenir}.
 */
public interface AppartenirDAO {
    /**
     * Persists appartenance.
     *
     * @param Appartenir object to persist
     */
    void saveOrUpdate(Appartenir Appartenir);

    /**
     * @return the full appartenances list
     */
    List<Appartenir> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Appartenir findByName(String name);
}
