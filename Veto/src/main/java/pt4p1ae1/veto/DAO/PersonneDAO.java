package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Personne;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Personne}.
 */
public interface PersonneDAO {
    /**
     * Persists personne.
     *
     * @param personne object to persist
     */
    void saveOrUpdate(Personne personne);

    /**
     * @return the full Personne list
     */
    List<Personne> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Personne findByName(String name);
}
