package pt4p1ae1.veto.DAO;


import pt4p1ae1.veto.Entity.Panier;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Panier}.
 */
public interface PanierDAO {
    /**
     * Persists panier.
     *
     * @param panier object to persist
     */
    void saveOrUpdate(Panier panier);

    /**
     * @return the full panier list
     */
    List<Panier> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Panier findByName(String name);
}
