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

    public ResultSet getEmployes(){
        try{
            String query = "SELECT E.idConnexion as login, E.motDePasse as mdp FROM Employe E ";
            return st.executeQuery(query);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
