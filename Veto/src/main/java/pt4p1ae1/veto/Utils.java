package pt4p1ae1.veto;

import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.DAO.EntityDao;
import pt4p1ae1.veto.Entity.*;

import java.sql.Timestamp;
import java.time.Instant;

public class Utils {
    public static final EntityDao<ClientEntity> clientDao = DaoFactory.getDaoFor(ClientEntity.class);
    public static final EntityDao<PersonneEntity> personneDao = DaoFactory.getDaoFor(PersonneEntity.class);
    public static final EntityDao<AnimalEntity> animalDao = DaoFactory.getDaoFor(AnimalEntity.class);
    public static final EntityDao<EspeceEntity> especeDao = DaoFactory.getDaoFor(EspeceEntity.class);
    public static final EntityDao<RaceEntity> raceDao = DaoFactory.getDaoFor(RaceEntity.class);
    public static final EntityDao<OrdonnanceEntity> ordonnanceDao = DaoFactory.getDaoFor(OrdonnanceEntity.class);
    public static final EntityDao<TraitementEntity> traitementDao = DaoFactory.getDaoFor(TraitementEntity.class);
    public static final EntityDao<EmployeEntity> employeDao = DaoFactory.getDaoFor(EmployeEntity.class);

    public static boolean admin;
    public static EmployeEntity actualEmploye;
    public static AnimalEntity currentAnimal;

    public static void createLog(String action) {
        LogEntity log = new LogEntity();
        log.setAction(action);
        log.setTemps(Timestamp.from(Instant.now()));
        log.setIdEmploye(actualEmploye.getId());
        DaoFactory.getDaoFor(LogEntity.class).saveOrUpdate(log);
    }
}
