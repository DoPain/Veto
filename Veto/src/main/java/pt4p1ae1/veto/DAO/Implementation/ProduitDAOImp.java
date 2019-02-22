package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.ProduitDAO;
import pt4p1ae1.veto.Entity.Produit;
import pt4p1ae1.veto.Entity.Produit_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.ProduitDAO}.
 */
@Singleton
public class ProduitDAOImp implements ProduitDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Produit produit) {
        this.em.get().persist(produit);
    }

    @Override
    @Transactional
    public List<Produit> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Produit.class.getName());
        List<Produit> produits =
                em.get().createQuery(query.toString()).getResultList();
        return produits;
    }

    @Override
    public Produit findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Produit.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Produit_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Produit) resultList.get(0);
        }
        return null;
    }
}
