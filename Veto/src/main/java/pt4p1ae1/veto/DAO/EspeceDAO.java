package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Espece;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Espece}.
 */
public interface EspeceDAO {
    /**
     * Persists espece.
     *
     * @param espece object to persist
     */
    void saveOrUpdate(Espece espece);

    /**
     * @return the full espece list
     */
    List<Espece> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Espece findByName(String name);
}
