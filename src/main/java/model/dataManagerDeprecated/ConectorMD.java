package model.dataManagerDeprecated;

import java.sql.Connection;
import java.sql.DriverManager;

//HOST 10.0.0.21
//PUERTO 1521
public class ConectorMD {
    public Connection conectarOracle() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String baseDeBatos = "jdbc:oracle:thin:@10.0.0.21:1521:XE";
            connection = DriverManager.getConnection(baseDeBatos, "C##1DAWRUIZ", "1234");
            if (connection != null) System.out.println("Conexión realizada con éxito");
        } catch (Exception e) {
            System.out.println("FALLOOOOO EXCEPCION!!!");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection conectarMySQL() {
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesojava?user=root&password=1234");
            if (conexion != null) System.out.println("Conexión realizada con éxito");
        } catch (Exception e) {
            System.out.println("FALLOOOOO EXCEPCION!!!");
            e.printStackTrace();
        }
        return conexion;
    }
}
