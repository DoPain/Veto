package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.CongeDAO;
import pt4p1ae1.veto.Entity.Conge;
import pt4p1ae1.veto.Entity.Conge_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.CongeDAO}.
 */
@Singleton
public class CongeDAOImp implements CongeDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Conge conge) {
        this.em.get().persist(conge);
    }

    @Override
    @Transactional
    public List<Conge> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Conge.class.getName());
        List<Conge> conges =
                em.get().createQuery(query.toString()).getResultList();
        return conges;
    }

    @Override
    public Conge findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Conge.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Conge_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Conge) resultList.get(0);
        }
        return null;
    }
}
