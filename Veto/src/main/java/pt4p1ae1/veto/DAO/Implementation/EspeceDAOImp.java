package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.EspeceDAO;
import pt4p1ae1.veto.Entity.Espece;
import pt4p1ae1.veto.Entity.Espece_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.EspeceDAO}.
 */
@Singleton
public class EspeceDAOImp implements EspeceDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Espece espece) {
        this.em.get().persist(espece);
    }

    @Override
    @Transactional
    public List<Espece> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Espece.class.getName());
        List<Espece> especes =
                em.get().createQuery(query.toString()).getResultList();
        return especes;
    }

    @Override
    public Espece findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Espece.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Espece_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Espece) resultList.get(0);
        }
        return null;
    }
}
