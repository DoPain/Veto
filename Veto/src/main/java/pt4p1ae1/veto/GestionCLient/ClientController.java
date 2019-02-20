package pt4p1ae1.veto.GestionCLient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pt4p1ae1.veto.ControllerSample;
import pt4p1ae1.veto.Entity.Client;
import pt4p1ae1.veto.HibernateUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController extends ControllerSample implements Initializable {

    @FXML
    VBox ClientBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Client> clients = session.createQuery("from Client").list();

        session.close();

        for (Client c : clients) {
            ClientBox.getChildren().add(new Button(c.getPersonne().getIdPersonne() + ". " + c.getPersonne().getNom() + ", " + c.getPersonne().getPrenom()));
        }
        super.start();
    }

    private void afficherClient(String s) {
        System.out.println(s);
    }
}
