package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Veterinaire;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Veterinaire}.
 */
public interface VeterinaireDAO {
    /**
     * Persists veterinaire.
     *
     * @param veterinaire object to persist
     */
    void saveOrUpdate(Veterinaire veterinaire);

    /**
     * @return the full veterinaire list
     */
    List<Veterinaire> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Veterinaire findByName(String name);
}
