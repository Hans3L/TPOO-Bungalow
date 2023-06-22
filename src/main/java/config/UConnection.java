package main.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {

                ResourceBundle rb = ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String user = rb.getString("user");
                String pass = rb.getString("pass");

                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pass);
            }
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

}
