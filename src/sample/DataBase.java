package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private String host;
    private String name;
    private String user;
    private String pass;
    private Connection conn;
    private String url;

    public DataBase(String h, String n, String u, String p){
        this.host = h;
        this.name = n;
        this.user = u;
        this.pass = p;
        this.url =
    }

    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
