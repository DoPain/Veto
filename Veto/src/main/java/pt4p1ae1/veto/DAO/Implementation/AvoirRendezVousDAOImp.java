package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.AvoirRendezVousDAO;
import pt4p1ae1.veto.Entity.AvoirRendezVous;
import pt4p1ae1.veto.Entity.AvoirRendezVous_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.AvoirRendezVousDAO}.
 */
@Singleton
public class AvoirRendezVousDAOImp implements AvoirRendezVousDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(AvoirRendezVous avoirRendezVous) {
        this.em.get().persist(avoirRendezVous);
    }

    @Override
    @Transactional
    public List<AvoirRendezVous> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(AvoirRendezVous.class.getName());
        List<AvoirRendezVous> avoirRendezVouss =
                em.get().createQuery(query.toString()).getResultList();
        return avoirRendezVouss;
    }

    @Override
    public AvoirRendezVous findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(AvoirRendezVous.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(AvoirRendezVous_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (AvoirRendezVous) resultList.get(0);
        }
        return null;
    }
}
