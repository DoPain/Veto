package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Produit;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Produit}.
 */
public interface ProduitDAO {
    /**
     * Persists produit.
     *
     * @param produit object to persist
     */
    void saveOrUpdate(Produit produit);

    /**
     * @return the full produit list
     */
    List<Produit> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Produit findByName(String name);
}
