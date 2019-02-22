package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Race;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Race}.
 */
public interface RaceDAO {
    /**
     * Persists race.
     *
     * @param race object to persist
     */
    void saveOrUpdate(Race race);

    /**
     * @return the full race list
     */
    List<Race> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Race findByName(String name);
}
