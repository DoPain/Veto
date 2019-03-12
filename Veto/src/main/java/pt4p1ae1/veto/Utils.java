package pt4p1ae1.veto;

import pt4p1ae1.veto.DAO.DaoFactory;
import pt4p1ae1.veto.Entity.EmployeEntity;
import pt4p1ae1.veto.Entity.LogEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class Utils {
    public static boolean admin;
    public static EmployeEntity actualEmploye;

    public static void createLog(String action) {
        LogEntity log = new LogEntity();
        log.setAction(action);
        log.setTemps(Timestamp.from(Instant.now()));
        log.setIdEmploye(actualEmploye.getId());
        DaoFactory.getDaoFor(LogEntity.class).saveOrUpdate(log);
    }
}
