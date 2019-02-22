package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.AvoirRendezVous;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.AvoirRendezVous}.
 */
public interface AvoirRendezVousDAO {
    /**
     * Persists avoirRendezVous.
     *
     * @param avoirRendezVous object to persist
     */
    void saveOrUpdate(AvoirRendezVous avoirRendezVous);

    /**
     * @return the full avoirRendezVous list
     */
    List<AvoirRendezVous> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    AvoirRendezVous findByName(String name);
}
