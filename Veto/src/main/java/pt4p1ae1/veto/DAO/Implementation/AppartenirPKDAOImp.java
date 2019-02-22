package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.AppartenirPKDAO;
import pt4p1ae1.veto.Entity.AppartenirPK;
import pt4p1ae1.veto.Entity.AppartenirPK_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.AppartenirPKDAO}.
 */
@Singleton
public class AppartenirPKDAOImp implements AppartenirPKDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(AppartenirPK appartenirPK) {
        this.em.get().persist(appartenirPK);
    }

    @Override
    @Transactional
    public List<AppartenirPK> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(AppartenirPK.class.getName());
        List<AppartenirPK> animals =
                em.get().createQuery(query.toString()).getResultList();
        return animals;
    }

    @Override
    public AppartenirPK findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(AppartenirPK.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(AppartenirPK_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (AppartenirPK) resultList.get(0);
        }
        return null;
    }
}
