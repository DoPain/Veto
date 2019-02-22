package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Commander;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Commander}.
 */
public interface CommanderDAO {
    /**
     * Persists commander.
     *
     * @param commander object to persist
     */
    void saveOrUpdate(Commander commander);

    /**
     * @return the full commander list
     */
    List<Commander> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Commander findByName(String name);
}
