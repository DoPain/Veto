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

    /**
     * Création des DAO depuis le DaoFactory pour chaque entité utile à l'affichage.
     */
    public static final EntityDao<ClientEntity> CLIENT_DAO = DaoFactory.getDaoFor(ClientEntity.class);
    public static final EntityDao<LogEntity> LOG_DAO = DaoFactory.getDaoFor(LogEntity.class);
    public static final EntityDao<PersonneEntity> PERSONNE_DAO = DaoFactory.getDaoFor(PersonneEntity.class);
    public static final EntityDao<AnimalEntity> ANIMAL_DAO = DaoFactory.getDaoFor(AnimalEntity.class);
    public static final EntityDao<RendezVousEntity> RENDEZ_VOUS_DAO = DaoFactory.getDaoFor(RendezVousEntity.class);
    public static final EntityDao<EspeceEntity> ESPECE_DAO = DaoFactory.getDaoFor(EspeceEntity.class);
    public static final EntityDao<RaceEntity> RACE_DAO= DaoFactory.getDaoFor(RaceEntity.class);
    public static final EntityDao<OrdonnanceEntity> ORDONNANCE_DAO = DaoFactory.getDaoFor(OrdonnanceEntity.class);
    public static final EntityDao<TraitementEntity> TRAITEMENT_DAO = DaoFactory.getDaoFor(TraitementEntity.class);
    public static final EntityDao<EmployeEntity> EMPLOYE_DAO = DaoFactory.getDaoFor(EmployeEntity.class);
    public static final EntityDao<VeterinaireEntity> VETERINAIRE_DAO = DaoFactory.getDaoFor(VeterinaireEntity.class);
    public static final EntityDao<ProduitEntity> PRODUIT_DAO = DaoFactory.getDaoFor(ProduitEntity.class);
    public static final EntityDao<AppartenirEntity> APPARTENIR_DAO = DaoFactory.getDaoFor(AppartenirEntity.class);
    public static final EntityDao<VilleEntity> VILLE_DAO = DaoFactory.getDaoFor(VilleEntity.class);

    /**
     * Taille de la fênetre de l'application.
     */
    public static final double WIDTH = 1280;
    public static final double HEIGHT = 800;

    private static boolean admin = true;


    private static EmployeEntity actualEmploye;
    public static ClientEntity currentClient;
    private static AnimalEntity currentAnimal;
    private static ProduitEntity currentProduit;
    private static TraitementEntity currentTraitement;

    private static boolean confirmation;

    private static boolean modifyAnimal = false;
    private static boolean modifyDisease = false;

    /**
     * Fonction gérant la création de logs pour chaque action faite par l'employé connecté
     * @param action une phrase résumant son action.
     */
    public static void createLog(String action) {
        new Thread(() -> {
            LogEntity log = new LogEntity();
            log.setAction(action);
            log.setTemps(Timestamp.from(Instant.now()));
            log.setIdEmploye(actualEmploye.getId());
            DaoFactory.getDaoFor(LogEntity.class).saveOrUpdate(log);
        }).start();
    }

    /**
     * Fonction calculant l'age en année depuis une date de naissance.
     *
     * @param naissance la date de naissance à exploité
     * @return la différence d'année entre la date de naissance et la date actuelle
     */
    public static String calculateAge(Date naissance) {
        LocalDate now = LocalDate.now();
        return String.valueOf(Period.between(naissance.toLocalDate(), now).getYears());
    }

    /**
     * Fonction retournant le prochain rendez-vous d'un animal.
     *
     * @param idAnimal l'identifiant de l'animal concerné
     * @return le rendez-vous le plus proche de la date actuelle
     */
    public static RendezVousEntity getNextRDVAnimal(long idAnimal) {
        List<RendezVousEntity> allRdv = Utils.RENDEZ_VOUS_DAO.findAll();
        Iterator<RendezVousEntity> it = allRdv.iterator();
        boolean found = false;
        RendezVousEntity next = null;
        RendezVousEntity nextRDV = null;
        while (!found && it.hasNext()) {
            next = it.next();
            if (null != next.getIdAnimal() && next.getIdAnimal() == idAnimal) {
                   nextRDV = next;
                   found = true;
            }
        }
        if (found) return nextRDV;
        else return null;
    }

    /**
     * Fonction retournant la liste de tous les animaux d'un client depuis son id.
     *
     * @param idClient l'id du client concerné
     * @return la liste de tous ses animaux
     */
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

    /**
     * Setter du boolean admin.
     *
     * @param admin si l'employé qui se connecte est admin ou non
     */
    public static void setAdmin(boolean admin) {
        Utils.admin = admin;
    }

    /**
     * Setter de actual Employe.
     *
     * @param actualEmploye l'employé actuellement connecté
     */
    public static void setActualEmploye(EmployeEntity actualEmploye) {
        Utils.actualEmploye = actualEmploye;
    }

    /**
     * Setter de current animal.
     *
     * @param currentAnimal l'animal utilisé
     */
    public static void setCurrentAnimal(AnimalEntity currentAnimal) {
        Utils.currentAnimal = currentAnimal;
    }

    /**
     * Getter de l'attribut admin.
     *
     * @return l'attribut admin
     */
    public static boolean isAdmin() {
        return admin;
    }

    /**
     * Getter de l'actual Employé.
     *
     * @return l'employé actuellement connecté
     */
    public static EmployeEntity getActualEmploye() {
        return actualEmploye;
    }

    /**
     * Getter de current animal.
     *
     * @return l'animal actuellement modifié, créé ou utilisé
     */
    public static AnimalEntity getCurrentAnimal() {
        return currentAnimal;
    }

    /**
     * Getter de modifyAnimal.
     *
     * @return si on modifie un animal ou non
     */
    public static boolean isModifyAnimal() {
        return modifyAnimal;
    }

    /**
     * Setter de modify Animal.
     *
     * @param modifyAnimal vrai si on modifie un animal
     */
    public static void setModifyAnimal(boolean modifyAnimal) {
        Utils.modifyAnimal = modifyAnimal;
    }

    /**
     * Getter de currentProduit.
     *
     * @return le produit actuel que l'on modifie, crée ou utilise
     */
    public static ProduitEntity getCurrentProduit() {
        return currentProduit;
    }

    /**
     * Setter  de currentProduit.
     *
     * @param currentProduit le produit actuel que l'on modifie, crée ou utilise
     */
    public static void setCurrentProduit(ProduitEntity currentProduit) {
        Utils.currentProduit = currentProduit;
    }

    /**
     * Getter de modifyDisease.
     *
     * @return vrai si on modifie une maladie
     */
    public static boolean isModifyDisease() {
        return modifyDisease;
    }

    /**
     * Setter de modifyDisease.
     *
     * @param modifyDisease vrai si on modifie une maladie
     */
    public static void setModifyDisease(boolean modifyDisease) {
        Utils.modifyDisease = modifyDisease;
    }

    /**
     * Getter de currentTraitement.
     *
     * @return le traitement actuel que l'on modifie, crée ou utilise
     */
    public static TraitementEntity getCurrentTraitement() {
        return currentTraitement;
    }

    /**
     * Setter de currentTraitement.
     *
     * @param currentTraitement le traitement actuel que l'on modifie, crée ou utilise
     */
    public static void setCurrentTraitement(TraitementEntity currentTraitement) {
        Utils.currentTraitement = currentTraitement;
    }

    /**
     * Getter de confirmation.
     *
     * @return si on confirme l'action en cours ou non.
     */
    public static boolean getConfirmation() {
        return confirmation;
    }

    /**
     * Setter de confirmation.
     *
     * @param confirmation vrai si on appuis sur la confirmation du popUp
     */
    public static void setConfirmation(boolean confirmation) {
        Utils.confirmation = confirmation;
    }
}
