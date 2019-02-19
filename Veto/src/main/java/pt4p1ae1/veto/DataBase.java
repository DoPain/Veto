package pt4p1ae1.veto;

import java.sql.*;

public class DataBase {

    private final String host = DBPortable.setHost();
    private final String name = "PT_S4P1A_E1";
    private final String user = "PT_S4P1A_E1";
    private final String pass = "cBYW9Gus";
    private final String url = "jdbc:mysql://" + host + "/" + name;
    private Connection conn;
    private Statement st;

    public DataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRace() {
        String query = "SELECT E.nom as nomEspece, R.nom as nomRace " +
                "FROM Race R " +
                "INNER JOIN Espece E " +
                "ON R.idEspece = E.idEspece";
        return executeSQL(query);
    }

    public ResultSet getLog() {
        String query = "SELECT E.idConnexion, L.temps, L.action " +
                "FROM Log L " +
                "INNER JOIN Employe E " +
                "ON L.idEmploye = E.idEmploye";
        return executeSQL(query);
    }

    public ResultSet getEmployes() {
        String query = "SELECT E.idConnexion as login, E.motDePasse as mdp, E.idEmploye as idE FROM Employe E ";
        return executeSQL(query);
    }

    public ResultSet getShortClient() {
        String query = "SELECT P.nom, P.prenom FROM Client C" +
                " INNER JOIN Personne P ON P.idPersonne = C.idClient";
        return executeSQL(query);
    }

    public ResultSet getClient() {
        String query = "SELECT P.nom as NOM, P.prenom as PRENOM, P.adresse AS ADRESSE, " +
                "P.mail AS MAIL, P.telephone AS TEL, V.ville_nom_reel AS VILLE FROM Client C" +
                " INNER JOIN Personne P ON P.idPersonne = C.idClient" +
                " INNER JOIN Ville V ON V.idVille = P.idVille";
        return executeSQL(query);
    }

    public ResultSet executeSQL(String s) {
        try {
            String query = s;
            return st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet getIdVeterinaire() throws SQLException {
        Statement stV = conn.createStatement();
        try {
            String query = "SELECT V.idVeterinaire as idV FROM Veterinaire as V";
            return stV.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void setLog(String idEmploye, String action) {
        try {
            String query = "INSERT INTO Log(idEmploye,action)VALUES('" + idEmploye + "','" + action + "')";
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
