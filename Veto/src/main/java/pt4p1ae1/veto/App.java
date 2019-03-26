package pt4p1ae1.veto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

public final class App extends Application {

    /**
     * The session factory.
     */
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Get a hibernate session to work with.
     *
     * @return an opened session
     * @throws HibernateException when a hibernate related exeption occurs
     */
    public static Session getSession() throws HibernateException {
        return SESSION_FACTORY.openSession();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/authentification.fxml"));
        primaryStage.setTitle("VetoGestion");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.getIcons().add(new Image("img/icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        new Thread(() -> {
            try (Session session = getSession()) {
                final Metamodel metamodel = session.getSessionFactory()
                        .getMetamodel();
                for (EntityType<?> entityType : metamodel.getEntities()) {
                    final String entityName = entityType.getName();
                    final Query query = session
                            .createQuery("from " + entityName);
                }
            }
        }).start();
        launch(args);
    }
}
