package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.AppartenirDAO;
import pt4p1ae1.veto.Entity.Appartenir;
import pt4p1ae1.veto.Entity.Appartenir_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.AnimalDAO}.
 */
@Singleton
public class AppartenirDAOImp implements AppartenirDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Appartenir appartenir) {
        this.em.get().persist(appartenir);
    }

    @Override
    @Transactional
    public List<Appartenir> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Appartenir.class.getName());
        List<Appartenir> animals =
                em.get().createQuery(query.toString()).getResultList();
        return animals;
    }

    @Override
    public Appartenir findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Appartenir.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Appartenir_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Appartenir) resultList.get(0);
        }
        return null;
    }
}
