package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.TraitementDAO;
import pt4p1ae1.veto.Entity.Traitement;
import pt4p1ae1.veto.Entity.Traitement_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.TraitementDAO}.
 */
@Singleton
public class TraitementDAOImp implements TraitementDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Traitement traitement) {
        this.em.get().persist(traitement);
    }

    @Override
    @Transactional
    public List<Traitement> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Traitement.class.getName());
        List<Traitement> traitements =
                em.get().createQuery(query.toString()).getResultList();
        return traitements;
    }

    @Override
    public Traitement findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Traitement.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Traitement_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Traitement) resultList.get(0);
        }
        return null;
    }
}
