package pt4p1ae1.veto.DAO;

import java.util.List;

/**
 * Data Access Object interface.
 */
public interface EntityDao<T> {

    /**
     * Persists entity.
     *
     * @param entity object to persist
     */
    void saveOrUpdate(T entity);

    /**
     * Remove entity.
     *
     * @param entity object to persist
     */
    void remove(T entity);

    /**
     * @return the full entity list
     */
    List<T> findAll();

    /**
     * @param id the searched id, must be case sensitive and exact match.
     *             Null id returns null result
     * @return the entity found or null if nothing found
     */
    T findById(Long id);

}
