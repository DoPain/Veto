package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.CommanderPKDAO;
import pt4p1ae1.veto.Entity.CommanderPK;
import pt4p1ae1.veto.Entity.CommanderPK_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.CommanderPKDAO}.
 */
@Singleton
public class CommanderPKDAOImp implements CommanderPKDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(CommanderPK commanderPK) {
        this.em.get().persist(commanderPK);
    }

    @Override
    @Transactional
    public List<CommanderPK> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(CommanderPK.class.getName());
        List<CommanderPK> commanderPKS =
                em.get().createQuery(query.toString()).getResultList();
        return commanderPKS;
    }

    @Override
    public CommanderPK findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(CommanderPK.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(CommanderPK_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (CommanderPK) resultList.get(0);
        }
        return null;
    }
}
