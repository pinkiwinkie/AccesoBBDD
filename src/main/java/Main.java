import dataSource.Conector;

import javax.sql.DataSource;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
//        Conector conector = new Conector();
//        conector.conectarMySQL();
//        conector.conectarOracle();

        Connection connection = null;
        try{
            DataSource dataSource = Conector.getMySQLDataSource();
            connection = dataSource.getConnection();
            if (connection != null)
                System.out.println("acceso exitoso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
