package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Animal;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Animal}.
 */
public interface AnimalDAO {
    /**
     * Persists animal.
     *
     * @param animal object to persist
     */
    void saveOrUpdate(Animal animal);

    /**
     * @return the full animals list
     */
    List<Animal> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Animal findByName(String name);
}
