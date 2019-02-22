package pt4p1ae1.veto.DAO;

import pt4p1ae1.veto.Entity.Client;

import java.util.List;

/**
 * Data Access Object of {@link pt4p1ae1.veto.Entity.Client}.
 */
public interface ClientDAO {
    /**
     * Persists client.
     *
     * @param client object to persist
     */
    void saveOrUpdate(Client client);

    /**
     * @return the full client list
     */
    List<Client> findAll();

    /**
     * @param name the searched name, must be case sensitive and exact match.
     *             Null name returns null result
     * @return the room or null if nothing found
     */
    Client findByName(String name);
}
