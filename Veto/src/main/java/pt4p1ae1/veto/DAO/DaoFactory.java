package pt4p1ae1.veto.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pt4p1ae1.veto.App;

import java.util.List;

public class DaoFactory {

    public static <T> EntityDao<T> getDaoFor(Class<T> clazz) {
        String className = clazz.getSimpleName();

        return new EntityDao<T>() {
            @Override
            public void saveOrUpdate(T entity) {
                Session session = App.getSession();
                session.saveOrUpdate(entity);
                session.close();
            }

            @Override
            public List<T> findAll() {
                Session session = App.getSession();
                Query query = session.createQuery("from " + className);
                return query.list();
            }

            @Override
            public T findById(Long id) {
                Session session = App.getSession();
                Query query = session.createQuery("from " + className + " where " + className + ".id" + "= :name")
                        .setParameter("name", id);
                return (T) query.getResultList().get(0);

            }
        };
    }

}
