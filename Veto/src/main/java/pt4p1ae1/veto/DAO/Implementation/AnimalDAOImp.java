package pt4p1ae1.veto.DAO.Implementation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import pt4p1ae1.veto.DAO.AnimalDAO;
import pt4p1ae1.veto.Entity.Animal;
import pt4p1ae1.veto.Entity.Animal_;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementation of {@link pt4p1ae1.veto.DAO.AnimalDAO}.
 */
@Singleton
public class AnimalDAOImp implements AnimalDAO {

    /**
     * Entity Manager used to perform database operations.
     */
    @Inject
    private Provider<EntityManager> em;

    @Override
    @Transactional
    public void saveOrUpdate(Animal animal) {
        this.em.get().persist(animal);
    }

    @Override
    @Transactional
    public List<Animal> findAll() {
        StringBuilder query = new StringBuilder("from ");
        query.append(Animal.class.getName());
        List<Animal> animals =
                em.get().createQuery(query.toString()).getResultList();
        return animals;
    }

    @Override
    public Animal findByName(String name) {
        StringBuilder query = new StringBuilder()
                .append("from ")
                .append(Animal.class.getName())
                .append(" as room")
                .append(" where room.")
                .append(Animal_.name.getName())
                .append(" = :name");

        List resultList = em.get()
                .createQuery(query.toString())
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() > 0) {
            return (Animal) resultList.get(0);
        }
        return null;
    }
}
