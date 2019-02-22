package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.CommanderPK;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.CommanderPK}.
 */
public interface CommanderPKDAO {
    /**
     * Persists commanderPK.
     *
     * @param commanderPK object to persist
     */
    void saveOrUpdate(CommanderPK commanderPK);

    /**
     * @return the full commanderPK list
     */
    List<CommanderPK> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    CommanderPK findByName(String name);
}
