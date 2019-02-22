package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.AvoirRendezVousPKDAO;
import pt4p1ae1.veto.Entity.AvoirRendezVousPK;
import pt4p1ae1.veto.Entity.AvoirRendezVousPK_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.AvoirRendezVousPKDAO}.
 */
@Singleton
public class AvoirRendezVousPKDAOImp implements AvoirRendezVousPKDAO  {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(AvoirRendezVousPK avoirRendezVousPK) {
        this.em.get().persist(avoirRendezVousPK);
    }

    @Override
    @Transactional
    public List<AvoirRendezVousPK> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(AvoirRendezVousPK.class.getName());
        List<AvoirRendezVousPK> avoirRendezVousPKS =
                em.get().createQuery(query.toString()).getResultList();
        return avoirRendezVousPKS;
    }

    @Override
    public AvoirRendezVousPK findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(AvoirRendezVousPK.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(AvoirRendezVousPK_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (AvoirRendezVousPK) resultList.get(0);
        }
        return null;
    }
}
