package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Conge;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Conge}.
 */
public interface CongeDAO {
    /**
     * Persists conge.
     *
     * @param conge object to persist
     */
    void saveOrUpdate(Conge conge);

    /**
     * @return the full conge list
     */
    List<Conge> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Conge findByName(String name);
}
