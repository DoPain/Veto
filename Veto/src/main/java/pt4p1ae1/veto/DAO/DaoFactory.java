package pt4p1ae1.veto.DAO;

import com.google.inject.persist.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pt4p1ae1.veto.App;

import java.util.List;

public class DaoFactory {

    public static <T> EntityDao<T> getDaoFor(Class<T> clazz) {
        String className = clazz.getSimpleName();

        return new EntityDao<T>() {
            @Override
            @Transactional
            public void saveOrUpdate(T entity) {
                Session session = App.getSession();
                session.beginTransaction();
                session.saveOrUpdate(entity);
                session.getTransaction().commit();
                session.close();
            }

            @Override
            @Transactional
            public void delete(T entity) {
                Session session = App.getSession();
                session.beginTransaction();
                session.delete(entity);
                session.getTransaction().commit();
                session.close();
            }

            @Override
            @Transactional
            public List<T> findAll() {
                Session session = App.getSession();
                Query query = session.createQuery("from " + className);
                List<T> all = query.list();
                session.close();
                return all;
            }

            @Override
            @Transactional
            public T findById(Long id) {
                Session session = App.getSession();
                Query query = session.createQuery("from " + className + " where " + className + ".id" + "= :name")
                        .setParameter("name", id);
                T entity = (T) query.getResultList().get(0);
                session.close();
                return entity;
            }

            @Override
            @Transactional
            public void removeAll() {
                Session session = App.getSession();
                session.beginTransaction();
                Query query = session.createQuery("delete from " + className);
                query.executeUpdate();
                session.getTransaction().commit();
                session.close();
            }
        };
    }

}
