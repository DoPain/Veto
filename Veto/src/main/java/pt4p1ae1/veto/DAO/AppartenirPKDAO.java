package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.AppartenirPK;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.AppartenirPK}.
 */
public interface AppartenirPKDAO {
    /**
     * Persists appartenance.
     *
     * @param AppartenirPK object to persist
     */
    void saveOrUpdate(AppartenirPK AppartenirPK);

    /**
     * @return the full appartenances list
     */
    List<AppartenirPK> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    AppartenirPK findByName(String name);
}
