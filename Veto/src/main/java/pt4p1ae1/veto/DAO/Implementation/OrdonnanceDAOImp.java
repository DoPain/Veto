package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.OrdonnanceDAO;
import pt4p1ae1.veto.Entity.Ordonnance;
import pt4p1ae1.veto.Entity.Ordonnance_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.OrdonnanceDAO}.
 */
@Singleton
public class OrdonnanceDAOImp implements OrdonnanceDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Ordonnance ordonnance) {
        this.em.get().persist(ordonnance);
    }

    @Override
    @Transactional
    public List<Ordonnance> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Ordonnance.class.getName());
        List<Ordonnance> ordonnances =
                em.get().createQuery(query.toString()).getResultList();
        return ordonnances;
    }

    @Override
    public Ordonnance findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Ordonnance.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Ordonnance_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Ordonnance) resultList.get(0);
        }
        return null;
    }
}
