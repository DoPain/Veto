package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.VilleDAO;
import pt4p1ae1.veto.Entity.Ville;
import pt4p1ae1.veto.Entity.Ville_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.VilleDAO}.
 */
@Singleton
public class VilleDAOImp implements VilleDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Ville ville) {
        this.em.get().persist(ville);
    }

    @Override
    @Transactional
    public List<Ville> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Ville.class.getName());
        List<Ville> villes =
                em.get().createQuery(query.toString()).getResultList();
        return villes;
    }

    @Override
    public Ville findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Ville.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Ville_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Ville) resultList.get(0);
        }
        return null;
    }
}
