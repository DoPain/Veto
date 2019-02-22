package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Log;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Log}.
 */
public interface LogDAO {
    /**
     * Persists log.
     *
     * @param log object to persist
     */
    void saveOrUpdate(Log log);

    /**
     * @return the full log list
     */
    List<Log> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Log findByName(String name);
}
