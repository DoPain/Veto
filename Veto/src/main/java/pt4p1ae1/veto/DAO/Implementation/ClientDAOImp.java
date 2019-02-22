package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.ClientDAO;
import pt4p1ae1.veto.Entity.Client;
import pt4p1ae1.veto.Entity.Client_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.ClientDAO}.
 */
@Singleton
public class ClientDAOImp implements ClientDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Client client) {
        this.em.get().persist(client);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Client.class.getName());
        List<Client> clients =
                em.get().createQuery(query.toString()).getResultList();
        return clients;
    }

    @Override
    public Client findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Client.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Client_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Client) resultList.get(0);
        }
        return null;
    }
}
