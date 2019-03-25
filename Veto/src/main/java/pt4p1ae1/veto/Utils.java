package pt4p1ae1.veto;

import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {
    public static final EntityDao<ClientEntity> CLIENT_DAO = DaoFactory.getDaoFor(ClientEntity.class);
    public static final EntityDao<LogEntity> LOG_DAO = DaoFactory.getDaoFor(LogEntity.class);
    public static final EntityDao<PersonneEntity> PERSONNE_DAO = DaoFactory.getDaoFor(PersonneEntity.class);
    public static final EntityDao<AnimalEntity> ANIMAL_DAO = DaoFactory.getDaoFor(AnimalEntity.class);
    public static final EntityDao<RendezVousEntity> AVOIR_RENDEZ_VOUS_DAO = DaoFactory.getDaoFor(RendezVousEntity.class);
    public static final EntityDao<EspeceEntity> ESPECE_DAO = DaoFactory.getDaoFor(EspeceEntity.class);
    public static final EntityDao<RaceEntity> RACE_DAO= DaoFactory.getDaoFor(RaceEntity.class);
    public static final EntityDao<OrdonnanceEntity> ORDONNANCE_DAO = DaoFactory.getDaoFor(OrdonnanceEntity.class);
    public static final EntityDao<TraitementEntity> TRAITEMENT_DAO = DaoFactory.getDaoFor(TraitementEntity.class);
    public static final EntityDao<EmployeEntity> EMPLOYE_DAO = DaoFactory.getDaoFor(EmployeEntity.class);
    public static final EntityDao<VeterinaireEntity> VETERINAIRE_DAO = DaoFactory.getDaoFor(VeterinaireEntity.class);
    public static final EntityDao<ProduitEntity> PRODUIT_DAO = DaoFactory.getDaoFor(ProduitEntity.class);

    public static final double WIDTH = 1280;
    public static final double HEIGHT = 800;

    private static boolean admin = true;
    private static EmployeEntity actualEmploye;
    private static AnimalEntity currentAnimal;
    private static ProduitEntity currentProduit;

    private static boolean modifyAnimal = false;

    public static void createLog(String action) {
        new Thread(() -> {
            LogEntity log = new LogEntity();
            log.setAction(action);
            log.setTemps(Timestamp.from(Instant.now()));
            log.setIdEmploye(actualEmploye.getId());
            DaoFactory.getDaoFor(LogEntity.class).saveOrUpdate(log);
        }).start();
    }

    public static String calculateAge(Date naissance) {
        LocalDate now = LocalDate.now();
        return String.valueOf(Period.between(naissance.toLocalDate(), now).getYears());
    }

    public static List<RendezVousEntity> getRDVAnimal(long idAnimal) {
        Iterator<RendezVousEntity> allRDV = Utils.AVOIR_RENDEZ_VOUS_DAO.findAll().iterator();
        List<RendezVousEntity> allRDVAnimal = null;
        while (allRDV.hasNext()) {
            RendezVousEntity rdv = allRDV.next();
            if (rdv.getIdAnimal() == idAnimal) {
                allRDVAnimal.add(rdv);
            }
        }
        return allRDVAnimal;
    }

    public static List<AnimalEntity> getAnimalFromClient(long idClient){
        List<AnimalEntity> allAnimal = Utils.ANIMAL_DAO.findAll();
        List<AnimalEntity> animals = new ArrayList<>();
        for (AnimalEntity animal : allAnimal) {
            if (animal.getClientByIdClient().getId() == idClient) {
                animals.add(animal);
            }
        }
        return animals;
    }

    public static void setAdmin(boolean admin) {
        Utils.admin = admin;
    }

    public static void setActualEmploye(EmployeEntity actualEmploye) {
        Utils.actualEmploye = actualEmploye;
    }

    public static void setCurrentAnimal(AnimalEntity currentAnimal) {
        Utils.currentAnimal = currentAnimal;
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static EmployeEntity getActualEmploye() {
        return actualEmploye;
    }

    public static AnimalEntity getCurrentAnimal() {
        return currentAnimal;
    }

    public static boolean isModifyAnimal() {
        return modifyAnimal;
    }

    public static void setModifyAnimal(boolean modifyAnimal) {
        Utils.modifyAnimal = modifyAnimal;
    }

    public static ProduitEntity getCurrentProduit() {
        return currentProduit;
    }

    public static void setCurrentProduit(ProduitEntity currentProduit) {
        Utils.currentProduit = currentProduit;
    }
}
