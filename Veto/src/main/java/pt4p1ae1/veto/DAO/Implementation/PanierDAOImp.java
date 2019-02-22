package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.PanierDAO;
import pt4p1ae1.veto.Entity.Panier;
import pt4p1ae1.veto.Entity.Panier_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.PanierDAO}.
 */
@Singleton
public class PanierDAOImp implements PanierDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Panier panier) {
        this.em.get().persist(panier);
    }

    @Override
    @Transactional
    public List<Panier> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Panier.class.getName());
        List<Panier> paniers =
                em.get().createQuery(query.toString()).getResultList();
        return paniers;
    }

    @Override
    public Panier findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Panier.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Panier_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Panier) resultList.get(0);
        }
        return null;
    }
}
