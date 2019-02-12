package pt4p1ae1.veto;

import java.sql.*;

public class DataBase {

    private String host;
    private final String name;
    private final String user;
    private final String pass;
    private final String url;
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public DataBase() {

        this.host = DBPortable.setHost();
        this.name = "PT_S4P1A_E1";
        this.user = "PT_S4P1A_E1";
        this.pass = "cBYW9Gus";
        this.url = "jdbc:mysql://" + host + "/" + name;
        connexion();
    }

    public void connexion() {
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
        try {
            String query = "SELECT E.nom as nomEspece, R.nom as nomRace FROM Race R INNER JOIN Espece E ON R.idEspece = E.idEspece";
            return st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return null;
    }

    public ResultSet getLog() {
        try {
            String query = "SELECT E.idConnexion, L.DATE, L.action FROM Log L INNER JOIN Employe E ON L.idEmploye = E.idEmploye";
            return st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    protected void setHost(String host) {
        this.host = host;
    }
}
