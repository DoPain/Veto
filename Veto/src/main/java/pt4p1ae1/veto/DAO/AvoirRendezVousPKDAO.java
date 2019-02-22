package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.AvoirRendezVousPK;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.AvoirRendezVousPK}.
 */
public interface AvoirRendezVousPKDAO {
    /**
     * Persists avoirRendezVousPK.
     *
     * @param avoirRendezVousPK object to persist
     */
    void saveOrUpdate(AvoirRendezVousPK avoirRendezVousPK);

    /**
     * @return the full avoirRendezVousPK list
     */
    List<AvoirRendezVousPK> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    AvoirRendezVousPK findByName(String name);
}
