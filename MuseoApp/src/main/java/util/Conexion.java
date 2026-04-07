package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/museo",
                "root",
                "A091214mo.+"
            );

            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
}
