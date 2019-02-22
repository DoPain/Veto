package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Traitement;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Traitement}.
 */
public interface TraitementDAO {
    /**
     * Persists traitement.
     *
     * @param traitement object to persist
     */
    void saveOrUpdate(Traitement traitement);

    /**
     * @return the full traitement list
     */
    List<Traitement> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Traitement findByName(String name);
}
