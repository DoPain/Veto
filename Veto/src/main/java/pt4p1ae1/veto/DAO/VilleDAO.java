package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Ville;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Ville}.
 */
public interface VilleDAO {
    /**
     * Persists ville.
     *
     * @param ville object to persist
     */
    void saveOrUpdate(Ville ville);

    /**
     * @return the full ville list
     */
    List<Ville> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Ville findByName(String name);
}
