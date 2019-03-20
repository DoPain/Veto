package pt4p1ae1.veto;

import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.*;

import java.sql.Timestamp;
import java.time.Instant;

public class Utils {

    private final EntityDao<ClientEntity> clientDao = DaoFactory.getDaoFor(ClientEntity.class);
    private final EntityDao<PersonneEntity> personneDao = DaoFactory.getDaoFor(PersonneEntity.class);
    private final EntityDao<AnimalEntity> animalDao = DaoFactory.getDaoFor(AnimalEntity.class);
    private final EntityDao<EspeceEntity> especeDao = DaoFactory.getDaoFor(EspeceEntity.class);
    private final EntityDao<RaceEntity> raceDao = DaoFactory.getDaoFor(RaceEntity.class);
    private final EntityDao<OrdonnanceEntity> ordonnanceDao = DaoFactory.getDaoFor(OrdonnanceEntity.class);
    private final EntityDao<TraitementEntity> traitementDao = DaoFactory.getDaoFor(TraitementEntity.class);
    private final EntityDao<EmployeEntity> employeDao = DaoFactory.getDaoFor(EmployeEntity.class);

    private static boolean admin;
    private static EmployeEntity actualEmploye;
    private static AnimalEntity currentAnimal;

    public static void createLog(String action) {
        new Thread(() -> {
            LogEntity log = new LogEntity();
            log.setAction(action);
            log.setTemps(Timestamp.from(Instant.now()));
            log.setIdEmploye(actualEmploye.getId());
            DaoFactory.getDaoFor(LogEntity.class).saveOrUpdate(log);
        }).start();
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


    public EntityDao<ClientEntity> getClientDao() {
        return clientDao;
    }

    public EntityDao<PersonneEntity> getPersonneDao() {
        return personneDao;
    }

    public EntityDao<AnimalEntity> getAnimalDao() {
        return animalDao;
    }

    public EntityDao<EspeceEntity> getEspeceDao() {
        return especeDao;
    }

    public EntityDao<RaceEntity> getRaceDao() {
        return raceDao;
    }

    public EntityDao<OrdonnanceEntity> getOrdonnanceDao() {
        return ordonnanceDao;
    }

    public EntityDao<TraitementEntity> getTraitementDao() {
        return traitementDao;
    }

    public EntityDao<EmployeEntity> getEmployeDao() {
        return employeDao;
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
}
