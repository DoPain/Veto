package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.VeterinaireDAO;
import pt4p1ae1.veto.Entity.Veterinaire;
import pt4p1ae1.veto.Entity.Veterinaire_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.VeterinaireDAO}.
 */
@Singleton
public class VeterinaireDAOImp implements VeterinaireDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Veterinaire veterinaire) {
        this.em.get().persist(veterinaire);
    }

    @Override
    @Transactional
    public List<Veterinaire> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Veterinaire.class.getName());
        List<Veterinaire> veterinaires =
                em.get().createQuery(query.toString()).getResultList();
        return veterinaires;
    }

    @Override
    public Veterinaire findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Veterinaire.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Veterinaire_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Veterinaire) resultList.get(0);
        }
        return null;
    }
}
